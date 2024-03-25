package com.shinhan.day09.c12_3_stringClass;

public class StringTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		// String : 고정 문자열
		String s1 = "이것이 자바다";
		String s2 = new String("이것이 자바다");

		byte[] arr = { 65, 66, 67, 97, 98, 99 };
		String s3 = new String(arr);

		char[] arr2 = { '가', '나', '다', '라' };
		String s4 = new String(arr2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		System.out.println(System.identityHashCode(s4));
		s4 += "!!!";
		System.out.println(System.identityHashCode(s4));
		
	}
}
