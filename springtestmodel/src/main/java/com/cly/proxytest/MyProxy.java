package com.cly.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyProxy implements InvocationHandler {
	Object o;
	public MyProxy(Object o){
		this.o = o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("之前--------------");
		Object result = method.invoke(o);
		System.out.println("之后————————————");
		return result;
	}
}
