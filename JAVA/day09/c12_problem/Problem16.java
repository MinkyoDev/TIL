package com.shinhan.day09.c12_problem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem16 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		Date d = new Date();
		System.out.println(sdf.format(d));
		
	}
}
