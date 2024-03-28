package com.shinhan.day13.c18_1_dataStream;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String path = "./src/com/shinhan/day13/";
		File f = new File(path+"Review.java");
		System.out.println(f.exists());
		System.out.println(f.length());
		System.out.println(f.getAbsolutePath());
	}
}
