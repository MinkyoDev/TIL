package com.shinhan.day11.c15_3_collectionMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.shinhan.day11.c15_2_collectionSet.Car;

public class MapTest {

	public static void main(String[] args) {
		f5();
	}

	private static void f5() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("apple1", 10);
		treeMap.put("apple4", 20);
		treeMap.put("apple5", 40);
		treeMap.put("apple2", 50);
		treeMap.put("apple3", 30);

		print(treeMap, "original");
		print2(treeMap, "original");
		print3(treeMap, "find");

		NavigableMap<String, Integer> datas = treeMap.descendingMap();
		print(treeMap.descendingMap(), "descendingMap");
	}

	private static void print3(TreeMap<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.firstEntry());
	}

	private static void print2(TreeMap<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		for (Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

	private static void print(Map<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		for (String key : treeMap.keySet()) {
			System.out.println(key + " => " + treeMap.get(key));
		}
	}

	private static void f4() {
		Properties pro = new Properties();

		try {
			pro.load(MapTest.class.getResourceAsStream("oracleDB.properties"));

			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname2 = pro.getProperty("myname2", "AAA"); // 없다면 default값

			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f3() {
		// Map : HashMap, TreeMap, HashTable
		// Hashtable (동기화 가능)
		Map<String, Integer> map = new Hashtable<>();
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(String.valueOf(i), i); // {"1": 1, "2": 2, ...}
				}

			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(String.valueOf(i), i); // {"1": 1, "2": 2, ...}
				}

			}
		};
		t1.start();
		t2.start();
		try {
			t1.join(); // t1이 종료될때까지 대기
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("entry 개수: " + map.size());
	}

	private static void f2() {
		Map<Car, Integer> data = new TreeMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2);
		data.put(new Car("B", 1000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 3000), 5);

		System.out.println(data.containsKey(new Car("C", 1000)));
		System.out.println(data.containsKey(new Car("C2", 1000)));
		System.out.println(data.containsValue(4));
		System.out.println(data.containsValue(44));

		for (Car key : data.keySet()) {
			System.out.println(key + " -> " + data.get(key));
		}
	}

	private static void f1() {
		// Map : key와 value의 쌍이다(Map.Entry), key는 Set으로 만듦(중복 불가)
		// 구현 class : HashMap, HashTable, TreeMap, Properties
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 99);
		data.put("A", 88); // 이미 존재하는 키가 있으면 덮어쓴다.
		data.put("B", 100);
		data.put("C", 77);
		data.put("B", 99);

		System.out.println(data.size());
		System.out.println(data.get("A"));
		System.out.println(data.get("B"));

		// 1. 키의 이름을 모를때
		System.out.println("====== keySet() ======");
		for (String key : data.keySet()) {
			System.out.println(key + "=>" + data.get(key));
		}

		// 2. entrySet
		System.out.println("====== entrySet() ======");
		for (Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}

		// 3. Iterator
		System.out.println("====== Iterator ======");
		Set<Map.Entry<String, Integer>> entrySet = data.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}

		System.out.println(data.containsKey("A"));
		System.out.println(data.containsKey("AA"));
		System.out.println(data.containsValue(99));
		System.out.println(data.containsValue(44));

	}
}
