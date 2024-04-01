package com.shinhan.day11.c14_4_synchronized;

public class User2Thread extends Thread {

	private Calculator calculator;

	public User2Thread() {
		setName("User2 쓰레드");
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}

}
