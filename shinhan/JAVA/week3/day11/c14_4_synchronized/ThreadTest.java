package com.shinhan.day11.c14_4_synchronized;

public class ThreadTest {

	public static void main(String[] args) {
		// 공유 데이터
		Calculator calculator = new Calculator();
		
		User1Thread t1 = new User1Thread();
		t1.setCalculator(calculator);
		
		User2Thread t2 = new User2Thread();
		t2.setCalculator(calculator);
		
		t1.start();
		t2.start();  // 시작 -> 실행대기 상태 -> 차례가 되면 수행
	}
}
