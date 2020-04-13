package com.cly.beanfactorypostprocessor;

import com.cly.app.scope.Myscope;
import com.cly.service.CityService;
import com.cly.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class ClyBeanFactorPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered , Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		GenericBeanDefinition c = (GenericBeanDefinition)beanFactory.getBeanDefinition("c");
//		System.out.println(c.getBeanClassName());
//		c.setBeanClass(TestService.class);
		beanFactory.registerScope("myScope", new Myscope());
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
	}
}
