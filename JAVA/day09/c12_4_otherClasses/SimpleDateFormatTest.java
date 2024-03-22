package com.shinhan.day09.c12_4_otherClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.shinhan.util.DateUtil;

public class SimpleDateFormatTest {

	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		System.out.println((d));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(sdf.format(d));
		
		// String -> Date
		String s = "2024-03-22";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d2 = sdf2.parse(s);
			java.sql.Date d3 = new java.sql.Date(d2.getTime());
			System.out.println(d2);
			System.out.println(d3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(DateUtil.getUtilDate(s));
		System.out.println(DateUtil.getSQLDate(s));
	}
}
