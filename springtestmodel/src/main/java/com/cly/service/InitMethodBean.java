package com.cly.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitMethodBean implements InitializingBean, BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("beanName ==>>"+name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean接口->>>>afterPropertiesSet");
	}
	@PostConstruct
	public void init(){
		System.out.println("@PostConstruct注解->> init");
	}
}
