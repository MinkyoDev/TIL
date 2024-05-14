package com.shinhan.myapp.section01;

public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("LgTV defult 생성자");
	}

	@Override
	public void powerOn() {
		System.out.println("******LG PowerOn******");
		System.out.println(getClass().getSimpleName()+"전원을 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("******LG PowerOff******");
		System.out.println(getClass().getSimpleName()+"전원을 끈다");
	}

	
}
