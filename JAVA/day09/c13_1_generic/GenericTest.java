package com.shinhan.day09.c13_1_generic;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		f2();
	}
	
	private static void f2() {
		// List : 순서 있고 중복 가능
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("월");
		list1.add("월");
		list1.add("화");
		list1.add("토");
		list1.add("토토");
		
		for (String str:list1) {
			System.out.println(str.length());
		}
	}
	
	private static void f1() {
		// <>안에는 기본형은 안 들어간다.
		Box<String, Integer> box1 = new Box<>("computer01", 30);
		System.out.println(box1);
		
		Box<Integer, String> box2 = new Box<>(123, "Large");
		System.out.println(box2);
	}
}
