package com.shinhan.day12.c17_1_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import com.shinhan.day12.review.Product;
import com.shinhan.day12.review.Student;

public class StreamSort {

	static List<Student> data = new ArrayList<>();
	static {
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 88));
		data.add(new Student("상용권", 100));
		data.add(new Student("심은정", 99));
		data.add(new Student("이은지", 55));
	}

	public static void main(String[] args) {
		f4();
	}
	
	private static void f4() {
		
	}
	
	private static void f3() {
		int[][] arr = { { 1, 4 }, { 5, 6 }, { 2, 3 }, { 2, 4 } };
		Arrays.stream(arr).sorted((a, b) -> {
			if (b[0] == a[0])
				return a[1] - b[1];
			return b[0] - a[0];
		}).forEach(s -> System.out.println(Arrays.toString(s)));
		
	}

	private static void f2() {
		// Product를 이용해서 Sort연습 (pno, name, company, price)
		List<Product> list = new ArrayList<>();

		IntStream.range(0, 5).forEach(i -> {
			Product product = new Product(i, "상품" + (int) (Math.random() * 10), "멋진회사", (int) (Math.random() * 10000));
			list.add(product);
		});

		list.stream().sorted((a, b) -> {
			if (b.getName().equals(a.getName()))
				return a.getPrice() - b.getPrice();
			return b.getName().compareTo(a.getName());
		}).forEach(st -> System.out.println(st));

		System.out.println("=====================");
		IntStream.range(0, 10)
				.mapToObj(i -> new Product(i, "상품" + (int) (Math.random() * 10), "멋진회사", (int) (Math.random() * 10000)))
				.sorted((a, b) -> b.getPrice() - a.getPrice()).forEach(st -> System.out.println(st));
	}

	private static void f1() {
		// Student는 implements Comparable : compareTo()
		System.out.println("=====================");
		// score asc, name desc
		data.stream().sorted().forEach(st -> System.out.println(st));

		System.out.println("=====================");
		data.stream().sorted((a, b) -> a.getName().compareTo(b.getName())) // 이름으로 asc
				.forEach(st -> System.out.println(st));

		System.out.println("=====================");
		Comparator<Student> comparator = (a, b) -> a.getName().compareTo(b.getName());
		Comparator<Student> comparator2 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};

		data.stream().sorted(comparator2) // 이름으로 desc
				.forEach(st -> System.out.println(st));
	}
}
