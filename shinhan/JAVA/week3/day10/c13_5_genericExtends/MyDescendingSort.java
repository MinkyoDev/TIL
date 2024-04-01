package com.shinhan.day10.c13_5_genericExtends;

import java.util.Comparator;

public class MyDescendingSort implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}


}
