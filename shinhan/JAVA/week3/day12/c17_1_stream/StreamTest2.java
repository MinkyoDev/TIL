package com.shinhan.day12.c17_1_stream;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.shinhan.day12.review.Product;
import com.shinhan.day12.review.Student;

public class StreamTest2 {

	public static void main(String[] args) {
		f3();
	}
	
	private static void f3() {
		List<Product> list = new ArrayList<>();

		IntStream.range(0, 5).forEach(i -> {
			Product product = new Product(i, "상품" + i, "멋진회사", (int) (Math.random() * 10000));
			list.add(product);
		});
		
		list.stream()
//		.filter(p->p.getPno()>2)
//		.filter(p->p.getName().startsWith("상품"))
		.filter(p->p.getPrice()>5000)
		.forEach(p->System.out.println(p));
	}

	private static void f2() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 88));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 99));
		data.add(new Student("심은지", 55));

		System.out.println("===============");
		data.stream()
		.distinct()
		.filter(st -> st.getScore() >= 90)
		.forEach(st -> System.out.println(st));

		System.out.println("===============");
		data.stream()
		.distinct()
		.filter(st -> st.getName().startsWith("심"))
		.forEach(st -> System.out.println(st));
	}

	private static void f1() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("A");
		list.add("AAA");
		list.add("B");
		list.add("B");
		list.add("C");
		list.add("C");
		list.add("D");

		list.stream().distinct() // 중복 제거
				.filter(name -> name.length() >= 2) // filter(Predicate) 조건에 맞으면 선택 Predicate의 return이 true인 것만
				.forEach(name -> System.out.println(name));
	}

	private static void charset() {
		// 하나의 문자를 멏바이트 처리하는가? UTF-8 (3byte)
		System.out.println(Charset.defaultCharset());
	}
}
