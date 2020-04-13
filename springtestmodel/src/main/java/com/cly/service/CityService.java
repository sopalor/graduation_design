package com.cly.service;

import com.cly.interfacetest.GxdNb;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component("c")
public class CityService implements GxdNb {
	@Autowired
	List<GxdNb> gxdNb;
	public CityService(TestService c){

	}

	public CityService(){
		System.out.println("city init");
	}
	@PostConstruct
	public void init(){
		System.out.println("city postconstruct");
	}
	@PreDestroy
	public void destory(){
		System.out.println("city destory");
	}

	@Override
	public void chishi() {
		System.out.println("city chishi");
	}

	@Override
	public void sleep() {
		System.out.println("city sleep");
	}
}
