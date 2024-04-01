package com.shinhan.day06.copy;

public class CheckingAccount extends Account {

	// 1. 상속 후 field 추가
	String cardNo;

	// 2. 생성자 정의 - 부모의 생성자를 명시적으로 호출
	// - 부모의 field가 private로 되어있는 경우
	// - 자식의 값을 setting하기 위해 1) 생성자 이용 2) setter 이용
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		// 생성자 호출 : 자동(super())
		// 생성자 호출 : 명시적 호출
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	// 3. 상속 후 기능 추가
	int pay(String cardNo, int amount) {
		if (cardNo.equals(this.cardNo)) {
			return withdraw(amount);
		} else {
			System.out.println("카드 번호가 올바르지 않습니다.");
			return 0;
		}
	}

	@Override
	public String toString() {
		return "CheckingAccount" + super.toString() + "[cardNo=" + cardNo + "]";
	}

}
