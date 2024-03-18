package com.shinhan.day05.lab1;

public class Account {

	private String accountNo;
	private String accountOwner;
	private int balance;
	
	static int length = 0;

	public Account(String accountNo, String accountOwner, int balance) {
		super();
		this.accountNo = accountNo;
		this.accountOwner = accountOwner;
		this.balance = balance;
		length++;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
