package com.shinhan.day12.c17_1_stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.shinhan.day12.review.Product;
import com.shinhan.day12.review.Student;

public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		f6();
	}
	
	// 파일로부터 stream 얻기
	private static void f6() throws URISyntaxException, IOException {
		URI uri = StreamTest.class.getResource("data.txt").toURI();
		System.out.println(uri);
		Path path = Paths.get(uri);
		System.out.println(path);
		
		// Stream : Files.lines(path)
		Files.lines(path).forEach(line->System.out.println(line));
	}
	
	private static void f5() {
		IntStream.range(1, 6).forEach(i->System.out.println(i));
		System.out.println("=============");
		IntStream.rangeClosed(1, 6).forEach(i->System.out.println(i));
	}

	private static void f4() {
		String[] arr = { "A", "B", "C", "D", "E" };
		int[] scores = { 100, 99, 88, 77 };
		Arrays.stream(arr).forEach(name -> System.out.println(name));
		double result = Arrays.stream(scores).average().getAsDouble();
		System.out.println(result);
	}

	private static void f3() {
		List<Product> list = new ArrayList<>();

		IntStream.range(0, 5).forEach(i -> {
			Product product = new Product(i, "상품" + i, "멋진회사", (int) (Math.random() * 10000));
			list.add(product);
		});
		list.stream().forEach(p -> System.out.println(p));

		int total = list.stream().mapToInt(p -> p.getPrice()).sum();
		System.out.println(total);

	}

	private static void f2() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("A", 100));
		data.add(new Student("C", 400));
		data.add(new Student("A", 100));
		data.add(new Student("D", 600));
		data.add(new Student("B", 400));

		// Map : 변형하다.
		Double avg = data.stream().mapToInt(s -> s.getScore()).average().getAsDouble();
		System.out.println(avg);
	}

	private static void f1() {
		List<String> data = new ArrayList<>();
		data.add("A");
		data.add("B");
		data.add("C");
		data.add("D");

		// 외부 반복자(Iterator)
		for (String s : data) {
			System.out.println(s);
		}

		// 내부 반복자(Stream)
		data.stream().forEach(a -> System.out.println(a));

		// 병렬처리
		data.parallelStream().forEach(a -> {
			System.out.println("Thread name: " + Thread.currentThread().getName() + "----" + a);
		});
	}
}
