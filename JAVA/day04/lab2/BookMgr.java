package com.shinhan.day04.lab2;

public class BookMgr {

	private Book[] bookList;
	private int length;

	BookMgr(Book[] bookList) {
		this.bookList = bookList;
		length = bookList.length;
	}

	void resetBooklist() {
		bookList = new Book[length];
	}

	void printBookList() {
		System.out.println("=== 책 목록 ===");
		for (Book book : bookList) {
			System.out.println(book.getTitle());
		}
	}

	void printTotalPrice() {
		System.out.println("=== 책 가격의 총합 ===");
		int total = 0;

		for (Book book : bookList) {
			total += book.getPrice();
		}
		System.out.println("전체 책 가격의 합 : " + total);
	}
}
