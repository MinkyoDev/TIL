package com.shinhan.day08.c10_1_libray;

import org.json.JSONObject;

import com.firstzone.pack1.Book;
import com.firstzone.pack2.Car;

public class ExternalLIBTest {

	public static void main(String[] args) {
		Book b = new Book("java", 5000, "신용권");
		System.out.println(b);
		
		Car c = new Car("ABC", 2000);
		System.out.println(c);
		
		// json : javascript object notation
		String json = """
				{
					"name": "홍길동",
					"age": 20
				}
				""";
		JSONObject obj = new JSONObject(json);
		System.out.println(obj.get("name"));
		System.out.println(obj.get("age"));
	}
}
