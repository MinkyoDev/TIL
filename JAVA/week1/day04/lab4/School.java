package com.shinhan.week1.day04.lab4;

// Modifier
// 1. 접근지정자 : public > protected > 생략 > private
// 2. 활용방법 : static, final, abstract, synchronized

public class School {

	public static void main(String[] args) {
		Student student = new Student("홍길동", 20, 200201);
		Teacher teacher = new Teacher("이순신", 30, "JAVA");
		Employee employee = new Employee("유관순", 40, "교무과");
		
		student.print();
		teacher.print();
		employee.print();
	}
}
