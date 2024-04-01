package com.shinhan.day12.c16_problem;

import java.util.Arrays;

@FunctionalInterface
interface Function<T> {
	public double apply(T t);
}

class Student {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
}

public class Problem09 {

	private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

	// avg() 메소드 작성
	private static double avg(Function<Student> function) {
		return Arrays.stream(students).mapToDouble(s->function.apply(s)).average().getAsDouble();
	}

	public static void main(String[] args) {
		double englishAvg = avg(Student::getEnglishScore);
		System.out.println("영어 평균 점수: " + englishAvg);

		double mathAvg = avg(Student::getMathScore);
		System.out.println("수학 평균 점수: " + mathAvg);
	}
}