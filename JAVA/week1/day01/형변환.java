package com.shinhan.week1.day01;

public class 형변환 {

	// byte < short = char < int < long < float < double

	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		long var1;
		int var2 = 100;

		// 자동 형변환
		var1 = var2;
		System.out.println("var1 = " + var1);

		// 4byte인 int에다가 8byte인 long을 넣을 수 없다.
		var2 = var1;

		// 강제 형변환
		var2 = (int) var1;

		// 데이터가 손실될 가능성이 있다.
		var1 = 2147483648L;
		var2 = (int) var1;
		System.out.println("var2 = " + var2);

		// 기본형은 casting하여 형변환 가능
		// 객체는 기능(함수, 메서드)를 통해 형변환
		String str = "100";
//		int i = (int) str;
		int i = Integer.parseInt(str);
		System.out.println(i);
	}

	private static void f1() {
		System.out.println("형변환에 대하여");
		// 큰 변수형에 작은 값을 넣으면 자동으로 형이 바뀐다.
		byte var2 = 100;
		int var1 = var2;
		double var3 = var1;

		System.out.println(var3);

		char ch = var1; // int가 char보다 크기 때문에 값이 들어가지 않는다.

		char ch = var2; // 기본 리터럴은 int기 때문에 들어가지 않음. 65를 읽으면 int 65가 되어버림

		// 강제 형변환
		char ch = (char) var2;

		char ch2 = '가';
		int i = ch2; // i = 4402?
		System.out.println("i = " + i);
	}
}
