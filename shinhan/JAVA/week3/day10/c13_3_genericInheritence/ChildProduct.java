package com.shinhan.day10.c13_3_genericInheritence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 상속
//@ToString
@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class ChildProduct<K, V, P> extends Product<K, V> {

	P price;

	public ChildProduct(K kind, V model, P price) {
		super(kind, model);
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("ChildProduct [price=").append(price).append(", toString()=").append(super.toString())
//				.append("]");
		builder.append("model: ").append(getModel()).append(", kind: ").append(getKind()).append(", price: ").append(price);
		return builder.toString();
	}

}
