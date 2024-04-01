package com.shinhan.day10.c14_1_multiThread;

// process : 실행중인 하나의 프로그램
// thread : 하나의 process 내의 프로그램의 흐름
// thread class를 이용하면 MultiThread 프로그램 가능

public class MultiThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "thread 시작");
		// Thread class 사용
		// 구현 class
		Thread t1 = new UppercaseThread();

		// 익명 구현 class
		Thread t2 = new Thread() {

			@Override
			public void run() {
				// 2. 영문 소문자 출력
				for (char i = 'a'; i <= 'z'; i++) {
					System.out.println(Thread.currentThread().getName() + " i=" + i);
				}
			}
		};

		t1.start();
//		t2.run(); // run은 main이 대기함.

		// 3. 숫자 출력
		for (int i = 1; i <= 26; i++) {
			System.out.println(Thread.currentThread().getName() + " i=" + i);
		}

		// Runnable interface 사용
		Thread t3 = new Thread(new UppercaseThread2());
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 30; i < 60; i++) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("interface---");
				}
			}
		});
		
		Thread t5 = new Thread(()->{
			for(int i=0;i<26;i++) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("lambda-----");
			}
		});
		
		t3.start();
		t4.start();
		t5.start();

		System.out.println(Thread.currentThread().getName() + "thread 종료");
	}
}
