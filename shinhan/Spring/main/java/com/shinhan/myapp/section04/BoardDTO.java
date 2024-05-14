package com.shinhan.myapp.section04;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class BoardDTO {
	int bno;
	String title;
	String content;
	String writer;
	String pic;
	Date create_date;
}
