package com.shinhan.day09.c12_2_systemClass;

import java.util.Properties;

public class ObjectTest2 {

	public static void main(String[] args) {
		System.out.println("main 시작");

//		f1(0);
//		f2();
		f3();

		System.out.println("main 끝");
	}

	private static void f3() {
		// Properties는 Map을 구현함 (key, value)
		// Properties의 키는 Set으로 만들어짐
		// key가 String 이었음 -> Properties (키가 object)
		System.out.println(System.getProperty("java.version"));
		
		Properties ps = System.getProperties();
		for (Object key : ps.keySet()) {
			String value = System.getProperty((String) key);
			System.out.println(key + "  ->  " + value);
		}
	}

	private static void f2() {
		long startTime = System.nanoTime();
		int total = 0;
		for (int i = 0; i < 1000000; i++) {
			total += i;
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + " ms");
	}

	private static void f1(int j) {
		System.out.println("f1 시작");

//		if (j == 0) return;
//		if (j == 0) System.exit(0); // 관례상으로 0은 정상종료, -1은 오류를 의미
//		int i = 10 / j;

		try {
			int i = 10 / j;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("f1 끝");
	}
}
