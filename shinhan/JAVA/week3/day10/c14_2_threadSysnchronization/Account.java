package com.shinhan.day10.c14_2_threadSysnchronization;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	String accountNo;
	String ownerName;

	int balance;

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return amount;
		} else {
			System.out.println("잔고 부족");
			return 0;
		}
	}
}
