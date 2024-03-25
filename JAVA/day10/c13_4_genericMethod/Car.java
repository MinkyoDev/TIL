package com.shinhan.day10.c13_4_genericMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable<Car> {

	String model;
	int price;
	String color;

	public void run() {
		System.out.println("자동차가 달립니다.");
	}

	@Override
	public int compareTo(Car o) {
		return price - o.price;
	}

}
