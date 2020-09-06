package edu.bsu.cs495;

import org.w3c.dom.ranges.RangeException;

public class BinaryCalculator {

    private Long firstNumber;
    private Long secondNumber;
    private TwoNumberOperations operation;

    private enum TwoNumberOperations {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
    }

    public StringBuilder square(String binary) {
        if (binary == null || binary.equals("")) {
            return new StringBuilder();
        }
        firstNumber = Long.parseLong(binary, 2);
        firstNumber = (long) Math.pow(firstNumber, 2);
        return new StringBuilder(Long.toBinaryString(firstNumber));
    }

    public StringBuilder squareRoot(String binary) {
        firstNumber = Long.parseLong(binary, 2);
        // TODO Implement
        return new StringBuilder(firstNumber.toString());
    }

    public void add(String binary) {
        firstNumber = Long.parseLong(binary, 2);
        operation = TwoNumberOperations.ADD;
    }

    public void subtract(String binary) {
        firstNumber = Long.parseLong(binary, 2);
        operation = TwoNumberOperations.SUBTRACT;
    }

    public void multiply(String binary) {
        firstNumber = Long.parseLong(binary, 2);
        operation = TwoNumberOperations.MULTIPLY;
    }

    public void divide(String binary) {
        firstNumber = Long.parseLong(binary, 2);
        operation = TwoNumberOperations.DIVIDE;
    }

    public StringBuilder calculate(String binary) {
        if (operation == null) {
            throw new RuntimeException("No operation was selected");
        }
        if (firstNumber == null) {
            throw new RuntimeException("The is not another number to operate with.");
        }
        secondNumber = Long.parseLong(binary, 2);
        performCalculation();
        operation = null;
        secondNumber = null;
        return new StringBuilder(firstNumber.toString());
    }

    public void clear() {
        firstNumber = null;
        secondNumber = null;
        operation = null;
    }

    public String convertToDecimal(String binary) {
        // Todo Implement
        return binary;
    }

    public StringBuilder convertToBinary(String binary) {
        // Todo Implement
        return new StringBuilder(binary);
    }

    private void performCalculation() {
        switch (operation) {
            case ADD:
                calculateAddition();
                break;
            case SUBTRACT:
                calculateSubtraction();
                break;
            case DIVIDE:
                calculateDivision();
                break;
            case MULTIPLY:
                calculateMultiplication();
                break;
        }
    }

    private void calculateAddition() throws RangeException {
        // Check for overflow and throw exception
        if ((Long.MAX_VALUE - firstNumber) < secondNumber) {
            throw new RangeException((short) 1, "Range Error: Sum is too large.");
        }
        firstNumber = firstNumber + secondNumber;
    }

    private void calculateSubtraction() {
        firstNumber -= secondNumber;
    }

    private void calculateDivision() {
        firstNumber /= secondNumber;
    }

    private void calculateMultiplication() {
        firstNumber *= secondNumber;
    }


}
