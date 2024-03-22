package com.shinhan.day09.c12_1_objectClass;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


//@ToString
//@EqualsAndHashCode
//@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComputerVO3 {

	@NonNull
	String model;
	int price;
	String company;

}
