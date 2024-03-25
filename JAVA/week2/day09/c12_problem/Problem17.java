package com.shinhan.day09.c12_problem;

import java.util.regex.Pattern;

public class Problem17 {

	public static void main(String[] args) {
		// 첫번째 알파벳으로 시작하고 두번째부터 숫자와 알파뱃으로 구성된 8~12자리 ID 검사
		// ^ 시작
		// [^] 제외
		// $ 끝
		 String id = "5Angel1004z";
//		 String regExp = "^[0-9][0-9A-Za-z]{8,12}";
		 String regExp = "^[0-9]\\w{8,12}z$";
		 boolean isMatch = Pattern.matches(regExp, id);
		 if(isMatch) {
		 System.out.println("ID로 사용할 수 있습니다.");
		 } else {
		 System.out.println("ID로 사용할 수 없습니다.");
		 }
		}
}
