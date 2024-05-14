package com.shinhan.myapp.section01;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("Samsung TV defult 생성자");
	}

	public SamsungTV(String model) {
		System.out.println("Samsung TV 모델: " + model);
	}

	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "전원을 켠다");
	}

	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "전원을 끈다");
	}
}
