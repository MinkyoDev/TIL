package com.shinhan.day12.c17_problem;

import java.util.Arrays;
import java.util.List;

import com.shinhan.day12.Member;

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class Problem06 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", 30), new Member("신용권", 40), new Member("감자바", 26));
		 double avg = list.stream().mapToInt(s->s.getAge()).average().getAsDouble();

		System.out.println("평균 나이: " + avg);
	}
}