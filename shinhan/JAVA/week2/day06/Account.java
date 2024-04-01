package com.shinhan.day06;

// JavaBeans기술 규격 : field는 접근제한자를 private, getter.setter로 접근

// final : 최종 
// - final class : 상속 불가
// - final field : 1회만 할당, 수정불가
// - final static field : 상수(선언시 1회 할당, 또는 static block)
// - final method : 재정의 불가
public class Account {
	private final String name = "우리은행";
	private final String name2;
	private static final String NAME3 = "우리은행";
	private static final String NAME4;

	static {
		NAME4 = "우리은행";
	}

	final void method1() {
		System.out.println("자식이 재정의 불가");
	}

	private String accountNo;
	private String ownerName;
	private int balance;

	// 생성자 : 정의하지 않으면 컴파일러가 default 생성자를 만듬. 정의하면 안만듬.
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;

		name2 = "우리은행";
	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -= amount;
		return amount;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}

}
