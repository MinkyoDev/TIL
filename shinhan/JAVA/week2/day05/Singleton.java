package com.shinhan.week1.day05;

// Singleton : 객체가 1번만 생성

public class Singleton {

	private static Singleton single;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if (single==null) {
			single = new Singleton();
		}
		return single;
	}
}
