package com.shinhan.myapp.section02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleApp {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2_1.xml");
		
		// 기본적으로 컨테이너 한 개의 bean 객체를 생성한다(singleton)
		PeopleVO p5 =ctx.getBean("people5", PeopleVO.class);
		PeopleVO p55 =ctx.getBean("people5", PeopleVO.class);
		System.out.println(p5);
		System.out.println(p5==p55);
		System.out.println(System.identityHashCode(p5));
		System.out.println(System.identityHashCode(p55));
	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		PeopleVO p2 =ctx.getBean("people2", PeopleVO.class);
		PeopleVO p5 =ctx.getBean("people5", PeopleVO.class);
//		PeopleVO p3 =ctx.getBean("people3", PeopleVO.class);
		System.out.println(p2);
		System.out.println(p5);
//		System.out.println(p3);
	}
}
