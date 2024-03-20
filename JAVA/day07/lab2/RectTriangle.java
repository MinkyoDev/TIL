package com.shinhan.day07.lab2;

public class RectTriangle extends Shape {
	double width;
	double height;

	public RectTriangle(double w, double h) {
		super(3);
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		return width * height / 2;
	}

	@Override
	public double getPerimeter() {
		return Math.sqrt(width * width + height * height) + width + height;
	}

}
