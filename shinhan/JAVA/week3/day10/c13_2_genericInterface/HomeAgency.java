package com.shinhan.day10.c13_2_genericInterface;

public class HomeAgency implements Rentable<Home> {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Home rent() {
		return new Home();
	}

}
