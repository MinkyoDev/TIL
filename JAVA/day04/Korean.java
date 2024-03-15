package com.shinhan.day04;

// class : 틀. 특징, 행위를 정의
// object : 다른 object와 구별되는 독립된 특징을 부여

public class Korean {

	// 1. field
	private String nation = "대한민국";
	String name;
	String ssn;

	// 2. constructor : 목적이 초기화
	Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	Korean(String name) {
		this.name = name;
	}

	// 3. method : return type 필수
	void print() {
		System.out.println(nation);
		System.out.println(name);
		System.out.println(ssn);
	}
}
