package com.shinhan.day10;

import java.io.FileNotFoundException;

// 변수(data) + 기능(메서드)
class Machine {

	Machine() {
		super();
		System.out.println("Machine의 기본 생성자");
	}
}

// 규격서 : 상수 + 추상 메서드 + default, static, private method
interface MyInterface {

	public abstract void method1();
}

// 상속(부모의 private 제외한 모든 변수, 메서드 접근, 수정(override), 추가(이름 같고 변수가 다르다면 overloading) 가능
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable {

	CoffeeMachine() {
		System.out.println("CoffeeMachine의 기본 생성자");
	}

	@Override
	public void close() throws FileNotFoundException {
		System.out.println("AutoCloseable interface의 close() 재정의");
	}

	@Override
	public void method1() {
		System.out.println("method1 - 구현 class가 interface에서 정의한 추상 메서드를 구현");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine []");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return "Coffee".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return "Coffee".equals("Coffee");
	}
	
	

}

public class Review {

	public static void main(String[] args) {
		f1();
		f2();

	}

	private static void f2() {
		try (CoffeeMachine coffee1 = new CoffeeMachine(); CoffeeMachine coffee2 = new CoffeeMachine()) {
			coffee1.method1();
			coffee2.method1();
			System.out.println(coffee1);
			System.out.println(coffee2);
			System.out.println(coffee1 == coffee2);  // 주소비교
			System.out.println(coffee1.equals(coffee2));  // 값비교
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void f1() {
		CoffeeMachine coffee1 = new CoffeeMachine();
		coffee1.method1();

		// 너무 복잡함
		try {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				coffee1.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		// try 안에서 부르면 자동으로 close()
		try (CoffeeMachine coffee2 = new CoffeeMachine()) {
			coffee2.method1();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
