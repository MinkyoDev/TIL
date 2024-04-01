package com.shinhan.day11.c14_6_interrupt;

// 조건문 이용하여 안전하게 쓰레드를 종료
public class PrintThread extends Thread {

	private boolean stop; // false

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	// interrupt() 메서드로 Exception 발생시켜서 종료하기
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("실행중...");
				sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");
	}

	// 조건문을 이용하여 안전하게 종료하기
	public void run2() {
		while (!stop) {
			System.out.println("실행중...");
		}
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");
	}

}
