package com.shinhan.day10.c13_1_generic;

public class GenericTest {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		// 컴파일시에 타입을 제한하기 - 잘못된 타입 입력 불가, 얻을 때 형변환이 필요없음
		Box<Integer> box1 = new Box<Integer>();
		box1.setContent(100);
//		box1.setContent("100");
		
		int a = box1.getContent();  // unboxing
		System.out.println(a);
		
		Box<String> box2 = new Box<>();  // 뒤에꺼는 생략 가능
		
	}

	private static void f1() {
		Box box1 = new Box();
		box1.setContent(100);
		box1.setContent("100");

		String str = (String) box1.getContent();
		System.out.println(str);
	}
}
