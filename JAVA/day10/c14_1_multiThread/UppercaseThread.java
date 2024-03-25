package com.shinhan.day10.c14_1_multiThread;

// Multithread : 1) Thread 상속 2) run() 메서드 재정의 3) new 객체 생성 후 start()
public class UppercaseThread extends Thread {

	@Override
	public void run() {
		// 1. 영문 대문자 출력
		for (char i = 'A'; i <= 'Z'; i++) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("extend Thread=" + currentThread().getName() + ", i=" + i);
		}
	}

}
