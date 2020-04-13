package com.cly.test;

import com.cly.app.Appconfig;
import com.cly.entity.Student;
import com.cly.service.FactoryBeanDemo;
import com.cly.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XiangXueSpringTest {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext
//				annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.cly.entity");
//		Student student = (Student)annotationConfigApplicationContext.getBean("student");
//		System.out.println(student.getName());
		ClassPathXmlApplicationContext annotationConfigApplicationContext = new ClassPathXmlApplicationContext("Spring.xml");
		annotationConfigApplicationContext.getBean(TestService.class).doSomething("啦啦啦");
		System.out.println(annotationConfigApplicationContext.getBean("factoryBeanDemo"));
		System.out.println(annotationConfigApplicationContext.getBean("&factoryBeanDemo"));
		for(int i=0;i<10;i++){
			new Thread(()->{
				System.out.println(Thread.currentThread().getId()+"->>>>>"+annotationConfigApplicationContext.getBean("myScopeBeanTest2"));
				System.out.println(Thread.currentThread().getId()+"->>>>>"+annotationConfigApplicationContext.getBean("myScopeBeanTest"));
			}).start();
		}
	}
	public void test(){
		new ClassPathXmlApplicationContext("Spring.xml");
	}
}
