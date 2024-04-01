package com.shinhan.day06.copy;

public class CreditLineAccount extends Account {

	int creditLine; // 마이너스 한도

	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}

	// withdraw 재정의
	// override(재정의)
	// - 이름, 매개변수 타입과 개수, return 타입, modifier는 같거나 더 넓어져야함.
	@Override
	public int withdraw(int amount) {
		if (getBalance() + creditLine < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		setBalance(getBalance() - amount);
		return amount;
	}

	@Override
	public String toString() {
		return "CreditLineAccount" + super.toString() + "[creditLine=" + creditLine + "]";
	}

	

}
