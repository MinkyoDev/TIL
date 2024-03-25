package com.shinhan.day10.c13_problems;

import java.lang.annotation.Retention;

class Container<T> {

	T data;

	void set(T data) {
		this.data = data;
	}

	T get() {
		return data;
	}
}

public class Problem2 {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
	}

}