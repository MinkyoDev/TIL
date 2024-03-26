package com.shinhan.day11.c15_1_collectionList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.shinhan.day10.c14_2_threadSysnchronization.Account;

public class CollectionTest {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		// ArrayList : 연속공간 필요, 공간이 부족하면 자동증가, 중간 삽입 삭제시 비효율적
		// LinkedList : 연속공간 불필요, 전요소나 후요소의 주소기억(공간차지), 중간삽입, 삭제시 효율적
		// Vector : Multi Thread에서 동기처리 가능
		List<String> data1 = new ArrayList<>();
		List<String> data2 = new LinkedList<>();
		List<String> data3 = new Vector<>();

		insertData(data1);
		insertData(data2);
		insertData(data3);

		displayData(data1, "ArrayList");
		displayData(data2, "LinkedList");
		displayData(data3, "Vector");
	}

	private static void displayData(List<String> data, String title) {
		System.out.println(title + "====== 일반 for ======");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println(title + "====== 확장 for ======");
		for (String s : data) {
			System.out.println(s);
		}

	}

	private static void insertData(List<String> data) {
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("목");
	}

	private static void f2() {
//		ArrayList<String> data = new ArrayList<>();
//		LinkedList<String> data = new LinkedList<>();
//		Vector<String> data = new Vector<>();
		List<String> data = new Vector<>();
		data.add("문자1");
		data.add("문자2");
		data.add("문자3");

		System.out.println("====== 일반 for ======");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println("====== 확장 for ======");
		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f1() {
		// List : 순서 있고 중복 가능 interface => 구현 class : ArrayList, LinkedList, Vector
		ArrayList data = new ArrayList();
		data.add("문자");
		data.add(100);
		data.add(new Account());

		String a = (String) data.get(0);
		int b = (Integer) data.get(1);
		Account acc = (Account) data.get(2);
	}
}
