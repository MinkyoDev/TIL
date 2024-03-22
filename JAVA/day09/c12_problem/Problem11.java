package com.shinhan.day09.c12_problem;

import java.util.StringTokenizer;

public class Problem11 {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		StringTokenizer token = new StringTokenizer(",| ");
		
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
	}
}
