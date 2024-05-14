package com.shinhan.myapp.section02;

import java.util.List;
import java.util.Properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class PeopleVO {

	String name;
	String phone;
	CarVO car;
	List<License> licenseList;
	List<String> major;
	Properties myProperties;
}
