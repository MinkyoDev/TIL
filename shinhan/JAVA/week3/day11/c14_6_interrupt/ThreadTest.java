package com.shinhan.day11.c14_6_interrupt;

public class ThreadTest {

	public static void main(String[] args) {
		PrintThread t1 = new PrintThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t1.setStop(true);
//		t1.stop();  // 비추천
		
		t1.interrupt();
	}
}
