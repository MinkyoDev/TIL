package com.shinhan.day13.c18_1_dataStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.shinhan.day12.review.Student;

public class IOTest2 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		f1();
	}
	
	private static void f1() throws IOException, ClassNotFoundException {
		Student st1 = new Student("홍길동1", 100, "남");
		Student st2 = new Student("홍길동2", 100, "남");
		
		FileOutputStream fos = new FileOutputStream("data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.close();
		
		FileInputStream fis = new FileInputStream("data.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student st3 = (Student) ois.readObject();
		Student st4 = (Student) ois.readObject();
		System.out.println(st3);
		System.out.println(st4);
	}
}
