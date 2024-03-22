package com.shinhan.day09.c12_problem;

public class Problem09 {

	public static void main(String[] args) throws Exception {
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		String str = new String(bytes, "utf-8");
//		String str = new String(bytes, "euc-kr");
		System.out.println("str: " + str);
	}
}
