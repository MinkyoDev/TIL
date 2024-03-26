package com.shinhan.day11.c14_5_wait_notify;

public class MultiThreadTest {

	public static void main(String[] args) {
		f2();
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

}
