package com.shinhan.day08.c11_1_exception;

public class ScoreExceptionTest {

	public static void main(String[] args) {
		method1(60);
		
		try {
			method2(60);
		} catch (ScoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method2(int score) throws ScoreException {
		if (score <= 70)
			throw new ScoreException("70 초과만 가능");

	}

	private static void method1(int score) {
		try {
			if (score <= 70)
				throw new ScoreException("70 초과만 가능");
		} catch (ScoreException e) {
			System.out.println(e.getMessage());
		}

	}
}
