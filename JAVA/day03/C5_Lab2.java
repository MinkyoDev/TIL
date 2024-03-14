package com.shinhan.day03;

public class C5_Lab2 {

	public static void main(String[] args) {
		problem1();
		problem2();
	}

	private static void problem2() {
		String addr = "서울시,강남구,역삼동,삼성 SDS 멀티캠퍼스";
		String[] addrArr = split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for (int i = 0; i < addrArr.length; i++) {
			System.out.print(addrArr[i] + " ");
		}

	}

	private static String[] split(String str, char seperator) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == seperator) {
				cnt += 1;
			}
		}

		String[] arr = new String[cnt+1];
		String temp = "";
		int index = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == seperator) {
				arr[index] = temp;
				index += 1;
				temp = "";
			} else {
				temp += str.charAt(i);
			}
		}		
		arr[index] = temp;
		
		return arr;
	}

	private static void problem1() {
		System.out.println("-------------Sample 1 --------------");
		String result1 = myReplace("hello world", 'l', '*');
		System.out.println(result1);

		System.out.println("-------------Sample 2 --------------");
		String result2 = myReplace("hello world", ' ', '-');
		System.out.println(result2);

		System.out.println("-------------Sample 3 --------------");
		String result3 = myReplace("hello world", 'a', '*');
		System.out.println(result3);
	}

	private static String myReplace(String str, char target, char re) {
		String temp = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == target) {
				temp += re;

			} else {
				temp += str.charAt(i);
			}
		}
		return temp;
	}
}
