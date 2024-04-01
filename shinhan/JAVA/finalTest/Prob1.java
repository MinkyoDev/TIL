public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		// 구현하세요.
		String maxName = new String();
		int maxScore = Integer.MIN_VALUE;

		for (String data : array) {
			String name = "";
			String score = "";

			for (char ch : data.substring(0, data.length() - 1).toCharArray()) {
				if (ch >= 48 && ch <= 57) {
					score += ch;
				} else {
					name += ch;
				}
			}

			if (Integer.parseInt(score) > maxScore) {
				maxScore = Integer.parseInt(score);
				maxName = name;
			}
		}
		System.out.printf("최고점수는 %s님 %s점 입니다.\n", maxName, maxScore);
	}
}
