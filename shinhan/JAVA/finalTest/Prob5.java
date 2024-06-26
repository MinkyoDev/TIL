public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		for (int num : answer) {

			switch (num) {
			case (1) -> counter[0]++;
			case (2) -> counter[1]++;
			case (3) -> counter[2]++;
			case (4) -> counter[3]++;
			}
		}

		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("%d의 갯수는 %d개 입니다.\n", i + 1, counter[i]);
		}

	}
}
