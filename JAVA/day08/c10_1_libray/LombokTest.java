package com.shinhan.day08.c10_1_libray;

import com.shinhan.day08.lombokExample.Book;

public class LombokTest {

	public static void main(String[] args) {
		Book b = new Book("자바다", 2000, "신용권");
		b.setPrice(30000);
		System.out.println(b);
	}
}
