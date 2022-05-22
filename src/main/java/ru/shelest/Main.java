package ru.shelest;

import ru.shelest.calculator.Calculator;
import ru.shelest.parser.Operation;
import ru.shelest.parser.OperationParser;

public class Main {

    public static String calc(String input) throws Exception {
        final Operation operation = OperationParser.parse(input);
        final Calculator calculator = new Calculator(operation);

        return calculator.getCalculationResult();
    }
}
