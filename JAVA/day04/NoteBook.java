package com.shinhan.day04;

public class NoteBook {

	// 1. field : 값 저장
	private String model;
	private int price;
	
	// non-static(instance 변수) -> 반드시 생성 후 사용가능 
	// static(class 변수, 공유 변수) -> 객체 생성과 무관하다.
	static int count;
//	int count;

	// 2. constructor : 값 초기화
	public NoteBook(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		count++;
	}

	// 3. 일반 method
	// getter or setter
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

	@Override
	public String toString() {
		return "Notebook [model=" + model + ", price=" + price + "]";
	}

}
