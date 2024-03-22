package com.shinhan.day09.c12_4_otherClasses;

public class WrapperTest {

	public static void main(String[] args) {
		f2();
	}
	
	private static void f2() {
		// TODO Auto-generated method stub
			String s = "100";
			String s2 = "100.45";
			
			int b = Integer.parseInt(s);
			double d = Double.parseDouble(s2);
	}

	private static void f1() {
		Integer a = 100;  // Auto Boxing
//		Integer aa = new Integer(100);  // depricated
		
		int b = a.intValue() + 200;  // UnBoxing
		int bb = a + 200;
	}
}
