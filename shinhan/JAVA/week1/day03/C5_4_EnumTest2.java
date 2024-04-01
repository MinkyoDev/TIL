package com.shinhan.week1.day03;

import java.util.Calendar;
import java.util.Scanner;

public class C5_4_EnumTest2 {
	final static String SUCCESS = "성공";
	final static String FAIL = "실패";
	final static String BOOK = "이것이 자바다."; // 이런 엉뚱한 값이 들어올 때 찾기 쉽도록 Enum을 사용

	public static void main(String[] args) {
//		loginCheck();
		getWeek();
	}

	private static void getWeek() {
		Calendar cal = Calendar.getInstance(); // 객체 생성을 얻기

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0~11
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("년" + year);
		System.out.println("월" + month);
		System.out.println("주" + dayOfWeek);

		Week week = null;
		switch (dayOfWeek) {
		case 1:
			week = Week.SUNDAY;
			break;
		case 2:
			week = Week.MONDAY;
			break;
		case 3:
			week = Week.TUESDAT;
			break;
		case 4:
			week = Week.WENSDAY;
			break;
		case 5:
			week = Week.THURSDAY;
			break;
		case 6:
			week = Week.FRIDAY;
			break;
		case 7:
			week = Week.SATURDAY;
			break;
		}
		System.out.println(week);
	}

	private static void loginCheck() {
		Scanner sc = new Scanner(System.in);
		Enum result;

		System.out.print("ID PASS >>");

		String id = sc.next();
		String pass = sc.next();

		if (id.equals("firstzone") && pass.equals("1234")) {
			result = Enum.SUCCESS;
		} else {
			result = Enum.FAIL;
		}
		System.out.println(result);
		sc.close();
	}
}
