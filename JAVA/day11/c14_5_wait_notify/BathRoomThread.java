package com.shinhan.day11.c14_5_wait_notify;

public class BathRoomThread extends Thread {

	BathRoom room;
	String name;

	public BathRoomThread(BathRoom room, String name) {
		this.room = room;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			room.use(name);
		}
	}

}
