package calculator;

public class TextCalculator {
	private static final int STANDARD_NUMBER = 0;
	public static final String BLANK = " ";
	public static final int OPERATOR_INDEX = 1;
	public static final int OPERATOR_DELIMITER = 2;

	public double run(String input) {
		return calculate(split(input));
	}

	private double calculate(String[] inputs) {
		double result = Double.parseDouble(inputs[STANDARD_NUMBER]);
		for (int i = OPERATOR_INDEX; i < inputs.length; i += OPERATOR_DELIMITER) {
			Operator operator = Operator.of(inputs[i]);
			double right = Double.parseDouble(inputs[i + 1]);
			result = operator.calculate(result, right);
		}
		return result;
	}

	public String[] split(String target) {
		return target.split(BLANK);
	}
}
