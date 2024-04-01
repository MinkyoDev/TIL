package com.shinhan.day10.c13_6_wildcardParameter;

public class GenericTest {

	public static void main(String[] args) {
		Applicant<Person> applicant1 = new Applicant<>(new Person());
		Course.registerCourse1(applicant1);
//		Course.registerCourse2(applicant1);
		Course.registerCourse3(applicant1);
		Course.registerCourse4(applicant1);
		
		Applicant<Worker> applicant2 = new Applicant<>(new Worker());
		Course.registerCourse1(applicant2);
//		Course.registerCourse2(applicant2);
//		Course.registerCourse3(applicant2);
		Course.registerCourse4(applicant2);
		
		Applicant<Student> applicant3 = new Applicant<>(new Student());
		Course.registerCourse1(applicant3);
		Course.registerCourse2(applicant3);
		Course.registerCourse3(applicant3);
//		Course.registerCourse4(applicant3);
		
		Applicant<MiddleStudent> applicant4 = new Applicant<>(new MiddleStudent());
		Course.registerCourse1(applicant4);
		Course.registerCourse2(applicant4);
//		Course.registerCourse3(applicant4);
//		Course.registerCourse4(applicant4);
		
	}
}
