package com.shinhan.day12.c17_problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Member {
	private String name;
	private String job;

	public Member(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
}

public class Problem07 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", "개발자"), new Member("김나리", "디자이너"),
				new Member("신용권", "개발자"));

		List<Member> developers = list.stream()
				.filter(m->m.getJob()=="개발자").collect(Collectors.toList());
		List<Member> developers2 = list.stream()
				.filter(m->m.getJob()=="개발자").toList();

		developers.stream().forEach(m -> System.out.println(m.getName()));
	}
}