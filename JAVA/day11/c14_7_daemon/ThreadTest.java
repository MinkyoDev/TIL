package com.shinhan.day11.c14_7_daemon;

public class ThreadTest {

	public static void main(String[] args) {
		AutoSaveThread t1 = new AutoSaveThread();
//		t1.setDaemon(true);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
