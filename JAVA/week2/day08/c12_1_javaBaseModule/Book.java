package com.shinhan.day08.c12_1_javaBaseModule;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JavaBeans 규격 : field는 private, getter/setter, default 생성자
// DTO (Data Transfer Object): data를 전송하기 위해
// VO (Value Object): 값을 저장하기 위해

//@EqualsAndHashCode(of = { "title", "author" })
//@EqualsAndHashCode(exclude = "price")
@ToString(exclude = "price")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String title;
	private int price;
	private String author;

	@Override
	public int hashCode() {
		return Objects.hash(author, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && price == other.price && Objects.equals(title, other.title);
	}

}
