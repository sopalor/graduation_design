package com.cly.service;

import com.cly.aop.MyLog;
import org.springframework.stereotype.Component;

@Component
public class MyLogAopText {
	@MyLog
	public void login(){
		System.out.println("MyLogAopText login()");
	}
}
