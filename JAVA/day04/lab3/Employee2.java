package com.shinhan.day04.lab3;

public class Employee2 {

	private String id;
	private String name;
	private int baseSalary;

	public Employee2(String id, String name, int baseSalary) {
		super();
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getSalary(double bonus) {
		return baseSalary + baseSalary * bonus;
	}
	
	// 부모가 물려준 함수를 재정의 : Override
	// 이름이 같고 매개변수가 같고 return이 같고 접근제한자가 같거나 더 넓어져야한다.
	@Override
	public String toString() {
		return String.format("%s(%s) 사원의 기본급은 %d원 입니다.", name, id, baseSalary);
	}

}
