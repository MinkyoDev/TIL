package com.shinhan.day07.c09_prob;

class Car {
	class Tire {}
	static class Engine{}
	
	void method() {
		class Chair {
			void f1() {}
		}
		
		Chair cc = new Chair();
		cc.f1();
	}
}

public class Prob4 {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		// instance inner class
		Car.Tire tire = myCar.new Tire();
		
		// static inner class
		Car.Engine engine = new Car.Engine();
		
		// locall class - method 내에서만 접근
		myCar.method();
	}
}
