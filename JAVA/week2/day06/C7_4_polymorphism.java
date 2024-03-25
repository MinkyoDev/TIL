package com.shinhan.day06;

class Vehicle {
	void run() {

	}
}

abstract class Truck extends Vehicle {
	abstract void run();

	void print() {
		System.out.println("구현");
	}
}

class Truck2 extends Truck {
	void run() {
		System.out.println("추상 메서드를 반드시 자식이 구현할 의무가 있음.");
	}
}

class Bus extends Vehicle {
	void run() {
		System.out.println("(Bus)자식의 run - override");
	}
}

class Texi extends Vehicle {
	void run() {
		System.out.println("(Texi)자식의 run - override");
	}
}

class Driver {
	void drive(Vehicle vv) {
		vv.run();
	}
}

public class C7_4_polymorphism {

	public static void main(String[] args) {
		System.out.println("------매개변수의 다형성------");
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Texi());
	}
}
