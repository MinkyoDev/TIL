package com.shinhan.day11;

import com.shinhan.day10.c14_2_threadSysnchronization.Account;

// generic : 구체적인 타입을 사용시 결정, 컴파일시 강한 타입체크를 위하여, object를 사용한다면 강제 형변환이 필요하므로 비 효율적이다.

class Box<T> {

	T content;

	public Box() {
	}

	public Box(T content) {
		super();
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [content=").append(content).append("]");
		return builder.toString();
	}

}

class BigBox<T, E> extends Box<T> {

}

public class Review {

	public static void main(String[] args) {
		f4();
	}

	private static void f4() {
		// 배열은 실행시 만들어짐
		int[] arr = { 1, 2, 3, 4, 5 };
		String[] arr2 = { "A", "B", "C" };
		
		// 제네릭은 배열 생성 불가
//		Box<Account>[] b3 = new Box(Account)[10];
	}

	private static void f3() {
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(100);
//		Box<Account> box3 = call2(new Account("111", "jj", 100));
		System.out.println(box1);
		System.out.println(box2);
//		System.out.println(box3);

	}

	private static <T extends Number> Box<T> call2(T t) {
		return new Box<T>(t);
	}

	private static void f2() {
		Box<String> box1 = call("문자");
		Box<Integer> box2 = call(100);
		Box<Account> box3 = call(new Account("111", "jj", 100));
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);

	}

	private static <T> Box<T> call(T t) {
		return new Box<T>(t);
	}

	private static void f1() {
		Box<String> box1 = new Box<String>();
		Box<String> box2 = new Box<>();
		Box<Integer> box3 = new Box<>();
		Box<Account> box4 = new Box<>();

		box1.content = "String";
		box2.content = "String";
		box3.content = 14;
		Integer a = box3.content;
		Account acc = box4.content;

	}
}
