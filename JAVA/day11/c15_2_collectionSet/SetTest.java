package com.shinhan.day11.c15_2_collectionSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class SetTest {

	public static void main(String[] args) {
		f4();
	}

	private static void f4() {
		Set<Car> data = new TreeSet<>();

		// 둘이 내용은 같지만 주소가 달라서 중복이 아님 -> @EqualsAndHashCode추가
		// TreeSet은 compare가 필요
		data.add(new Car("A", 1000));
		data.add(new Car("A", 1000));
		data.add(new Car("C", 5000));
		data.add(new Car("D", 1000));
		data.add(new Car("E", 3000));

		System.out.println("개수: " + data.size());

		System.out.println("====== 일반 for(불가) ======");
		System.out.println("====== 확장 for ======");
		for (Car s : data) {
			System.out.println(s);
		}
		System.out.println("====== 반복자 사용(Iterator) ======");
		Iterator<Car> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f3() {
		Set<Car> data = new HashSet<>();

		// 둘이 내용은 같지만 주소가 달라서 중복이 아님 -> @EqualsAndHashCode추가
		data.add(new Car("A", 1000));
		data.add(new Car("A", 1000));
		data.add(new Car("C", 5000));
		data.add(new Car("D", 2000));
		data.add(new Car("E", 3000));

		System.out.println("개수: " + data.size());

		System.out.println("====== 일반 for(불가) ======");
		System.out.println("====== 확장 for ======");
		for (Car s : data) {
			System.out.println(s);
		}
		System.out.println("====== 반복자 사용(Iterator) ======");
		Iterator<Car> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f2() {
		// TreeSet : 자동으로 sort
		TreeSet<String> data = new TreeSet<String>();

		data.add("A");
		data.add("B");
		data.add("B");
		data.add("E");
		data.add("C");

		System.out.println("개수: " + data.size());

		System.out.println("====== 일반 for(불가) ======");
		System.out.println("====== 확장 for ======");
		for (String s : data) {
			System.out.println(s);
		}
		System.out.println("====== 반복자 사용(Iterator) ======");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f1() {
		// Set : 순서가 없고 중복불가 interface => 구현 class : HashSet, TreeSet(순서 있음)
		HashSet<String> data_ = new HashSet<String>();
		Set<String> data = new HashSet<String>();

		data.add("월");
		data.add("화");
		data.add("목");
		data.add("목");
		data.add("금");

		System.out.println("개수: " + data.size());

		System.out.println("====== 일반 for(불가) ======");
		System.out.println("====== 확장 for ======");
		for (String s : data) {
			System.out.println(s);
		}
		System.out.println("====== 반복자 사용(Iterator) ======");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
