package com.shinhan.day12.c16_1_lambda;

public class LambdaTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Thread 구현");
			}
		};

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Runnable Interface 구현");
			}
		});

		Thread t3 = new Thread(() -> {
			System.out.println("Lambda 구현");
		});

	}
}
