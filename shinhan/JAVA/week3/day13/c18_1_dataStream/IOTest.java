package com.shinhan.day13.c18_1_dataStream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest {

	public static void main(String[] args) throws IOException {
		f7();
	}

	private static void f7() throws IOException {
		// 파일 입력(읽기)
		String filename = "./src/com/shinhan/day13/Review.java";

		FileReader fis;
		BufferedReader br;

		FileReader fileReader = new FileReader(filename); // 2byte : 한글 가능
		br = new BufferedReader(fileReader);
		String i;
		while ((i = br.readLine()) != null) {
			System.out.println(i);
		}
		br.close();
	}

	private static void f6() throws IOException {
		// 보조 스트림 : DataOutputStream, DataInputStream -> 시험에 나옴
		String filename = "aa.txt";
		FileOutputStream fos = new FileOutputStream(filename);
		DataOutputStream dos = new DataOutputStream(fos);
		fos.write(10);
		fos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");
		fos.flush();
		fos.close();

		FileInputStream fis = new FileInputStream(filename);
		DataInputStream dis = new DataInputStream(fis);
		int a = fis.read();
		int b = fis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		System.out.println(a + b);
		System.out.println(c + d);
		fis.close();

	}

	private static void f5() throws IOException {
		// 파일 출력
		String filename = "aa.txt";
		FileWriter fw = new FileWriter(filename);

		fw.write("file_write\n");
		fw.write("file_write_end");

		// 자원을 반납하지 않으면 다른 곳에서 이 파일을 사용할 수 없다.
		fw.close();
	}

	private static void f4() {
		// 모니터 출력
		PrintStream monitor = System.out;
		monitor.println("모니터 출력");
	}

	private static void f2() throws IOException {
		// 파일 입력(읽기)
		String filename = "./src/com/shinhan/day13/Review.java";

		FileInputStream fileInputStream;
		fileInputStream = new FileInputStream(filename);

		FileReader fileReader = new FileReader(filename); // 2byte : 한글 가능

		int i;
		while ((i = fileReader.read()) != -1) {
			System.out.print((char) i);
		}
		fileInputStream.close();
	}

	private static void f1() throws IOException {
		// 키보드 입력
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is); // 보조 stream
		int i;
		while ((i = isr.read()) != 13) { // enter의 ASCII 값이 13
			System.out.println((char) i);
		}

	}
}
