package com.db.mySpring;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Evegeny on 28/08/2017.
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T, E extends T> E wrapWithProxy(Class<T> type, T t) {
        return (E) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return invokeProxy(t, method, args);
            }
        });
    }

    public <T, E extends T, A extends Annotation> E wrapWithProxyForMethod(Class<T> type, T t, List<Method> methods) {
        return (E) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                List<String> methodNames = methods.stream().map(it -> it.getName()).collect(Collectors.toList());

                return methodNames.contains(method.getName())
                        ? invokeProxy(t, method, args)
                        : method.invoke(t, args);
            }
        });
    }

    private <T> Object invokeProxy(T t, Method method, Object[] args) throws Throwable {
        System.out.println("************START BENCHMARK for method " + method.getName() + " *********************");
        long start = System.nanoTime();
        Object retVal = method.invoke(t, args);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("************END BENCHMARK for method " + method.getName() + " *********************");
        return retVal;
    }
}
