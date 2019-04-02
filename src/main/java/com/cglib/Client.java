package com.cglib;

import com.cglib.base.HelloInterface;
import com.cglib.base.HelloServiceImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
        helloService.sayHello();



        System.out.println("--------jdk proxy ------");
        HelloServiceImpl helloService2 = new HelloServiceImpl();
        HelloProxy proxy = new HelloProxy(helloService2);
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance( proxy.getClass().getClassLoader(),helloService2.getClass().getInterfaces(),proxy);
        helloInterface.sayHello();
    }
}
