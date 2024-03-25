package com.shinhan.day09.c12_problem;

import java.util.Random;

public class Problem14 {

	public static void main(String[] args) {
		double d = Math.random();
		System.out.println(d);
		
		Random r = new Random();
		double d2 = r.nextDouble(10);
		System.out.println(d2);
		
		double d3 = r.nextInt();
		System.out.println(d3);
	}
}
