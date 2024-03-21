package com.shinhan.day08.lab3;

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	/* 조건1 */
	@Override
	public String toString() {
		return String.valueOf(first + second);
	}

	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySum other = (MySum) obj;
		return this.toString().equals(other.toString());
	}

}

public class OverridingTest {
	public static void main(String args[]) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s1 = new String("30");

		System.out.println(ms1);
		System.out.println(ms2);

		if (ms1.equals(ms2)) {
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		} else {
			System.out.println("ms1과 ms2의 값은 동일하지 않습니다.");
		}

		if (ms1.equals(s1)) {
			System.out.println("ms1과 s1의 합계는 동일합니다.");
		} else {
			System.out.println("ms1과 s1의 값은 동일하지 않습니다.");

		}
	}
}