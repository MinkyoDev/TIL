package com.shinhan.week2.day08.c11_1_exception;

public class ScoreException extends Exception {

	String message;
	public ScoreException(String message) {
//		this.message =message;
		super(message);
	}
	
	void print() {
		System.out.println("score는 70점 이상이여야 합니다.");
	}
}
