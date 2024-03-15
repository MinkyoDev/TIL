package com.shinhan.day04.lab3;

public class Employee {

	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String title, String name, int baseSalary) {
		super();
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		computeTotalSalary();
	}

	public void computeTotalSalary() {
		if (title.equals("부장")) {
			totalSalary = baseSalary + baseSalary * 25 / 100;
		} else if (title.equals("“과장”")) {
			totalSalary = baseSalary + baseSalary * 15 / 100;
		} else {
			totalSalary = baseSalary + baseSalary * 5 / 100;
		}
	}
	
	public void print() {
		System.out.printf("%s 직급의 %s씨의 본봉은 %s 원이고 총급여는 %s 원입니다.\n", title, name, baseSalary, totalSalary);
	}

}
