package com.shinhan.day02;

public class C3_1_OperaterTest {

	public static void main(String[] args) {
		method8();
	}

	private static void method8() {
		int i = 100;
		int j = 0;

		if (j != 0) {
			System.out.println(100 / j);
		}
		
		// 삼항연산자. 위의 if문과 같음
		System.out.println(j!=0?100/j:"");
		System.out.println(j==0?"0으로 나눌 수 없음":"나누기 가능");


	}

	private static void method7() {
		int var1 = 100;
		int var2 = 100;
		
		// 비교연산자가 논리연산자보다 우선순위가 높다
		// &&는 앞이 거짓이면 뒤를 수행안함
		// &는 앞의 결과와 무관하게 모두 수행
		// ||는 앞의 결과가 참이면 뒤를 수행안함
		// |는 앞의 결과와 무관하게 모두 수행
		boolean result1 = var1 > var2 && ++var1 > 100; // 앞이 거짓이면 뒤 실행 안함. 그래서 var1 = 100
		boolean result2 = var1 > var2 || ++var1 > 100;
		
		System.out.println(result1);
		System.out.println(var1);
		
		System.out.println(result2);
		System.out.println(var1);
		
		System.out.println(!result2);

	}

	private static void method6() {
		int var1 = 100;
		int var2 = 100;
		String str1 = "자바"; // 컴파일 시점에 할당
		String str2 = "자바";
		String str3 = new String("자바");
		String str4 = new String("자바");

		System.out.println(var1 == var2); // 기본형은 값을 비교
		System.out.println(str1 == str2); // 객체는 주소비교(true)
		System.out.println(str3 == str4); // 객체는 주소비교(false)

		System.out.println(System.identityHashCode(str1)); // 주소 얻는법
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));

		System.out.println(str3.equals(str4));
		System.out.println(str1.equals(str4));

		// 문자열은 값 변경 불가, 주소가 달라짐
		str1 = str1 + "프로그램";
		str2 = str2 + "프로그램";

		System.out.println(str1 == str2);
	}

	private static void method5() {
		int i = 100;
		int j = 0;

		// 정수는 0으로 나누기 불가(Exception 발생, 프로그램 중단)
		// 중단을 막으려면? 1. 0이면 수행 X 2. Exception처리
		if (j != 0) {
			System.out.println(100 / 0);
		}
		
		System.out.println(100 / 0.0); // Infinity나옴
		System.out.println(100 % 0.0); // NaN(Not a Number)

	}

	private static void method4() {
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		double result = apple - pieceUnit * number;

		System.out.println(result); // 정수형으로 계산하면 결과가 이상하게 나옴
	}

	private static void method3() {
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;

		a++;
		a++;
		a++; // 오버플로우
		b--;
		b--;
		b--; // 언더플로우

		System.out.println(a);
		System.out.println(b);
	}

	private static void method2() {
		int a = 10;
		int b = 3;

		System.out.println("더하기: " + (a + b));
		System.out.println("빼기: " + (a - b));
		System.out.println("곱하기: " + a * b);
		System.out.println("몫: " + a / b);
		System.out.println("나머지: " + a % b);

	}

	private static void method1() {
		int var1 = 100;
		System.out.println(++var1); // 연산 후 출력
		System.out.println(var1++); // 출력 후 연산
		System.out.println(var1);
	}
}
