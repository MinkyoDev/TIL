package com.shinhan.day10.c14_2_threadSysnchronization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {

	String accountNo;
	String ownerName;

	int balance;

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return amount;
		} else {
			System.out.println("잔고 부족");
			return 0;
		}
	}
}
