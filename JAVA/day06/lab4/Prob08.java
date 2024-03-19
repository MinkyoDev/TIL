package com.shinhan.day06.lab4;

class Tire {
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}

class SnowTire extends Tire {
	@Override
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
}

public class Prob08 {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = new Tire();
		
		snowTire.run();
		tire.run();
	}
}

// 스노우 타이어가 굴러갑니다.
// 일반 타이어가 굴러갑니다.
