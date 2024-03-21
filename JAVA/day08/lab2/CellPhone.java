package com.shinhan.day08.lab2;

import java.util.Objects;

public class CellPhone {

	String model;
	double battery;

	public CellPhone(String model) {
		super();
		this.model = model;
	}

	void call(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("통화시간 입력 오류");
		}
		System.out.printf("통화 시간 : %d분\n", time);

		battery -= time * 0.5;
		if (battery < 0) {
			battery = 0;
		}
	}

	void charge(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("충전시간 입력 오류");
		}
		System.out.printf("통화 시간 : %d분\n", time);

		battery += time * 3;
		if (battery > 100) {
			battery = 100;
		}
	}

	void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}

	@Override
	public int hashCode() {
		return Objects.hash(model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		return Objects.equals(model, other.model);
	}

}
