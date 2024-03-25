package com.shinhan.day06.lab4;

abstract class Machine {
	public void powerOn() {}
	public void powerOff() {}
	public abstract void work();
}

class Computer extends Machine {
	// 답: work 정의해야 함
	public void work() {}
}

public class Prob10 {

	public static void main(String[] args) {
		Computer computer = new Computer();
	}
}
