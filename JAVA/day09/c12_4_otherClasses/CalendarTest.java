package com.shinhan.day09.c12_4_otherClasses;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
//		Calendar cal = new Calendar();  // 생성 불가
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
	}
}
