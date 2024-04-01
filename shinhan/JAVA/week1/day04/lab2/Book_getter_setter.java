package com.shinhan.week1.day04.lab2;

// source - Generate Getters and Setters
// source - Generate Construct using fields
public class Book_getter_setter {

	public Book_getter_setter(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	private String title;
	private int price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
