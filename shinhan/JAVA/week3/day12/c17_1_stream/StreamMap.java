package com.shinhan.day12.c17_1_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.shinhan.day12.review.Student;

public class StreamMap {

	static List<Student> data = new ArrayList<>();
	static {
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 88));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 99));
		data.add(new Student("심은지", 55));
	}

	public static void main(String[] args) {
		f6();
	}
	
	private static void f6() {
		List<String> list1 = Arrays.asList("10, 20, 30", "40, 50", "60, 70");
		
		double d =  list1.stream()
		.flatMap(one->Arrays.stream(one.split(",")))
		.map(data->data.trim())
		.mapToInt(i->Integer.parseInt(i)).average().getAsDouble();
		
//		.forEach(data->System.out.println(data));
		System.out.println(d);
	}

	private static void f5() {
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50", "60, 70");
		double dd = list2.stream().flatMap(one -> {
			String[] arr = one.split(",");
			Integer[] arr2 = new Integer[arr.length];
			for(int i=0;i<arr.length;i++) {
				arr2[i] = Integer.parseInt(arr[i].trim());
			}
			return Arrays.stream(arr2);
		}).mapToInt(i->i).average().getAsDouble();
//		.forEach(data -> System.out.println(data));
		System.out.println(dd);
	}

	private static void f4() {
		List<String> list1 = new ArrayList<String>();
		list1.add("this is a java");
		list1.add("i am a best developer");

		// flatMap (Fucntion<T, R>) T가 들어가고 R이 나온다.
		// T : String
		// R : stream
		list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(data -> System.out.println(data));

		String[] arr = list1.get(0).split(" ");
		Arrays.stream(arr).forEach(a -> System.out.println(a));
	}

	private static void f3() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };

		Arrays.stream(arr).asDoubleStream().forEach(d -> System.out.println(d));
		;

		Arrays.stream(arr).boxed() // int -> Integer
				.forEach(d -> System.out.println(d.intValue()));
		;
	}

	private static void f2() {
		// map은 들어간 것과 나오는 것이 다르다. (변형)
		data.stream().map(st -> st.getName() + "$$").forEach(name -> System.out.println(name));
	}

	private static void f1() {
		// mapToInt : 객체가 들어가고 int가 나온다.
		data.stream().mapToInt(st -> st.getScore()) // IntStream
				.forEach(st -> System.out.println(st));

		IntStream scoreStream = data.stream().mapToInt(st -> st.getScore());
		System.out.println(scoreStream.average().getAsDouble());
	}
}
