package com.shinhan.myapp.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter@Setter
public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
