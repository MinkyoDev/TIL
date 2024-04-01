package com.shinhan.day08.c11_1_exception;

public class ExceptionTest2 {

	public static void main(String[] args) {
		method1(70);
		
		try {
			method2(70);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("==========");
	}

	private static void method2(int score) throws Exception {
		if (score <= 70)
			throw new RuntimeException("오류 발생");
		System.out.println("ddddddddddddd");
	}

	private static void method1(int score) {

		// 조건에 맞지 않으면 강제로 예외를 발생(raise)
		try {
			if (score <= 70)
				throw new RuntimeException("오류 발생");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ddddddddddddd");
	}

}
