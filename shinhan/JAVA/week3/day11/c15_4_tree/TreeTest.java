package com.shinhan.day11.c15_4_tree;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class TreeTest {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("apple1", 10);
		treeMap.put("apple4", 20);
		treeMap.put("apple5", 40);
		treeMap.put("apple2", 50);
		treeMap.put("apple3", 30);

		print(treeMap, "original");
		print2(treeMap, "original");
		print3(treeMap, "find");

		NavigableMap<String, Integer> datas = treeMap.descendingMap();
		print(treeMap.descendingMap(), "descendingMap");
	}

	private static void print3(TreeMap<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.firstEntry());
	}

	private static void print2(TreeMap<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		for (Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

	private static void print(Map<String, Integer> treeMap, String string) {
		System.out.println("----- " + string + " -----");
		for (String key : treeMap.keySet()) {
			System.out.println(key + " => " + treeMap.get(key));
		}
	}

	private static void f1() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		System.out.println("----- 기본 출력은 Ascending Sort -----");
		print(scores);
//		print2(scores);

		System.out.println("----- Descending Sort -----");
		print(scores.descendingSet());
//		NavigableSet<Integer> descScoreSet = scores.descendingSet();
//		for(Integer data: descScoreSet) {
//			System.out.println(data);
//		}

		System.out.println("----- tailSet -----");
		print(scores.tailSet(80, true)); // >=80

		System.out.println("----- subSet -----");
		print(scores.subSet(80, true, 90, false)); // 80<= <90

	}

	private static void print2(TreeSet<Integer> scores) {
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("보다 낮은 점수: " + scores.lower(95));
		System.out.println("보다 낮은 점수: " + scores.lower(94));
		System.out.println("보다 높은 점수: " + scores.higher(95));
		System.out.println("보다 같거나 높은 점수: " + scores.ceiling(95));
	}

	private static void print(Set<Integer> scores) {
		for (Integer data : scores) {
			System.out.println(data);
		}
	}
}
