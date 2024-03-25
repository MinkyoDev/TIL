package com.shinhan.day08.lombokExample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JavaBeans 규격 : field는 private, getter/setter, default 생성자
// DTO (Data Transfer Object): data를 전송하기 위해
// VO (Value Object): 값을 저장하기 위해

@ToString(exclude = "price")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String title;
	private int price;
	private String author;

}
