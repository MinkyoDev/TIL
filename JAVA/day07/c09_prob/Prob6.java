package com.shinhan.day07.c09_prob;

interface Vehicle {
	public void run();
}

class Anonymous {
	// 익명 구현 class를 field로 사용
	Vehicle field = new Vehicle() {

		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};

	Vehicle field2 = () -> System.out.println("lamda 자전거가 달립니다.");

	void method1() {
		// 익명 구현 class를 지역변수로 사용
		Vehicle localVar = new Vehicle() {

			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};

		Vehicle localVar2 = () -> System.out.println("lamda 승용차가 달립니다.");
		localVar.run();
	}

	void method2(Vehicle v) {
		v.run();
	}
}

public class Prob6 {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();

		// 익명 구현 class를 parameter로 사용
		anony.method2(new Vehicle() {

			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
		anony.method2(() -> System.out.println("lamda 트력이 달립니다."));
	}
}
