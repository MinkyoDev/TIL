package com.shinhan.day06.lab4;

class Parent {
	public String nation;

	public Parent() {
		this("대한민국");
		System.out.println("Parent() call");
	}

	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}

class Child extends Parent {
	public String name;

	public Child() {
		this("홍길동");  // 자신의 class의 다른 생성자 호출, 중간에 들어갈 수 없고 맨 위에 들어가야함.
		System.out.println("Child() call");
	}

	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}

public class Prob07 {
	public static void main(String[] args) {
		Child child = new Child();
	}
}

//Parent(String nation) call
//Parent() call
//Child(String name) call
//Child() call
