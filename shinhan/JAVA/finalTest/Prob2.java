public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		// 구현하시오.....return값 수정할것
		String result = "";
		int fillCharNum = size - str.length();
		if (fillCharNum < 0) {
			try {
				throw new IllegalSizeException();
			} catch (IllegalSizeException e) {
				return "문자열의 길이보다 size가 큽니다.";
			}
		}
		result += Character.toString(fillChar).repeat(fillCharNum) + str;

		return result;
	}
}

//구현하시오.
class IllegalSizeException extends RuntimeException {

	public IllegalSizeException() {
		super();
	}
}
