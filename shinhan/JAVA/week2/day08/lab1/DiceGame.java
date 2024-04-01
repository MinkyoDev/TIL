package com.shinhan.day08.lab1;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {

	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은눈이 나온 횟수 : " + result2);
	}

	int countSameEye(int n) {
		Dice dice1 = new Dice(8);
		Dice dice2 = new Dice(8);
		int cnt = 0;

		try {
			if (n < 0) {
				throw new IllegalArgumentException("던지는 횟수가 음수가 나올 수 없음");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return 0;
		}

		for (int i = 0; i < n; i++) {
			if (dice1.play() == dice2.play()) {
				cnt++;
			}
		}

		return cnt;
	}
}							