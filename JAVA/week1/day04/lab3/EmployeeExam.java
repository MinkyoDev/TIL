package com.shinhan.week1.day04.lab3;

public class EmployeeExam {

	public static void main(String[] args) {
//		problem1();
		problem2();
	}
	
	private static void problem2() {
		Employee2[] emps = new Employee2[4];
		
		emps[0] = new Employee2("1", "이부장", 1500000);
		emps[1] = new Employee2("2", "김과장", 1300000);
		emps[2] = new Employee2("3", "최대리", 1200000);
		emps[3] = new Employee2("4", "박사원", 1000000);
		
		double salary1 = emps[0].getSalary(0.25);
		double salary2 = emps[1].getSalary(0.15);
		double salary3 = emps[2].getSalary(0.05);
		double salary4 = emps[3].getSalary(0.05);
		
		for (Employee2 emp: emps) {
			System.out.println(emp.toString());
			System.out.println(emp);  // toString은 그냥 찍어도 나옴
		}
	}
	
	private static void problem1() {
		Employee[] emps = new Employee[4];
		
		emps[0] = new Employee("부장", "이부장", 1500000);
		emps[1] = new Employee("과장", "김과장", 1300000);
		emps[2] = new Employee("대리", "최대리", 1200000);
		emps[3] = new Employee("사원", "박사원", 1000000);
		
		for (Employee emp: emps) {
			emp.print();
		}
	}
}
