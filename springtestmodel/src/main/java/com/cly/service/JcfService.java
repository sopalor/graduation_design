package com.cly.service;

import com.cly.interfacetest.GxdNb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jcf")
public class JcfService implements GxdNb {
	@Override
	public void chishi() {
		System.out.println("jcf chishi");
	}

	@Override
	public void sleep() {
		System.out.println("jcf sleep");
	}

	@Autowired
	public void getCity(CityService cityService){
		cityService.chishi();
	}
}
