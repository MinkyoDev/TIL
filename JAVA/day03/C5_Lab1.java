package com.shinhan.day03;

import java.util.Arrays;

public class C5_Lab1 {

	public static void main(String[] args) {
//		problem1();
		problem2();

	}
	
	private static void problem2() {
		int[][] a = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50 } };
		int[][] b = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] c=new int[3][4];
		
		c = sub(a, b, c);
		prn(c);
	}

	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}
	
	public static void prn(int[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void problem1() {
		int[] arr = { 3, 24, 1, 55, 17, 43, 5 };

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {

				int num1 = arr[j];
				int num2 = arr[j + 1];

				if (num1 > num2) {
					arr[j] = num2;
					arr[j + 1] = num1;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
