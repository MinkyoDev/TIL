package com.shinhan.week1.day04.lab4;

public class Teacher {

	private String name;
	private int age;
	private String subject;

	public Teacher(String name, int age, String subject) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void print() {
		System.out.printf("이 름 : %s 나 이 : %d 담당과목 : %s\n", name, age, subject);
	}

}
