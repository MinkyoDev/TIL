package com.shinhan.day10.c14_1_multiThread;

// Multithread : 1) Thread 상속 2) run() 메서드 재정의 3) new 객체 생성 후 start()
// 이미 상속받은 부모가 있다면 자바는 멀티 상속 불가하므로 Runnable interface 구현
class Parent {

}

public class UppercaseThread2 extends Parent implements Runnable {

	@Override
	public void run() {
		// 1. 영문 대문자 출력
		for (char i = 'A'; i <= 'Z'; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("implements Runnable=" + Thread.currentThread().getName() + ", i=" + i);
		}
	}

}
