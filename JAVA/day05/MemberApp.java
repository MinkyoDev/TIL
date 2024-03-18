package com.shinhan.day05;

public class MemberApp {

	public static void main(String[] args) {
		MemverService memberService = new MemverService();
		boolean result = memberService.login("hong2", "1234");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
	}
}
