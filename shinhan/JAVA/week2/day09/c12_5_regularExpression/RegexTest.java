package com.shinhan.day09.c12_5_regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
//		f1();
		f2();
	}

	// . : 임의의 문자 1자
	// + : 한개 이상
	// [] : 선택
	// [-] : 범위
	// {3} : 횟수
	// \\d : [0-9]와 같은 의미
	// \\w : [0-9A-Za-z]와 같은 의미
	
	private static void f2() {
		// email
		String regExp = "([0-9A-Za-z]+)@(\\w+\\.\\w+)";
		String date = "isakin@gmail.com";
		String date2 = "isakin@gmail/com";
		
		boolean result = Pattern.matches(regExp, date);
		System.out.println(result);
		boolean result2 = Pattern.matches(regExp, date2);
		System.out.println(result2);
		
		String date3 = "isakin@gmail.com pepero@naver.com alsru@daum.net";
		Pattern pattern = Pattern.compile(regExp);
		Matcher mat = pattern.matcher(date3);
		while (mat.find()) {
			System.out.println(mat.group());
			System.out.println(mat.group(0));  // 전체 
			System.out.println(mat.group(1));  // 첫번째 ()
			System.out.println(mat.group(2));  // 두번째 ()
			System.out.println("-----------------");
		}
	}

	private static void f1() {
		// 전화번호
		// 제어문자 - \t, \n, \" ....
		// \\ -> \를 의미함
		String regExp = "[01]{3}-[0-9]{3,4}-\\d{3,4}"; 
		String data = "010-1234-5678";
		String data2 = "1010-1234-5678";

		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		boolean result2 = Pattern.matches(regExp, data2);
		System.out.println(result2);

		String data3 = "짜장면집 010-1234-5678 스시집 011-8794-352 sssss 222-2222-22 aaaa011-8324-1111";
		Pattern pattern = Pattern.compile(regExp);
		Matcher mat = pattern.matcher(data3);
		while (mat.find()) {
			System.out.println(mat.group());
		}

	}
}
