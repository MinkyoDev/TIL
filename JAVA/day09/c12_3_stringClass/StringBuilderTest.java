package com.shinhan.day09.c12_3_stringClass;

public class StringBuilderTest {

	public static void main(String[] args) {
		f1();
	}
	private static void f1() {
		// StringBuilder , StringBuffer 직접 문자열 할당 불가
//		StringBuilder s1 = "이것이 자바다";
		
		StringBuilder s1 = new StringBuilder("이것이 자바다");
		StringBuffer s2 = new StringBuffer("이것이 자바다");
		
		System.out.println(System.identityHashCode(s1));
		s1.append("!!!");
		s1.insert(0, "###");
		System.out.println(s1);
		System.out.println(System.identityHashCode(s1));
	}
}
