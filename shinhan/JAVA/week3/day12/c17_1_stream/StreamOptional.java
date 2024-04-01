package com.shinhan.day12.c17_1_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import com.shinhan.day12.review.Student;

public class StreamOptional {

	static List<Student> data = new ArrayList<>();
	static {
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 88));
		data.add(new Student("상용권", 100));
		data.add(new Student("심은정", 99));
		data.add(new Student("이은지", 55));
	}

	public static void main(String[] args) {
		f2();
	}

	public static void f2() {
		List<Student> data2 = new ArrayList<>();
		// Student들의 점수 평균 구하기
		data.stream().mapToInt(i -> i.getScore()).average().ifPresentOrElse(d -> {
			System.out.println(d);
		}, () -> {
			System.out.println("값없음");
		});
//				.getAsDouble();
//		System.out.println(avg);

		int sum = data.stream().mapToInt(Student::getScore).sum();
		System.out.println(sum);

		data.stream().mapToInt(Student::getScore).reduce((a, b) -> a + b).ifPresentOrElse(i -> {
			System.out.println("있음: " + i);
		}, () -> {
			System.out.println("없음: ");
		});
	}

	public static void f1() {
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr = {};

		int total = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		OptionalDouble avg = Arrays.stream(arr).average();
		avg.ifPresent(a -> System.out.println(a));
		double result = avg.orElse(0); // default 값을 주기 위하여
		System.out.println(result);

		// first arg: 소비자, second arg: Runnable
		avg.ifPresentOrElse(a -> {
			System.out.println("있다." + a);
		}, () -> {
			System.out.println("없다.");
		});

		System.out.println("total: " + total);
		System.out.println("count: " + count);
	}
}
