package com.shinhan.week1.day01;

// System.out : 표준 출력(모니터), PrintStream
// print(), println(), printf()

public class p67 {

	public static void main(String[] args) {
		int v1 = 15;
		int v2; // 지역변수 선언하고 초기화하지 않음.

		if (v1 > 10) {
			v2 = v1 - 10;
		} else {
			v2 = 100;
		}
		
		int v3 = v1 + v2 + 5;
		System.out.println(v3);
	}
}
