package com.shinhan.day07.c09_4_anonymous2;

public interface Machine {

	void powerOn(String title);
}

// 1. interface 구현 class를 만든다. 만약 만들어야 하는 경우가 많다면 좋은 방법이 아님.
// 2. 익명 구현 class 제작. 필요시마다 만들고 제거
// 3. interface 내에 메서드가 하나밖에 없다면 람다 표현식 이용.