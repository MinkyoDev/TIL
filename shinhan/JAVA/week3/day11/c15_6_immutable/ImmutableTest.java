package com.shinhan.day11.c15_6_immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableTest {

	// 변경불가 immutable(of)
	public static void main(String[] args) {
		String[] arr = { "자바", "디비", "웹", "프레임워크" };

		List<String> alist = Arrays.asList(arr);
//		alist.add("AAAA");  // 불가능
		System.out.println(alist);

		List<String> alist2 = List.of("자바", "디비", "웹", "프레임워크");
//		alist.add("AAAA");  // 수정불가
		System.out.println(alist2);

		Set<String> aset = Set.of("자바", "디비", "웹", "프레임워크"); // 중복데이터는 불가
		System.out.println(aset);

		Map<Integer, String> amap = Map.of(1, "자바", 2, "디비", 3, "웹", 4, "프레임워크"); // 중복데이터는 불가
//		amap.put(5, "aaa");  // 수정 불가
		System.out.println(amap);
		System.out.println(amap.keySet());
		
		List<String> alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
//		alist4.add("aaaa");  // copyOf를 쓰면 수정불가
	}
}
