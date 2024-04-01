package com.shinhan.day10.c14_2_threadSysnchronization;

public class MultiThreadTest {

	public static void main(String[] args) {
		f1();
//		f2();
	}

	public static void f2() {
		BathRoom room = new BathRoom();
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "박");
		BathRoomThread t3 = new BathRoomThread(room, "양");

		t1.start();
		t2.start();
		t3.start();
	}

	public static void f1() {
		ShareArea shareArea = new ShareArea(new Account("111", "이몽룡", 2000), new Account("222", "성춘향", 1000));

		Thread t1 = new TransferThread(shareArea);
		Thread t2 = new Thread(new PrintThread(shareArea));

		t1.start();
		t2.start();
	}
}
