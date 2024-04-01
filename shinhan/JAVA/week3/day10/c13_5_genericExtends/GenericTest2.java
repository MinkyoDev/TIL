package com.shinhan.day10.c13_5_genericExtends;

import java.util.Arrays;
import java.util.Comparator;

import com.shinhan.day10.c13_1_generic.Product;
import com.shinhan.day10.c13_4_genericMethod.Car;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Student implements Comparable<Student> {

	String name;
	int score;

//	@Override
//	public int compareTo(Student o) {
//		return score - o.score;  // Ascending
//		return o.score - score;  // Descending
//	}

//	@Override
//	public int compareTo(Student o) {
//		return o.name.compareTo(name);
//	}

	@Override
	public int compareTo(Student o) {
		// 점수로 desc, 같은 점수는 이름으로 asc
		if (o.score == score) {
			return name.compareTo(o.name);
		}
		return o.score - score;
	}

	// 이미 구현된 sort 기준을 변경

}

public class GenericTest2 {

	public static void main(String[] args) {
		f4();
	}

	private static void f4() {
		Car[] arr = { new Car("A", 100, "black"), new Car("B", 400, "red"), new Car("C", 200, "blue"),
				new Car("D", 800, "green"), new Car("E", 600, "pink"), new Car("F", 400, "purple"),
				new Car("F", 400, "blue"), };
		print(arr, "Original");

		// 1. 구현 class
		Arrays.sort(arr);
		print(arr, "price acending");

		// 2. 익명 class
		Arrays.sort(arr, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				int result = o1.getPrice() - o2.getPrice();
				if (result == 0)
					return o2.getModel().compareTo(o1.getModel());
				return result;
			}
		});
		print(arr, "price descending, model acending");

		// 3. lambda 표현식
		Arrays.sort(arr, (o1, o2) -> {
			int result1 = o2.getPrice() - o1.getPrice();
			if (result1 == 0) {
				int result2 = o1.getModel().compareTo(o2.getModel());
				if (result2 == 0)
					return o2.getColor().compareTo(o1.getColor());
				return result2;
			}
			return result1;
		});
		print(arr, "price acending, model descending, color acending");

	}

	private static void f3() {
		Student[] arr = { new Student("A", 100), new Student("B", 20), new Student("B", 40), new Student("C", 20),
				new Student("D", 50), new Student("E", 80), };
		print(arr, "Original");

		// 1. 구현 class
		// Comparable interface를 구현해야 Sort가 가능하다.
		Arrays.sort(arr);
//		print(arr, "Ascending");
		print(arr, "score descending, name acending");

		// 2. 익명 class
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 이름으로 desc, 점수로 asc
				if (o1.name.equals(o2.name)) {
					return o1.score - o2.score;
				}
				return o2.name.compareTo(o1.name);
			}
		});
		print(arr, "name descending, score acending");

		// 3. lambda 표현식
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.name.equals(o2.name)) {
				return o2.score - o1.score;
			}
			return o1.name.compareTo(o2.name);
		});
		print(arr, "name acending, score descending");

	}

	static <T> void print(T[] arr, String title) {
		System.out.println("==========" + title + "==========");
		for (T st : arr) {
			System.out.println(st);
		}

	}

	private static void f2() {
		String[] arr = { "Hello", "Coffee", "Computer", "java", "Java" };

		System.out.println("Original: " + Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println("Ascending: " + Arrays.toString(arr));

		// 2. 익명 class
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
				return o2.compareToIgnoreCase(o1); // 대소문자 구분 없이
			}
		});
		System.out.println("Descending2: " + Arrays.toString(arr));

		// 3. lambda 표현식
		Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
		System.out.println("Descending3: " + Arrays.toString(arr));
	}

	private static void f1() {
		Integer[] arr = { 50, 31, 24, 98, 77, 61 };

		System.out.println("Original: " + Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println("Ascending: " + Arrays.toString(arr));

		// Descending Sort
		// 1. 구현 class
		Arrays.sort(arr, new MyDescendingSort());
		System.out.println("Descending1: " + Arrays.toString(arr));

		// 2. 익명 class
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(o2 - o1);
				return o2 - o1;
			}
		});
		System.out.println("Descending2: " + Arrays.toString(arr));

		// 3. lambda 표현식
		Arrays.sort(arr, (o1, o2) -> o1 - o2);
		System.out.println("Descending3: " + Arrays.toString(arr));
	}
}
