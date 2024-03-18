package com.shinhan.day05;

// 접근 지정자(Modifier)
// 1. public : 모든 패키지에서 접근 가능
// 2. protected : 같은 패키지에서 접근 가능, 다른 패키지면 상속받아야 접근가능
// 3. defualt : 같은 패키지에서 접근 가능
// 4. private : 같은 class내에서 접근 가능(정보 은닉, 캡슐화)


public class Computer {
	private String model;
	protected int price;
	
	public Computer() {
		System.out.println("defualt 생성자");
	}
	
	public void setModel(String model){
		this.model = model;
	}
}
