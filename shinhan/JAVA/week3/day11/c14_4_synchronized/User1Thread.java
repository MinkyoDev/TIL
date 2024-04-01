package com.shinhan.day11.c14_4_synchronized;

public class User1Thread extends Thread {

	private Calculator calculator;

	public User1Thread() {
		setName("User1 쓰레드");
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}

}
