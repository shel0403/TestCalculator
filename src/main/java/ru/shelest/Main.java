package ru.shelest;

import ru.shelest.calculator.Calculator;
import ru.shelest.parser.Operation;
import ru.shelest.parser.OperationParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(calc(scanner.nextLine()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception {
        final Operation operation = OperationParser.parse(input);
        final Calculator calculator = new Calculator(operation);

        return calculator.getCalculationResult();
    }
}
