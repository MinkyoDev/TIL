package com.shinhan.day12.c17_1_stream;

import java.util.Arrays;

public class StreamMatch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		boolean bool = Arrays.stream(arr).anyMatch(a -> a == 3);
		System.out.println(bool);

		boolean bool2 = Arrays.stream(arr).allMatch(a -> a <= 3);
		System.out.println(bool2);
		
		boolean bool3 = Arrays.stream(arr).noneMatch(a -> a <= 0);
		System.out.println(bool3);
	}
}
