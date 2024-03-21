package com.shinhan.day08.c12_1_javaBaseModule;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		HashSet<Book> datas = new HashSet<Book>();  // 주소와 내용 둘 다 같아야함ㅇ
		datas.add(new Book("A",1000,"a"));
		datas.add(new Book("A",2000,"a"));
		datas.add(new Book("A",2000,"a"));
		datas.add(new Book("B",1000,"a"));
		datas.add(new Book("B",1000,"a"));

		System.out.println(datas.size()); // 3

		for (Book str : datas) {
			System.out.println(str);
		}
	}

	private static void f2() {
		// generics : type 제한
		HashSet<String> datas = new HashSet<String>();
//		datas.add(100);
//		datas.add(new Book("자바", 2000, "신"));
		datas.add("월");
		datas.add("화");
		datas.add("화");
		datas.add("수");

		System.out.println(datas.size()); // 3

		for (String str : datas) {
			System.out.println(str);
		}
	}

	private static void f1() {
		// HashSet : 순서가 없고 중복이 안된다. Key로 사용된다.
		HashSet datas = new HashSet();
		datas.add(100);
		datas.add("자바");
		datas.add(new Book("자바", 2000, "신"));

		for (Object obj : datas) {
			if (obj instanceof Integer) {

			} else if (obj instanceof String) {

			} else if (obj instanceof Book) {

			}
		}
	}
}
