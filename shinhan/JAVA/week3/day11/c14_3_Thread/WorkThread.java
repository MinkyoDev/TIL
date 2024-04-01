package com.shinhan.day11.c14_3_Thread;

public class WorkThread extends Thread {

	boolean work = true;

	public WorkThread(String name) {
		super(name);
//		setName(name);  // 둘다 thread 이름 설정하는 코드
	}

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName() + " : 작업처리");
			} else {
				Thread.yield();
			}
		}
	}

}
