package com.shinhan.day07.lab2;

public class Rectangle extends Shape implements Resizable {
	double width;
	double height;

	public Rectangle(double w, double h) {
		super(4);
		this.width = w;
		this.height = h;
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}

}
