package com.shinhan.week1.day05;

public class C6_9_SingtonTest {

	public static void main(String[] args) {
//		Singleton a = new Singleton();
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));  // 주소 같다.
	}
}
