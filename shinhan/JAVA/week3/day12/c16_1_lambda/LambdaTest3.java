package com.shinhan.day12.c16_1_lambda;

import com.shinhan.day12.review.Student;

@FunctionalInterface
interface MyComparable {

	int compare(String a, String b);
}

@FunctionalInterface
interface Creatable {

	public Student create(String name, int score);
}

class Person {

	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create(name, score);
	}
}

public class LambdaTest3 {

	public static void main(String[] args) {
		f2();
	}

	public static void f2() {
		Person p1 = new Person();
		Creatable creatable1 = new Creatable() {

			@Override
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};
		Student s1 = p1.getStudent(creatable1, "홍길동", 1100);

		Creatable creatable2 = (name, score) -> new Student(name, score);
		Student s2 = p1.getStudent(creatable2, "김길동", 1100);
		System.out.println(s2);
		
		Creatable creatable3 = Student::new;
		Student s3 = p1.getStudent(creatable3, "이길동", 11300);
		System.out.println(s3);
	}

	public static void f1() {
		String s1 = "홍길동aaa";
		String s2 = "김길동";

		MyComparable com = new MyComparable() {

			@Override
			public int compare(String a, String b) {
				return 0;
			}
		};

		MyComparable com2 = (a, b) -> a.length() - b.length();
		int result = com2.compare(s1, s2);
		System.out.println(result);

		String s3 = "A";
		String s4 = "C";
		MyComparable com3 = String::compareToIgnoreCase;
		int result3 = com3.compare(s3, s4);
		System.out.println(result3);
	}
}
