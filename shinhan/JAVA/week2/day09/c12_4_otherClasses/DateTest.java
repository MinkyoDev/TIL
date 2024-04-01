package com.shinhan.day09.c12_4_otherClasses;

public class DateTest {

	public static void main(String[] args) {

		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date();

		System.out.println(d2);
		System.out.println(1900 + d2.getYear());
		System.out.println(d2.getTime());

		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		java.sql.Date d4 = new java.sql.Date(2024-1900, 3-1, 22);
		
		System.out.println(d3);
		System.out.println(d4);

	}
}
