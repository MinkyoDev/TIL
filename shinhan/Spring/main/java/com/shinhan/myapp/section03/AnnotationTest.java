package com.shinhan.myapp.section03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shinhan.myapp.section02.CarVO;
import com.shinhan.myapp.section02.PeopleVO;

public class AnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		CarVO car1 = ctx.getBean("carBean", CarVO.class);
		System.out.println(car1);
		
		PeopleVO people = ctx.getBean("makePeople", PeopleVO.class);
		System.out.println(people);
	}
}
