package com.shinhan.day04.lab5;

public class Person {

	static int numberOfPersons;
	int age = 12;
	String name = "Anonymous";

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void selfIntroduce() {
		System.out.printf("내 이름은 %s이며, 나이는 %d살 입니다.\n", name, age);
	}

	public int getPopulation() {
		return numberOfPersons;
	}

}
