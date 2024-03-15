package com.shinhan.day04.lab1;

public class Account {

	private String accNo;
	private int balance;

	Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.printf("%s 계좌가 개설되었습니다.\n", accNo);
		getBalance();
	}

	void deposit(int money) {
		balance += money;
		System.out.printf("%s 계좌에 %d원이 입금되었습니다.\n", accNo, money);
		getBalance();
	}

	void withdraw(int money) {
		balance -= money;
		System.out.printf("%s 계좌에 %d원이 출금되었습니다.\n", accNo, money);
		getBalance();
	}

	void getBalance() {
		System.out.printf("%s 계좌의 잔고는 %d원입니다.\n", accNo, balance);
	}

	void getAccNo() {
		System.out.printf("계좌번호는 %s 입니다.\n", accNo);
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}

}
