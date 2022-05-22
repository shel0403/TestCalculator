package ru.shelest.parser;

import java.util.function.IntBinaryOperator;

public record Operation(Operand operand1, Operand operand2, IntBinaryOperator operator) {

    public int operand1Value() {
        return operand1.value();
    }

    public int operand2Value() {
        return operand2.value();
    }

    public OperandType operationType() {
        return operand1.operandType();
    }
}
