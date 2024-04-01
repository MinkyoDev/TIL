package com.shinhan.week1.day04.lab2;

public class Book {

	private String title;
	private int price;

	Book(String title, int price) {
		this.title = title;
		this.price = price;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getTitle() {
		return title;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
