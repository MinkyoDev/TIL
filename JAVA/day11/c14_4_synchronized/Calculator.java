package com.shinhan.day11.c14_4_synchronized;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	// 동기화 처리 안함
//	public void setMemory(int memory) {
//		this.memory = memory;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
//	}
	
	// 동기화 블럭 사용
//	public void setMemory(int memory) {
//		synchronized (this) {
//			this.memory = memory;
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
//		}
//	}
	
	// 동기화 메서드
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
