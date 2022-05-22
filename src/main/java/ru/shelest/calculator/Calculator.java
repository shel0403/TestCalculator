package ru.shelest.calculator;

import ru.shelest.parser.OperandType;
import ru.shelest.parser.Operation;
import ru.shelest.util.ArabicRomanNumberConverter;

public class Calculator {

    private final Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public String getCalculationResult() throws Exception {
        final int result = this.calculate();

        return operation.operationType().equals(OperandType.ARABIC) ?
                String.valueOf(result) :
                ArabicRomanNumberConverter.arabicToRoman(result);
    }

    private int calculate() {
        return operation.operator().applyAsInt(operation.operand1Value(), operation.operand2Value());
    }
}
