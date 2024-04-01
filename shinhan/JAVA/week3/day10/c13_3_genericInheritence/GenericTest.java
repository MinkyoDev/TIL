package com.shinhan.day10.c13_3_genericInheritence;

public class GenericTest {

	public static void main(String[] args) {
		ChildProduct<String, Integer, Integer> p1 = new ChildProduct<>("computer", 111, 200);
		System.out.println(p1);
		
	}
}
