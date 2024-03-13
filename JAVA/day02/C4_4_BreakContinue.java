package com.shinhan.day02;

public class C4_4_BreakContinue {

	public static void main(String[] args) {
		method2();
	}
	
	private static void method1() {
		aa: for (int gop = 1; gop <= 9; gop++) {
//			if (gop == 4) break;
			for (int dan = 2; dan <= 9; dan++) {
//				if (dan == 5) break; // 가장 가까운 반복문 빠지기
				if (dan == 5) break aa; // 원하는 반복문 빠지기 (label 부여)
				System.out.printf("%2d*%2d=%2d", dan, gop, dan * gop);
			}
			System.out.println();
		}
	}
	
	private static void method2() {
		aa: for (int gop = 1; gop <= 9; gop++) {
//			if (gop == 4) continue; // loop안에 있는 아래 코드들를 무시, 조건문으로 이동
			for (int dan = 2; dan <= 9; dan++) {
//				if (dan == 5) continue; // 가장 가까운 반복문의 조건문으로 이동
				if (dan == 5) continue aa; // 원하는 반복문의 조건문으로 이동 (label 부여)
				System.out.printf("%2d*%2d=%2d ", dan, gop, dan * gop);
			}
			System.out.println();
		}
	}
}
