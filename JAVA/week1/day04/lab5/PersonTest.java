package com.shinhan.week1.day04.lab5;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person(12, "Anonymous");
		
		p1.selfIntroduce();
		System.out.println("전체 인구수: " + p1.getPopulation());
	}
}
