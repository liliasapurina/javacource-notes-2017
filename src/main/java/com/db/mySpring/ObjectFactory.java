package com.db.mySpring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Evegeny on 28/08/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("com.db");
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            objectConfigurators.add(aClass.newInstance());
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);
        final T t = type.newInstance();
        configure(t);
        invokeInitMethod(type, t);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return BenchmarkProxyConfigurator.class.newInstance().wrapWithProxy(type, t);
        }

        //return BenchmarkProxyConfigurator.class.newInstance().wrapWithProxyForMethod(type, t, Benchmark.class);

        List<Method> methods = new ArrayList<>();
        for (Method method : type.getMethods()) {
            if(method.isAnnotationPresent(Benchmark.class)){
                methods.add(method);
            }
        }

        return BenchmarkProxyConfigurator.class.newInstance().wrapWithProxyForMethod(type, t, methods);

        //return t;
    }


    private <T> void invokeInitMethod(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(type, method -> method.isAnnotationPresent(PostConstruct.class));
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(t);
        }
    }

    private <T> void configure(T t) {
        for (ObjectConfigurator objectConfigurator : objectConfigurators) {
            objectConfigurator.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException(type + " should have only one impl, otherwise update config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }
}










