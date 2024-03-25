package com.shinhan.day07.c09_prob;

interface Action {
	public void work();
}

public class Prob5 {

	public static void main(String[] args) {
		Action action = new Action() {
			
			@Override
			public void work() {
				System.out.println("복사를 합니다.(익명 구현)");
			}
		};
		action.work();
		
		Action action2 = ()->{System.out.println("복사를 합니다.(lamda)");};
		action2.work();
	}
}
