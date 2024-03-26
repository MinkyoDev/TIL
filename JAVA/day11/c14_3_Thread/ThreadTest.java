package com.shinhan.day11.c14_3_Thread;

public class ThreadTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		WorkThread t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.work = false;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.work = true;
	}
}
