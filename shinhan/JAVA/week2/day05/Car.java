package com.shinhan.week1.day05;

// class : object를 만들기 위한 툴(template), 설계도
// object : class를 이용해서 만든 독립된 개체
// instance == object, new로 만든 실체

public class Car {

	// 1. field(특징, data값 저장, 변수)
	// - static(class 변수, object들의 공통변수)
	// - non-static(instance 변수, 멤버변수)
	static String company = "현대자동차"; // class load시에 값 할당.
	private String model;
	private int price;

	static int carCount;

	// 2. constructor[method]
	// - 컴파일시에 정의가 없으면 자동으로 default 생성자(argument 없음) 만들어준다.
	// - 객체 생성시 자동호출
	// - 생성자는 생성시 값 초기화가 목적이다.
	// - 매개변수 이름과 멤버변수 이름 충돌하면 구분하기 위해 현재 객체에 this 사용
	// - 생성자 overloading(이름이 같고 매개변수 사양이 다름)
	// - 하나의 생성자가 같은 이름의 다른 모양의 생성자를 호출시 this() 사용
	Car(String mode, int price) {
		// 함수이름(변수타입 매개변수) : 매개변수는 지역변수
		this.model = mode;
		this.price = price;
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어집니다.");
	}

	Car(String mode) {
		this(mode, 1000);
	}

	Car(int price) {
		this("미정", price);
	}

	// 3. 일반 method(기능, 문장들의 묶음)
	// - 반드시 return 값의 타입을 정의. 없다면 void
	// - getter/setter는 이름 규칙을 지킨다. javabeans 사용할 때를 위해
	void carInfoPrint(String title) {
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		System.out.println("model: " + model);
		System.out.println("price: " + price);
	}

	static void carInfoPrint2(String title) {
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		// model, price 사용 불가(static method에서 non-static(instatnce 변수) 사용불가
//		System.out.println("model: " + model);
//		System.out.println("price: " + price);
	}

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Car.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static int getCarCount() {
		return carCount;
	}

	// 4. block(생성자보다 먼저 실행)
	{
		System.out.println("----instatnce block----"); // 객체를 생성할때마다 수행
	}

	static {
		// class load시 static변수 로직이 필요한 초기화시 사용
		System.out.println("----class load----"); // class load시에 1회 수행
	}

	// 5. inner class
	class Tier {
		// 1. field
		String color;
		// 2. constructor
		// 3. method
		// 4. block
		// 5. inner class
	}
}
