package com.shinhan.day10.c14_2_threadSysnchronization;

public class TransferThread extends Thread {

	ShareArea shareArea;

	public TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		// 12번 계좌이체하기
		for (int i = 1; i < 12; i++) {

			// synchronized block : 공유 데이터를 하나의 thread가 점유하고 있을 때 다른 Thread가 접근 불가
//			synchronized (shareArea) {
//				System.out.println("이몽룡 계좌에 출금");
//				int amount = shareArea.lee.withdraw(100);
//
//				System.out.println("성춘향 계좌로 입금");
//				shareArea.sung.deposit(amount);
//			}
			shareArea.transfer();
		}
	}

}
