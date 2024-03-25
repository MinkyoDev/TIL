package com.shinhan.day09.c12_problem;

public class Problem10 {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		System.out.println(System.identityHashCode(str));
		for (int i = 1; i <= 100; i++) {
			str.append(i);
			System.out.println(System.identityHashCode(str));
		}
		System.out.println(str);
	}

	public static void f1() {
		String str = "";
		System.out.println(System.identityHashCode(str));
		for (int i = 1; i <= 100; i++) {
			str += i;
			System.out.println(System.identityHashCode(str));
		}
		System.out.println(str);
	}
}
