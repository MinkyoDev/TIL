package com.shinhan.day09.c12_1_objectClass;

import java.util.Objects;

// class : 틀(template)
// object : 실체, instance

// VO(Value Object) : data 저장(여러개의 field의 묶음)
// DTO(Date Transfer Object) : data 전송이 목적

// JavaBeans : default 생성자가 반드시 필요
public class ComputerVO {

	// field - data 저장
	String model;
	int price;
	String company;

	// constructor
	public ComputerVO() {
	}

	public ComputerVO(String model, int price, String company) {
		super();
		this.model = model;
		this.price = price;
		this.company = company;
	}

	// getter-setter
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=").append(model).append(", price=").append(price).append(", company=")
				.append(company).append("]");
		return builder.toString();
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(company, model, price);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}

}
