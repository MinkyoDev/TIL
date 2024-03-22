package com.shinhan.day09.c12_7_resourcePath;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourcePathTest {

	public static void main(String[] args) throws IOException {
		f2();

	}

	private static void f2() throws IOException {
		Class<?> cls = ResourcePathTest.class;
		InputStream fis = cls.getResourceAsStream("oracle.properties");
		int i;
		while ((i = fis.read()) != -1) {
			System.out.println(((char) i));
		}		
	}

	private static void f1() throws IOException {
//		new FileReader("src/com/shinhan/day09/c12_1_objectClass/ComputerVO.java");
		Class<?> cls = ResourcePathTest.class;
		URL url = cls.getResource("test.png");

		System.out.println(url.getPath());

		InputStream fis = cls.getResourceAsStream("test.png");
		int i;
		while ((i = fis.read()) != -1) {
			System.out.println(((char) i));
		}
	}
}
