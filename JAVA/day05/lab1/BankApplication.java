package com.shinhan.day05.lab1;

import java.util.Scanner;

public class BankApplication {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Account[] accounts = new Account[2];
		boolean isOn = true;

		while (isOn) {
			printMenu();
			System.out.print("선택>");
			int num = sc.nextInt();

			switch (num) {
			case 1 -> {
				createAccount(accounts);
			}
			case 2 -> {
				printAccountList(accounts);
			}
			case 3 -> {
				deposit(accounts);
			}
			case 4 -> {
				withdraw(accounts);
			}
			case 5 -> {
				System.out.println("프로그램 종료");
				isOn = false;
			}

			}
		}
	}

	private static void printMenu() {
		System.out.println("------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("------------------------------------------");
	}

	private static void createAccount(Account[] accounts) {
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");

		if (Account.length == accounts.length) {
			System.out.println("더이상 계좌생성은 불가능합니다.");
			return;
		}

		System.out.print("계좌번호>");
		String accountNo = sc.next();
		System.out.print("계좌주>");
		String accountOwner = sc.next();
		System.out.print("초기입금액>");
		int initBalance = sc.nextInt();

		accounts[Account.length] = new Account(accountNo, accountOwner, initBalance);
		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	private static void printAccountList(Account[] accounts) {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");

		for (Account account : accounts) {
			if (account != null) {
				System.out.printf("%s  %s  %d\n", account.getAccountNo(), account.getAccountOwner(),
						account.getBalance());
			}
		}
	}

	private static void deposit(Account[] accounts) {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");

		System.out.print("계좌번호>");
		String accountNo = sc.next();
		System.out.print("이용금액>");
		int initBalance = sc.nextInt();

		boolean found = false;
		for (Account account : accounts) {
			if (account != null && account.getAccountNo().equals(accountNo)) {
				account.setBalance(account.getBalance() + initBalance);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("계좌가 없습니다.");
		}
	}

	private static void withdraw(Account[] accounts) {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");

		System.out.print("계좌번호>");
		String accountNo = sc.next();
		System.out.print("이용금액>");
		int initBalance = sc.nextInt();

		boolean found = false;
		for (Account account : accounts) {
			if (account != null && account.getAccountNo().equals(accountNo)) {
				if (account.getBalance() - initBalance < 0) {
					System.out.println("잔액이 부족합니다.");
				} else {
					account.setBalance(account.getBalance() - initBalance);
					System.out.println("결과: 출금이 성공되었습니다.");
				}
				found = true;
				break;
			}
		}
		if (!found) {
		    System.out.println("계좌가 없습니다.");
		}
	}
}
