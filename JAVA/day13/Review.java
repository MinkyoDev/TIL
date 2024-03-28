package com.shinhan.day13;

import java.util.Arrays;

import com.shinhan.day12.review.Student;

interface Makeable {
	public Student makeStudent(String name, int score);
}

class StudentMakeClass {
	public StudentMakeClass(String name, int score) {

	}
}

public class Review {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		int[] arr = { 1, 2, 3, 4, 5 };

		// 향상for : 외부 반복자 iterator
		for (int i : arr) {
			System.out.println(i);
		}

		// 내부 반복자
		Arrays.stream(arr).forEach(i -> System.out.println(i)); // forEach 최종단계
		int result = Arrays.stream(arr).peek(i -> System.out.println(i)).sum(); // peek 중간단계
		System.out.println("sum: " + result);
	}

	private static void f1() {
		Makeable make1 = (n, s) -> new Student(n, s); // 람다식
		Makeable make2 = Student::new; // 람다식 생성자 참조

		Student s1 = make1.makeStudent("상호", 100);
		Student s2 = make2.makeStudent("상호2", 200);

		System.out.println(s1);
		System.out.println(s2);
	}
}
