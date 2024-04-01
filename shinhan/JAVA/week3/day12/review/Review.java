package com.shinhan.day12.review;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

// Collection
// List : add한 순서 있음, index 가능, 중복 가능 
//     => ArrayList(중간 삽입삭제 비효율적, 추가는 효율적)
//     => LinkedList(다음 데이터, 전 데이터의 주소를 가진다. 공간차지, 중간 삽입, 삭제 효율적)
//     => Vector(동기화 지원, 멀티쓰레드 환경에 안정적)
// Set : 순서 없음, 중복 불가 
//     => HashSet(hashcode(), equals() 필요)
//     => TreeSet(add시 sort한다. compareTo 필요)
// Map : 키와 값의 쌍(entry), 키는 set이다.
//     => HashMap, Hashtable, TreeMap, Properties

public class Review {

	public static void main(String[] args) {
		f6();
	}
	
	private static void f6() {
//		Map<Student, Product> map = new HashMap<>();
//		Map<Student, Product> map = new TreeMap<>();
		Map<Student, Product> map = new Hashtable<>();
		map.put(new Student("A", 100), new Product(1, "notebook1", "samsung", 200));
		map.put(new Student("A", 100), new Product(2, "notebook2", "samsung", 200));
		map.put(new Student("B", 300), new Product(3, "notebook3", "samsung", 200));
		map.put(new Student("D", 600), new Product(4, "notebook4", "samsung", 200));
		map.put(new Student("C", 200), new Product(5, "notebook5", "samsung", 200));
		
		print(map);
		
	}

	private static void f5() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 100);
		map.put("A", 200); // 덮어쓰기
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);
		
		print(map);
	}

	private static <K, V> void print(Map<K, V> map) {
		System.out.println("------ketSet------");
		for (K key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println("------entrySet------");
		for (Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	private static void f4() {
		Set<Student> data = new TreeSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));
		data.add(new Student("D", 70)); // -> TreeSet에서는 비교하는 항목 기준으로 set

		print(data);
	}

	private static void f3() {
		Set<Student> data = new HashSet<Student>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));
		data.add(new Student("D", 70));

		print(data);
	}

	private static void print(Set<Student> data) {
		for (Student s : data) {
			System.out.println(s);
		}
	}

	private static void f2() {
		Set<String> data = new HashSet<>();
		data.add("월요일");
		data.add("월요일");
		data.add("화요일");
		data.add("토요일");

		System.out.println(data);
	}

	private static void f1() {
//		List<String> data = new ArrayList<>();
//		List<String> data = new LinkedList<>();
		List<String> data = new Vector<>();
		data.add("월요일");
		data.add("월요일");
		data.add("화요일");
		data.add("토요일");

		System.out.println(data);
	}

	private static void print(Collection<String> data) {
		for (String s : data) {
			System.out.println(s);
		}

	}
}
