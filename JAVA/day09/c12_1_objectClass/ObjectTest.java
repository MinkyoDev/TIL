package com.shinhan.day09.c12_1_objectClass;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		f2();
	}

	private static void f3() {
		ComputerVO3 com1 = new ComputerVO3("A", 1000, "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 1000, "Samsung");

		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
	}

	private static void f2() {
		ComputerVO2 com1 = new ComputerVO2("A", 1000, "Samsung");
		ComputerVO2 com2 = new ComputerVO2("A", 1000, "Samsung");

		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		System.out.println(com1.model());
	}

	private static void f1() {
		ComputerVO com1 = new ComputerVO("A", 1000, "Samsung");
		ComputerVO com2 = new ComputerVO("A", 1000, "Samsung");

		System.out.println(com1);
		System.out.println(com2);

		System.out.println(com1 == com2);
		System.out.println(com1.equals(com2));

		// 동일객체비교 (hashcode(), equals() 둘다 재정의 해야함)
		// Set : 순서 없고 중복 불가
		HashSet<ComputerVO> computers = new HashSet<ComputerVO>();
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 1000, "Samsung"));
		System.out.println(computers.size());

		for (ComputerVO com : computers) {
			System.out.println(com);
		}
	}
}
