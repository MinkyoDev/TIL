package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.IOException;

// 정의는 있고 구현은 없다.
interface MyInterface {

	public abstract void method1();

	void method2() throws FileNotFoundException;

	void method3() throws Exception;
}

// 구현 class
class MyClassImpl implements MyInterface {

	// 부모에 throws Exception이 존재하지 않은 경우 - RuntimeException은 가능
	@Override
//	public void method1() throws Exception{
	public void method1() throws RuntimeException {
		System.out.println("method1");
	}

	@Override
	// 상위 Exception으로 바꿀 수는 없음
//	public void method2() throws IOException {
	// throws 없어도 됨
	public void method2() {
		System.out.println("method2");
	}

	@Override
	// 하위 Exception은 괜찮음
	public void method3() throws ClassNotFoundException {
		System.out.println("method3");
	}

}

public class Review {

	// field
	MyInterface var1 = new MyClassImpl();
	

	public static void main(String[] args) {
		MyInterface var2 = new MyClassImpl();
		call(new MyClassImpl());
		
		MyInterface var4 = new MyInterface() {
			public void method1() {}
			public void method2() {}
			public void method3() {}
		};
		
		call(new MyInterface() {
			public void method1() {}
			public void method2() {}
			public void method3() {}
		});
	}

	private static void call(MyInterface var3) {

	}
}
