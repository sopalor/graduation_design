package com.cly.beanfactorypostprocessor;

import com.cly.proxytest.MyProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class AopTest implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("jcf")){
			Class<?> anInterface = bean.getClass().getInterfaces()[0];
			Class[] cs = new Class[]{anInterface};
			Object o = Proxy.newProxyInstance(AopTest.class.getClassLoader(),cs,new MyProxy(bean));
			return o;
		}
		return bean;
	}
}
