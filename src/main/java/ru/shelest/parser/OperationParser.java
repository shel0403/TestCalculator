package ru.shelest.parser;

import ru.shelest.util.ArabicRomanNumberConverter;

import java.util.function.IntBinaryOperator;

import static ru.shelest.util.Checker.require;

public class OperationParser {

    private static final String ROMAN_NUMBER_PATTERN = "(X|IX|IV|V?I{0,3})";
    private static final String ARABIC_NUMBER_PATTERN = "([1-9]0?)";

    public static Operation parse(String input) throws Exception {
        require(input != null, Exception::new);

        final String[] tokens = input.trim().split("\\s+");

        if (tokens.length != 3) {
            throw new Exception();
        }

        final Operand operand1 = toOperand(tokens[0]);
        final Operand operand2 = toOperand(tokens[2]);

        if (!operand1.operandType().equals(operand2.operandType())) {
            throw new Exception();
        }

        final IntBinaryOperator operator = toOperator(tokens[1]);

        return new Operation(operand1, operand2, operator);
    }

    private static IntBinaryOperator toOperator(String token) throws Exception {
        require(token != null, Exception::new);

        return switch (token) {
            case "+" -> Integer::sum;
            case "-" -> (a, b) -> a - b;
            case "*" -> (a, b) -> a * b;
            case "/" -> (a, b) -> a / b;
            default -> throw new Exception();
        };
    }

    private static Operand toOperand(String token) throws Exception {
        require(token != null, Exception::new);

        if (token.matches(ARABIC_NUMBER_PATTERN)) {
            return new Operand(Integer.parseInt(token), OperandType.ARABIC);
        }

        if (token.matches(ROMAN_NUMBER_PATTERN)) {
            return new Operand(ArabicRomanNumberConverter.romanToArabic(token), OperandType.ROMAN);
        }

        throw new Exception();
    }
}
