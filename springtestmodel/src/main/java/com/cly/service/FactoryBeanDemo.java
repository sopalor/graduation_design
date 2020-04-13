package com.cly.service;

import com.cly.entity.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanDemo implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new Student();
	}

	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}
}
