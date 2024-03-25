package com.shinhan.day10.c13_4_genericMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Box<T> {

	private T content;

//	public T getContent() {
//		return content;
//	}
//
//	public void setContent(T content) {
//		this.content = content;
//	}

}
