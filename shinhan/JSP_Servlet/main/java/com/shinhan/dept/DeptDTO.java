package com.shinhan.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//제일 먼저
//칼럼 이름 같아야 좋음
//run sql 에서 alt + 스크롤해서 우클릭해서 복사
//ctrl shift y로 소문자, ; 붙이기

//VO (Value Object)
//DTO(Data Transfer Object
//JavaBeans기술에서 이용(Jsp, String, Mybatis는 javabeans기술을 이용한다.)

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter@Setter
public class DeptDTO {
	int DEPARTMENT_ID;
	String DEPARTMENT_NAME;
	int MANAGER_ID;
	int LOCATION_ID;
}
