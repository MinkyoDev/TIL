package com.shinhan.day11;

// Process : 실행중인 하나의 프로그램
// Thread : 프로그램에서 하나의 흐름
// Multi Thread : 실행중인 하나의 프로그램의 흐름이 여러개
// 1. Thread class 상속
// 2. Runnable interface 구현

class MyThread1 extends Thread {

	public MyThread1(String name) {
		super(name); // Thread 이름 설정
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName());
	}

}

class MyThread2 extends Object implements Runnable {

	String name;

	public MyThread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + name);
	}

}

public class Review2 {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		MyThread1 t1 = new MyThread1("신한1");
		Thread t2 = new MyThread1("신한2");
		Thread t3 = new Thread("신한3") {

			@Override
			public void run() {
				System.out.println(currentThread().getName());
			}

		};
		MyThread2 myrunnable = new MyThread2("신한4"); // Thread가 아님 Runnable 구현 class
		Thread t4 = new Thread(myrunnable);
		Thread t5 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Runnable의 익명 구현 class");
			}
		});
		Thread t6 = new Thread(() -> {
			System.out.println("Runnable의 익명 구현 class(lambda)");
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		System.out.println(Thread.currentThread().getName() + " thread End");
	}
}
