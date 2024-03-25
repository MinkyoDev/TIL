package com.shinhan.day06.copy;

public class BonusPointAccount extends Account {

	// field 추가
	int bonusPoint;

	// 생성자 정의
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	// 메서드 재정의(Override)
	@Override
	void deposit(int amount) {
		super.deposit(amount);
		bonusPoint += amount * 0.001;  // 복합 대입연산자는 자동 형변환됨.
//		bonusPoint = (int) (bonusPoint + amount * 0.001);
	}
	
	@Override
	public String toString() {
		return "BonusPointAccount" + super.toString() + "[bonusPoint=" + bonusPoint + "]";
	}

}
