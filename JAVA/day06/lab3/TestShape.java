package com.shinhan.day06.lab3;

class Circle extends Shape {
	private double radius;

	public Circle(String color, double radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public double calculateArea() {
		return radius * radius * Math.PI;
	}

	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	public double getRadius() {
		return radius;
	}

}

class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(String color, double length, double width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}

	public double calculateArea() {
		return length * width;
	}

	public double calculatePerimeter() {
		return (length + width) * 2;
	}
}

public class TestShape {
	public static void main(String args[]) {
		Shape[] s = new Shape[3];

		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);

		for (int i = 0; i < 3; i++) {
			print(s[i], i);
		}
	}

	private static void print(Shape s, int i) {
		String result = (s instanceof Circle cir) ? cir.getRadius() + "" : "";
		System.out.println("Shape " + i + " is a " + s + " with an area of " + s.calculateArea() + ", a radius of "
				+ result + ", and a perimeter of " + s.calculatePerimeter());
	}
}
