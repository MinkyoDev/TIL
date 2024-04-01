package com.shinhan.day09.lab1;

import java.util.Arrays;

public class Median {
	public static void main(String[] args) {
		Median median = new Median();
		int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };

		System.out.println("input : " + Arrays.toString(values1));
		System.out.println("median : " + median.findMedian(values1));
		System.out.println("===============================");

		int[] values2 = { 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };

		System.out.println("input : " + Arrays.toString(values2));
		System.out.println("median : " + median.findMedian(values2));
	}

	public int findMedian(int[] values) {
		// 작성
		Arrays.sort(values);
		int total = 0;
		for (int value : values) {
			total += value;
		}
		double avg = (double) total / values.length;

		double minMedian = 1000;
		for (int value : values) {
			if (Math.abs(avg - value) < Math.abs(avg - minMedian)) {
				minMedian = value;
			}
		}
		return 0;
	}
}