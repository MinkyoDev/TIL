package com.shinhan.day07.lab2;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] arr = new Shape[2];
		arr[0] = new Rectangle(5, 6);
		arr[1] = new RectTriangle(6, 2);

		for (Shape con : arr) {
			System.out.println("area: " + con.getArea());
			System.out.println("perimeter: " + con.getPerimeter());
			
			if (con instanceof Resizable re) {
				re.resize(0.5);
				System.out.println("new area: " + con.getArea());
				System.out.println("new perimeter: " + con.getPerimeter());
			}
		}
	}
}
