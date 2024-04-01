package com.shinhan.day12.c17_problem;

import java.util.Arrays;
import java.util.List;

public class Problem05 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream()
		.filter(s -> s.toLowerCase().contains("java"))
		.forEach(s -> System.out.println(s));

	}
}