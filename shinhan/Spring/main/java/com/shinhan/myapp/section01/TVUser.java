package com.shinhan.myapp.section01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() {
		// 미리 생성해둠. 일반적으로 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("di1.xml");
		
		TV tv1 = (TV) context.getBean("samsung1");
		TV tv2 = (TV) context.getBean("samsung2");
		TV tv3 = (TV) context.getBean("lg");

		tv1.powerOn();
		tv1.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}

	private static void f4() {
		// 메모리 관리가 좋아서 모바일 등 메모리가 적은 환경에서 사용
		Resource resource = new ClassPathResource("di1.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		TV tv1 = (TV) factory.getBean("samsung1");
		TV tv2 = (TV) factory.getBean("samsung2");
		TV tv3 = (TV) factory.getBean("lg");

		tv1.powerOn();
		tv1.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}

	private static void f3() {
		TV tv = TVFactory.makeTV("samsung");
		tv.powerOn();
		tv.powerOff();
	}

	private static void f2() {
		TV tv = new LgTV();
		// interface 패턴을 사용하면 구현객체가 변경되어도 사용법이 같다.
		tv.powerOn();
		tv.powerOff();
	}

	private static void f1() {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
	}
}
