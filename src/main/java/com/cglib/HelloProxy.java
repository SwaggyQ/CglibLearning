package com.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloProxy implements InvocationHandler {

    private Object subject;

    public HelloProxy(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy before " + method.getName());
        Object object = method.invoke(subject,args);
        System.out.println("jdk proxy after " + method.getName());
        return object;
    }
}
