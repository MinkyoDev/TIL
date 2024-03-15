package com.shinhan.day04;

public class Car {

	// 1. field (특징, 변수, data 저장, 멤벼변수)
	// 접근지정자(Modifier) private 인 경우 외부에서 접근불가
	// 접근하려면 기능이 추가되어야 한다.
	// 읽기기능 : getter
	// 쓰기기능 : setter

	private String company = "현대 자동차";
	private String model;
	private String color;
	private int maxSpeed;

	// 2. constructor (생성자) - 생성자는 여러가지 방법을 정의 (Overloading)
	Car() {
		System.out.println("default 생성자...arg 없음");
	}

	Car(String model, String color, int maxSpeed) {
//		super();  // 부모 생성
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	Car(String model, int maxSpeed, String color) {
		this(model, color, maxSpeed); // 생성자 호출은 첫번째 줄에서만 가능, super() 부분 수행안함.
		System.out.println("----------");
	}

	Car(String color, int maxSpeed) {
		this(null, color, maxSpeed);
	}

	Car(String model) {
		this(model, "silver", 0);
	}

	// 3. 메서드 (기능, 동작, 문장들의 묶음), return type 반드시 필요, return 없으면 void
	String carInfoPrint(String title) {
		System.out.println(title);
		System.out.println("=========Car Infomation=========");
		System.out.println("company: " + company);
		System.out.println("model: " + model);
		System.out.println("color: " + color);
		System.out.println("maxSpeed: " + maxSpeed);

		return title;
	}

	void powerOn() {
		System.out.println("===Power On===");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	// JavaBeans기술의 규칙 : set(대문자)소문자 - getCompany, setConpany
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public String getCompany() {
//		return company;
//	}

}
