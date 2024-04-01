package com.shinhan.day11.c15_3_collectionMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.shinhan.day11.c15_2_collectionSet.Car;

public class CollectionTest {
	
	public static void main(String[] args) {
		f5();
	}

	
	
	private static void f5() {
		Map<Car, Integer> data = new HashMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2);
		data.put(new Car("B", 1000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 3000), 5);

		for (Car key : data.keySet()) {
			System.out.println(key + " -> " + data.get(key));
		}
	}

	private static void f4() {
		Map<String, Car> data = new HashMap<>();
		data.put("A", new Car("A", 1000));
		data.put("A", new Car("A2", 2000));
		data.put("B", new Car("B", 1000));
		data.put("C", new Car("C", 1000));
		data.put("B", new Car("B2", 3000));

		for (String key : data.keySet()) {
			System.out.println(key + " -> " + data.get(key));
		}
	}

	private static void f3() {
		Set<Car> alist2 = new HashSet<Car>();
		alist2.add(new Car("A", 1000));
		alist2.add(new Car("B", 1000));
		alist2.add(new Car("A", 1000));
		alist2.add(new Car("B", 1000));
		alist2.add(new Car("C", 1000));
		for (Car car2 : alist2) {
			System.out.println(car2);
		}
	}

	private static void f2() {
		// 배열(연속공간, 가변 불가)
		// Collection : List(순서 있고 중복 없음), Set(순서 없고 중복 있음), Map(키와 값의 쌍 entry)
		List<Car> alist = new LinkedList<>();
		alist.add(new Car("A", 1000));
		alist.add(0, new Car("B", 2000)); // 위치에 삽입

		for (Car car : alist) {
			System.out.println(car);
		}

	}
}
