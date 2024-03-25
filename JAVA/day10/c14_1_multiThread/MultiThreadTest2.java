package com.shinhan.day10.c14_1_multiThread;

public class MultiThreadTest2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작");

		Thread t1 = new UppercaseThread();
		Thread t2 = new Thread(new UppercaseThread2());
		t1.start();
		t2.start();

		System.out.println(Thread.currentThread().getName() + "끝");
	}
}
