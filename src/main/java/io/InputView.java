package io;

import java.util.Scanner;

import calculator.Operator;

public class InputView {
	public static final int OPERATOR_DELIMITER = 2;
	private static final String BLANK = " ";
	public static final String NUMBER_FORMAT = "^[0-9\\+\\-]?[0-9]+$";
	public static final int FIRST_OPERATOR = 1;

	private static final Scanner sc = new Scanner(System.in);

	public static String requestInput() {
		String userInput = sc.nextLine().trim();
		validateInput(userInput);
		return userInput;
	}

	private static void validateInput(String userInput) {
		String[] inputArray = userInput.split(BLANK);
		checkFirstNumberAndLength(inputArray);
		checkPositionIsCorrect(inputArray);
		checkNullAndBlank(userInput);
	}

	private static void checkNullAndBlank(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new NullPointerException("값을 입력 해 주세요.");
		}
	}

	private static void checkPositionIsCorrect(String[] inputArray) throws IllegalArgumentException {
		for (int i = FIRST_OPERATOR; i < inputArray.length; i += OPERATOR_DELIMITER) {
			if (!Operator.isOperator(inputArray[i]) || isNotNumber(inputArray[i + 1]))
				throw new IllegalArgumentException("정확하지 않은 입력입니다.");
		}
	}

	private static void checkFirstNumberAndLength(String[] inputArray) {
		if (!isCorrectLength(inputArray.length) || isNotNumber(inputArray[0])) {
			throw new IllegalArgumentException("첫 자리는 숫자여야하며 길이가 잘 못 되었습니다.");
		}
	}

	/**
	 * 정상적인 입력의 경우 1 + 3 + 5  와 같이 식의 길이가 홀수여야 합니다.
	 * 이를 검증하는 메서드입니다.
	 *
	 * @param length
	 */
	private static boolean isCorrectLength(int length) {
		return length % 2 == 1;
	}

	private static boolean isNotNumber(String target) {
		return target.matches(NUMBER_FORMAT);
	}
}
