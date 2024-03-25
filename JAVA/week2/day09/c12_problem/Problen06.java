package com.shinhan.day09.c12_problem;

import lombok.AllArgsConstructor;

class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id).append(": ").append(name);
		return builder.toString();
	}
}

@AllArgsConstructor
class MemberVO {

}

public class Problen06 {

	public static void main(String[] args) {
		Member member = new Member("blue", "이파란");
		System.out.println(member);
	}
}
