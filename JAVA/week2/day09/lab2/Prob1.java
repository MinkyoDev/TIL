package com.shinhan.day09.lab2;

public class Prob1 {

	public static void main(String[] args) {
		String str = "everyday we have is one more than we deserve";

		System.out.println("암호화할 문자열: " + str);
		String result = convert(str, 3);
		System.out.println("암호화된 문자열: " + result);
	}

	private static String convert(String str, int i) {
		String result = "";
		for (char ch : str.toCharArray()) {
			if (ch == 32) {
				result += ' ';
			} else {
				if (ch + i > 122) {
					result += (char) (ch + i - 26);
				} else {
					result += (char) (ch + i);
				}
			}
		}
		return result;
	}
}
