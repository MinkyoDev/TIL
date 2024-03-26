package com.shinhan.day11.c14_5_wait_notify;

public class BathRoom {
	
	boolean isFirst = true;

	// synchronized : 하나의 thread가 이 메서드 수행 중 lock
	// 다른 thread 접근 불가, 하나의 thread가 메서드 벗어나면 대기 thread로 들어옴
	
	// 동기화 메서드
	synchronized void use(String name) {
		if(isFirst && name.equals("김")) {
			isFirst = false;
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("====================");
		
		notify();  // wait() 상태의 Thread를 실행 대기 상태로 바꿔줌
	}
	
	// 동기화 블럭
	void use2(String name) {
		synchronized (this) {			
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("====================");
		}
	}
}
