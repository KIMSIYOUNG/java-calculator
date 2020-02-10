package calculator;

import io.OutputView;

public class Application {
    public static void main(String[] args) {
        while (run());
    }

    private static boolean run() {
        try {
            OutputView.welcome();
            CalculatorController model = new CalculatorController();
            model.runCalculator();
            return false;
        } catch (Exception e) {
            OutputView.inputError(e);
            return true;
        }
    }
}
