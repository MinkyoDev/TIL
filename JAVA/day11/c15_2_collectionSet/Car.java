package com.shinhan.day11.c15_2_collectionSet;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable<Car> {
	String model;
	int price;

	@Override
	public int compareTo(Car o) {
		// 가격순 asc, model desc
		if (price - o.price == 0)
			return o.model.compareTo(model);
		return price - o.price;
	}
}