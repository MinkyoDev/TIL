package com.shinhan.day12.c17_1_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.shinhan.day12.review.Student;

public class StreamCollect {

	static List<Student> data = new ArrayList<>();
	static {
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 88));
		data.add(new Student("신용권2", 110));
		data.add(new Student("심은정", 99));
		data.add(new Student("이은지", 55));
	}
	
	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		List<Student> data2 = new ArrayList<>();

		data2.add(new Student("신용권", 100, "남"));
		data2.add(new Student("정민교", 88, "남"));
		data2.add(new Student("신용권2", 110, "남"));
		data2.add(new Student("심은정", 99, "여"));
		data2.add(new Student("이은지", 55, "여"));

		Map<String, List<Student>> map = data2.stream().collect(Collectors.groupingBy(st -> st.getGender()));
		map.get("남").stream().forEach(st -> System.out.println(st));

	}

	public static void f1() {
		// List->Map {"신용권", 100},{...
		// Map은 키값이 중복 불가
		Map<String, Integer> map = data.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));
		System.out.println(map);

//		data.stream().collect(Collectors.toSet(s->s.getName())).forEach(s->syso);
	}
}
