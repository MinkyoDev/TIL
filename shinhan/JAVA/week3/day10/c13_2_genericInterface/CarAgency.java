package com.shinhan.day10.c13_2_genericInterface;

public class CarAgency implements Rentable<Car> {

	@Override
	public void method1() {
		// TODO Auto-generated method stub

	}

	@Override
	public Car rent() {
		// TODO Auto-generated method stub
		return new Car();
	}
	
	public void method1(Car car) {
		car.run();
	}
}