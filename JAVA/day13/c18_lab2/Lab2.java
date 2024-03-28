package com.shinhan.day13.c18_lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab2 {

	public static void printScore(String fileName) {
		try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
			String line;
			
			print(Arrays.stream(bfr.readLine().split("/")).toList(), "총점");
			while ((line = bfr.readLine()) != null) {
				List<String> list = new ArrayList<>(Arrays.asList(line.split("/")));
				int sum = list.subList(1,list.size()).stream().mapToInt(s->Integer.parseInt(s)).sum();
				print(list, String.valueOf(sum));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void print(List<String> list, String add) {
		System.out.printf("%4s %4s %4s %4s %4s\n", list.get(0), list.get(1), list.get(2), list.get(3), add);
	}

	public static void main(String[] args) {
		String fstFileName = "./src/com/shinhan/day13/c18_lab2/data.txt";

		printScore(fstFileName);
	}
}
