package com.shinhan.day06.lab3;

public abstract class Shape {
	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public String toString() {
		return color + " " + type;
	}
}
