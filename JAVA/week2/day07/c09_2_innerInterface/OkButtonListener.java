package com.shinhan.day07.c09_2_innerInterface;

// 구현 class

public class OkButtonListener implements Button.ClickListener{

	@Override
	public void onClick() {
		System.out.println("OK 버튼을 눌렀을 때 동작(1)");
	}

}
