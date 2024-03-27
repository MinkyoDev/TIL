package com.shinhan.day12.c17_1_stream;

import java.util.Arrays;

public class StreamLooping {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		// forEach : 최종 처리 메서드
		Arrays.stream(arr).forEach(data->System.out.println(data));
		
		System.out.println("------------------");
		// peek : 중간처리 메서드
		int result = Arrays.stream(arr).peek(data->System.out.println(data)).sum();
		System.out.println(result);
	}
}
