package com.shinhan.week1.day05;

public class Review_CarTest {

	public static void main(String[] args) {
		method2();
	}
	
	private static void method2() {
		Car[] arr = new Car[5];
		// 1. 객체 참조 변수 선언 + 생성 + 사용
		arr[0] = new Car("model A", 1000);
		arr[1] = new Car("model B", 2000);
		arr[2] = new Car("model C", 3000);
		arr[3] = new Car("model D");
		arr[4] = new Car(5000);
		
		System.out.println("Car 대수: " + Car.carCount);
		
		for(Car car:arr) {
			car.carInfoPrint("============");
		}
		
	}

	private static void method1() {
		// static은 class 소유이므로 object 생성과 관계 없다.
		System.out.println("Car 대수: " + Car.carCount);
		System.out.println("Car company: " + Car.company);
		
		Car.carInfoPrint2("*******");
	}
}
