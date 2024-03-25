package com.shinhan.day06.copy;

class Tire {
	void roll() {
		System.out.println("부모 roll");
	}
}

class HankookTire extends Tire {
	void roll() {
		System.out.println("HankookTire roll");
	}
}

class KumhoTire extends Tire {
	void roll() {
		System.out.println("KumhoTire roll");
	}
}

class Car {
	Tire tire;

	Car(Tire tire) {
		this.tire = tire;
	}
	void go() {
		tire.roll();
	}
}

public class C7_5_polymorphism2 {

	public static void main(String[] args) {
		System.out.println("------field의 다형성------");
		Car car1 = new Car(new HankookTire());
		Car car2 = new Car(new KumhoTire());
		
		car1.go();
		car2.go();
	}
}
