package com.shinhan.week1.day04.lab4;

public class Student {
	// instance 변수, 객체 생성시 자동으로 초기화
	private String name;
	private int age;
	private int id;

	public Student(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void print() {
		System.out.printf("이 름 : %s 나 이 : %d 학 번 : %d\n", name, age, id);
	}

}
