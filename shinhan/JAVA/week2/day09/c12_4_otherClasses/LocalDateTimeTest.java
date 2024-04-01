package com.shinhan.day09.c12_4_otherClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.now();
		LocalDate d2 = LocalDate.now();
		
		System.out.println(d);
		System.out.println(d2);
		
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDayOfMonth());
		System.out.println(d.getDayOfWeek());
		System.out.println(d.getHour());
	}
}
