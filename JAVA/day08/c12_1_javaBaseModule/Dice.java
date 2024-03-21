package com.shinhan.day08.c12_1_javaBaseModule;

public class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Dice)) return false;
		
		Dice d = (Dice)obj;
		if(size == d.size) return true;
		
		return false;
	}

}