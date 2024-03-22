package com.shinhan.day09.c12_3_stringClass;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		// spilt은 빈값 허용
		String str = "컴퓨터 커피@지갑, 마이트";
		String[] arr = str.split("@|,| ");

		System.out.println("배열 개수: " + arr.length);
		for (String s : arr) {
			System.out.println("spilt: " + s);
		}

		StringTokenizer st = new StringTokenizer(str, "@|,| ");
		System.out.println("토큰 개수: " + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println("Tokenizer: " + st.nextToken());
		}
	}
}
