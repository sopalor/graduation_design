package com.cly.test;


import com.cly.app.Appconfig;
import com.cly.interfacetest.GxdNb;
import com.cly.service.CityService;
import com.cly.service.MyLogAopText;
import com.cly.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
		annotationConfigApplicationContext.getBean(MyLogAopText.class).login();
	}
}
