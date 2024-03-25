package com.shinhan.day10.c13_problems;

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class Util {

	static <K, V> V getValue(Pair<K, V> value, String name) {
		if (value.getKey().equals(name)) return value.getValue();
		return null;
	}
	
	static <P extends Pair<K, V>, K, V> V getValue2(P pair, K k) {
		if (pair.getKey().equals(k)) return pair.getValue();
		return null;
	}
}

public class Problem4 {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순");
		System.out.println(childAge);

//		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//		// OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생
//		int otherAge = Util.getValue(otherPair, "홍삼원");
//		System.out.println(otherAge);
		
		Pair<String, String> pair2 = new Pair<>("홍길동", "35s");
		String age2 = Util.getValue(pair2, "홍길동");
		System.out.println(age2);
	}
}
