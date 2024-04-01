package com.shinhan.day10.c13_2_genericInterface;

// 타입 파라메터는 영문 대문자 아무거나
public interface Rentable<P> {

	void method1();
	P rent();
}
