package com.shinhan.week1.day03;

public class C5_3_EnumTest {

	// 상수 : 변하지 않는 값 final static
	final static int SUCCESS = 1;
	final static int FAIL = 0;
	final static int PLAY = 2;

	public static void main(String[] args) {
		f2();
	}
	
	private static void f2() {
		Week[] arr = Week.values();
		
		for (Week week:arr) {
			System.out.println(week + "--" + week.ordinal() + "--" + week.name());
		}
		call2(Week.FRIDAY);
		call2(Week.SUNDAY);
	}

	private static void call2(Week day) {
		switch (day) {
		case MONDAY:
			System.out.println("월요일 입니다."); break;
		case TUESDAT:
			System.out.println("화요일 입니다."); break;
		case WENSDAY:
			System.out.println("수요일 입니다."); break;
		case THURSDAY:
			System.out.println("목요일 입니다."); break;
		case FRIDAY:
			System.out.println("금요일 입니다."); break;
		case SATURDAY:
			System.out.println("토요일 입니다."); break;
		case SUNDAY:
			System.out.println("일요일 입니다."); break;
		}
	}

	private static void f1() {
		int score = 100;
		Enum result;
		
		if (score >= 90) {
			result = Enum.SUCCESS;
		} else {
			result = Enum.FAIL;
		}
		System.out.println(result);
		
	}
}
