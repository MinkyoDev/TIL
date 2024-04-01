package com.shinhan.day12.c16_problem;

public class Problem04 {

	public static void main(String[] args) {

		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("작업 스레드가 실행됩니다.");
			}
		};

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("작업 스레드가 실행됩니다.");
			}
		});
		
		Thread thread3 = new Thread(() -> {
			System.out.println("작업 스레드가 실행됩니다.");
		});

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
