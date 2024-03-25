package com.shinhan.day10.c13_problems;

class Container2<K, V> {

	K key;
	V value;

	public K getKey() {
		return key;
	}

	public void set(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

}

public class Problem3 {
	public static void main(String[] args) {
		Container2<String, String> Container21 = new Container2<String, String>();
		Container21.set("홍길동", "도적");
		String name1 = Container21.getKey();
		String job = Container21.getValue();
		System.out.println(name1 + " " + job);

		Container2<String, Integer> Container22 = new Container2<String, Integer>();
		Container22.set("홍길동", 35);
		String name2 = Container22.getKey();
		int age = Container22.getValue();
		System.out.println(name2 + " " + age);
	}

}