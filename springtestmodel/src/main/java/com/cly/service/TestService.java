package com.cly.service;

import com.cly.interfacetest.GxdNb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

public abstract class TestService {
	public  TestService(){
		System.out.println("test init");
	}

	public abstract GxdNb getGxd();

	public void doSomething(String something){
		System.out.println("原始方法"+something);
	}

}
