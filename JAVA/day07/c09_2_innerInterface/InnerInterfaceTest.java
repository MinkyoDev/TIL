package com.shinhan.day07.c09_2_innerInterface;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		OkButtonListener ok1 = new OkButtonListener();
		OkButtonListener2 ok2 = new OkButtonListener2();
		
		Button button = new Button();
		button.setListener(ok1);
		button.click();
		button.setListener(ok2);
		button.click();
		
		// 익명의 구현 class 만들기
		Button.ClickListener ok3 = new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("익명 구현 class");
			}
		};
		
		button.setListener(ok3);
		button.click();
		
		// 익명의 구현 class 만들기2
		button.setListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("익명 구현 class");
				
			}
		});
		button.click();
		
		// lamda
		button.setListener(()->System.out.println("익명 구현 class"));
		button.click();
	}
}
