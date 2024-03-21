package com.shinhan.day08.c11_1_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {

	public static void main(String[] args) {
		// 오류 발생시 자동으로 JVM이 Exeption 객체를 생성

//		method1(10);
//		method1(0);

		try {
			method7();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------Main end-------");
	}

	private static void method7() throws IOException, ClassNotFoundException {
		Class myBook = Class.forName("com.shinhan.day08.lombokExample.Book");

		FileReader file = new FileReader("src/com/shinhan/day08/lombokExample/Book.java2");
		int i;

		while ((i = file.read()) != -1) {
			System.out.print((char) i);
		}
		file.close();
	}

	private static void method6() {
		// try(resource) ... 자원이 자동으로 반납됨
		try (FileReader file = new FileReader("src/com/shinhan/day08/lombokExample/Book.java2")) {
			int i;
			while ((i = file.read()) != -1) {
				System.out.print((char) i);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private static void method5() {
		FileReader file = null;
		int i;

		try {
			file = new FileReader("src/com/shinhan/day08/lombokExample/Book.java2");
			while ((i = file.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				file.close(); // 자원 반납 - 열었으면 닫아야지, db 연결 후 해제
//				if (file != null) file.close();
			} catch (NullPointerException e) {
				System.out.println("close 불가");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("*********************");
	}

	private static void method4() {
		try {
			Class myBook = Class.forName("com.shinhan.day08.lombokExample.Book");
			System.out.println(myBook.getName());
			System.out.println(myBook.getPackageName());
			System.out.println(myBook.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("*****************");
	}

	private static void method3() throws IOException {
		// 2. normal Exception
		// - 컴파일시에 check
		// - 반드시 Exception 처리를 해야함
		// - 1) 내가한다. 2) 떠넘긴다(이걸 부른 곳으로)

		InputStream input = System.in;

		int data = input.read();
		System.out.println((char) data);

	}

	private static void method2() {
		// 2. normal Exception
		// - 컴파일시에 check
		// - 반드시 Exception 처리를 해야함
		// - 1) 내가한다. 2) 떠넘긴다(이걸 부른 곳으로)

		InputStream input = System.in;

		try {
			int data = input.read();
			System.out.println((char) data);
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

	}

	private static void method1(int count) {
		// 1. RuntimeException
		// - 실행시 오류 발생
		int score = 100;
		int[] arr = new int[10];
		String s = "백";

//		if (count==0) return;  // 오류 처리 로직과 비지니스 로직 처리가 섞인다. 권장하지 않음.

		try {
			System.out.println("average: " + score / count);
//			arr[10] = 99;
			System.out.println(Integer.parseInt(s) + 200);

		} catch (ArithmeticException e) {
			// Exception 처리 - 프로그램 중단 x
			System.out.println("연산 오류  " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("NullPointerException  " + e.getMessage());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException  " + e.getMessage());

//		} catch (NumberFormatException e) {
//			System.out.println("NumberFormatException  " + e.getMessage());

		} catch (Exception e) {
			System.out.println("NumberFormatException  " + e.getMessage());
			e.printStackTrace();

		} finally {
			System.out.println("오류가 있거나 없거나 실행(finally)");

		}
		System.out.println("================");

	}
}
