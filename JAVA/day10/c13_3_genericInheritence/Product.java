package com.shinhan.day10.c13_3_genericInheritence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO (Data Transfer Object)
// VO (Value Object)
// JavaBeans (JspServlet, Spring, Mybatis) : NoArgsConstructor, getter, setter 반드시 필요
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product<K,V> {

	private K kind;
	private V model;
	
	
}
