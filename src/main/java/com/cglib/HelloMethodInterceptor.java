package com.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before " + method.getName());
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib after " + method.getName());
        return object;
    }
}
