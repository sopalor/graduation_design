package com.cly.service;

import com.cly.entity.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("myScope")
public class MyScopeBeanTest {
}
