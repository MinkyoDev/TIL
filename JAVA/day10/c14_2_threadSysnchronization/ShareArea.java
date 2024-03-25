package com.shinhan.day10.c14_2_threadSysnchronization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareArea {

	Account lee;
	Account sung;

	synchronized void transfer() {
		System.out.println("이몽룡 계좌에 출금");
		int amount = lee.withdraw(100);

		System.out.println("성춘향 계좌로 입금");
		sung.deposit(amount);
	}
	
	synchronized void print() {
		int b1 = lee.balance;
		int b2 = sung.balance;
		System.out.println("잔고의 합: " + (b1 + b2));
	}

}
