package com.shinhan.day09.c12_problem;

import java.util.HashSet;
import java.util.Objects;

import lombok.NoArgsConstructor;

class Student {
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentNum, other.studentNum);
	}
	
}


@NoArgsConstructor
class StudentVO {
	String studentNum;
}

record StudentRecord(String studentNum) {
	
}

public class Problem05 {
	public static void main(String[] args) {
		// Student를 저장하는 HashSet 생성
		HashSet<Student> hashSet = new HashSet<Student>();

		// Student 저장
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1")); // 같은 학번이므로 중복 저장이 안됨
		hashSet.add(new Student("2"));

		// 저장된 Student 수 출력
		System.out.println("저장된 Student 수: " + hashSet.size());
		
		
		HashSet<StudentRecord> hashSet2 = new HashSet<StudentRecord>();
		
		// Student 저장
		hashSet2.add(new StudentRecord("1"));
		hashSet2.add(new StudentRecord("1")); // 같은 학번이므로 중복 저장이 안됨
		hashSet2.add(new StudentRecord("2"));
		
		// 저장된 Student 수 출력
		System.out.println("저장된 Student 수: " + hashSet2.size());
	}
}
