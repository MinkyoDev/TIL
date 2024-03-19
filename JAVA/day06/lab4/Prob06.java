package com.shinhan.day06.lab4;

class Parent {
	public String name;
	
	public Parent(String name) {
		this.name = name;
	}
}

class Child extends Parent {
	public int studentNo;
	
	public Child(String name, int studantNo) {
//		this.name = name;
		super(name);  // 답: super 사용하여 부모 class 생성자 지정
		this.studentNo = studantNo;
	}
}
public class Prob06 {

	public static void main(String[] args) {
		Child child = new Child("길동", 1);
	}
}
