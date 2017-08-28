package com.db.mySpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 28/08/2017.
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T, E extends T> E wrapWithProxy(Class<T> type, T t) {
        return (E) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("************START BENCHMARK for method " + method.getName() + " *********************");
                long start = System.nanoTime();
                Object retVal = method.invoke(t, args);
                long end = System.nanoTime();
                System.out.println(end - start);
                System.out.println("************END BENCHMARK for method " + method.getName() + " *********************");
                return retVal;
            }
        });
    }
}
