package com.shinhan.day10.c13_2_genericInterface;

public class GenericTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}
}
