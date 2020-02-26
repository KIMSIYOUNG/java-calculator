package calculator;

import io.InputView;
import io.OutputView;

public class CalculatorController {
	public void run() {
		OutputView.welcome();
		TextCalculator textCalculator = new TextCalculator();
		String input = InputView.requestInput();
		double result = textCalculator.run(input);
		OutputView.result(result);
	}
}
