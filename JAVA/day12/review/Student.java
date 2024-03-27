package com.shinhan.day12.review;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	private String gender;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public Student(String name, int score, String gender) {
		this.name = name;
		this.score = score;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
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
		return Objects.equals(name, other.name) && score == other.score;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append(", gender=")
				.append(gender).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student o) {
		// score asc, name desc
		if (score == o.score)
			return o.name.compareTo(name);
		return this.score - o.score;
	}

}