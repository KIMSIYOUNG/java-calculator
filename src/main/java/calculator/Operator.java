package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    public static final String OPERATOR_PATTERN = "^[\\+\\-\\*\\/]$";
    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static boolean isOperator(String userInput) {
        return userInput.matches(OPERATOR_PATTERN);
    }

    public double calculate(double left, double right) {
        return expression.apply(left, right);
    }
}
