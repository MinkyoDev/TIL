package com.shinhan.day10.c14_2_threadSysnchronization;

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
