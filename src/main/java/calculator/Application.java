package calculator;

import io.OutputView;

public class Application {
	public static void main(String[] args) {
		try {
			new CalculatorController().run();
		} catch (Exception e) {
			OutputView.printException(e.getMessage());
		}
	}
}
