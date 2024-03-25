package com.shinhan.day06.copy;

//정의는 있고 구현은 없다. 구현은 자식 class가 함.
//abstract method : 정의는 있고 구현은 없다.
//abstract class : class 안에 추상 메서드가 하나라도 있다. - 객체 생성 불가
//추상 메서드를 상속 받은 자식은 반드시 추상 메서드를 구현할 의무가 있다.

abstract class Vehicle2 {
	abstract void run();
}

abstract class Truck3 extends Vehicle2 {
	abstract void run();

	void print() {
		System.out.println("구현");
	}
}

class Truck4 extends Truck {
	void run() {
		System.out.println("추상 메서드를 반드시 자식이 구현할 의무가 있음.");
	}
}

class Bus2 extends Vehicle2 {
	void run() {
		System.out.println("(Bus)자식의 run - override");
	}
}

class Texi2 extends Vehicle2 {
	void run() {
		System.out.println("(Texi)자식의 run - override");
	}
}

class Driver2 {
	void drive(Vehicle2 vv) {
		vv.run();
	}
}

public class C7_7_AbstractTest1 {

	public static void main(String[] args) {
		System.out.println("------매개변수의 다형성------");
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Texi());
	}
}
