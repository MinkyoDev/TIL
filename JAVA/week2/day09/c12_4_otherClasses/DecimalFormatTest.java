package com.shinhan.day09.c12_4_otherClasses;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		int a = 1234567890;
		
		DecimalFormat format = new DecimalFormat("###,###,###");
		System.out.println(format.format(a));
		
		System.out.println(a);
	}
}
