package com.shinhan.day06;

// OOP의 특징
// - 캡슐화(정보 은닉, private)
// - 상속(기존 class 물려밭음, 수정가능, 추가가능)
// - 다형성(사용은 같지만 결과는 다름)

public class C7_3_InheritanceTest3 {

	public static void main(String[] args) {
		method4();
	}

	private static void method7(Account acc) {
		System.out.println("================");
		System.out.println(acc);
		System.out.println("계좌번호: " + acc.getAccountNo());
		System.out.println("예금주: " + acc.getOwnerName());
		System.out.println("잔고: " + acc.getBalance());

		if (acc instanceof CheckingAccount) {
			// 부모 <= 자식
			// 자식 <= (자식)부모
			// 자식 <= 형제(불가)
			CheckingAccount acc2 = (CheckingAccount) acc;
			System.out.println("카드번호: " + acc2.cardNo);
		}else if (acc instanceof CreditLineAccount acc2) {
			System.out.println("마이너스 한도: "+acc2.creditLine);
		}else if (acc instanceof BonusPointAccount acc2) {
			System.out.println("포인트: "+acc2.bonusPoint);
		}
	}

	private static void method6() {
		// 형변환
		// 1. 자동(객체) : 부모의 타입방 = 자식의 타입 값
		Account acc = new CheckingAccount("113", "양", 2000, "11-22");

		// 강제(객체) : 자식 타입 방 = (자식 타입, 반드시 instance의 타입)부모의 타입 값
		CheckingAccount acc2 = (CheckingAccount) acc;
		CreditLineAccount acc3 = (CreditLineAccount) acc;

	}

	private static void method5() {
		// 형변환
		// 1. 자동(기본형) : 큰방 = 작은 값
		long a;
		int data = 100;
		a = data;

		// 2. 강제(명시) : 작은방 = (타입) 큰 값
		long data2 = 200;
		int b;
		b = (int) data2;

	}

	private static void method4() {
		Account acc1 = new Account("111", "김", 1000);
		CheckingAccount acc2 = new CheckingAccount("222", "양", 2000, "11-11");
		CreditLineAccount acc3 = new CreditLineAccount("333", "박", 3000, 2000);
		BonusPointAccount acc4 = new BonusPointAccount("444", "정", 4000, 4);

		method7(acc1);
		method7(acc2);
		method7(acc3);
		method7(acc4);
	}

	private static void method3() {
		BonusPointAccount acc3 = new BonusPointAccount("111", "길동", 1000, 1);
		acc3.deposit(5000);

		System.out.println(acc3.getBalance());
		System.out.println(acc3.bonusPoint);
	}

	private static void method2() {
		CreditLineAccount acc2 = new CreditLineAccount("111", "현상", 2000, 1000);
		acc2.deposit(2000);
		int amount = acc2.withdraw(5000);
		System.out.println("출금액: " + amount);
	}

	private static void method1() {
		CheckingAccount acc1 = new CheckingAccount("111-111", "홍길동", 1000, "33-22");
		acc1.deposit(2000);
		int amount = acc1.withdraw(1200000);
		System.out.println("출금액: " + amount);
		System.out.println("잔고: " + acc1.getBalance());

		amount = acc1.pay("22-11", 800);
		System.out.println("카드로 인출: " + amount);
		amount = acc1.pay("33-22", 800);
		System.out.println("카드로 인출: " + amount);
	}
}
