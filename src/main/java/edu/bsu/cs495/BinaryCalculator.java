package edu.bsu.cs495;

import java.math.BigInteger;

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
        firstNumber = new BigInteger(binary, 2).longValue();
        double squaredValue = Math.pow(firstNumber, 2);
        if (squaredValue > Long.MAX_VALUE) {
            throw new ArithmeticException("Long overflow");
        }
        firstNumber = (long) squaredValue;
        return new StringBuilder(Long.toBinaryString(firstNumber));
    }

    public StringBuilder squareRoot(String binary) {
        firstNumber = new BigInteger(binary, 2).longValue();
        firstNumber = (long) Math.sqrt((double) firstNumber);
        return new StringBuilder(Long.toBinaryString(firstNumber));
    }

    public void add(String binary) {
        firstNumber = new BigInteger(binary, 2).longValue();
        operation = TwoNumberOperations.ADD;
    }

    public void subtract(String binary) {
        firstNumber = new BigInteger(binary, 2).longValue();
        operation = TwoNumberOperations.SUBTRACT;
    }

    public void multiply(String binary) {
        firstNumber = new BigInteger(binary, 2).longValue();
        operation = TwoNumberOperations.MULTIPLY;
    }

    public void divide(String binary) {
        firstNumber = new BigInteger(binary, 2).longValue();
        operation = TwoNumberOperations.DIVIDE;
    }

    public StringBuilder calculate(String binary) {
        if (operation == null) {
            throw new IllegalStateException("No operation was selected.");
        }
        if (firstNumber == null) {
            throw new IllegalStateException("There is not another number to operate with.");
        }
        secondNumber = new BigInteger(binary, 2).longValue();
        performCalculation();
        secondNumber = null;
        operation = null;
        return new StringBuilder(Long.toBinaryString(firstNumber));
    }

    public void clear() {
        firstNumber = null;
        secondNumber = null;
        operation = null;
    }

    public String convertToDecimal(String binary) {
        long number = Long.parseUnsignedLong(binary, 2);
        return Long.toString(number);
    }

    public String convertToBinary(String decimal) {
        long number = Long.parseLong(decimal);
        return Long.toBinaryString(number);
    }

    public String toggleSign(String binary) {
        long number = Long.parseUnsignedLong(binary,2);
        long negatedNumber = Math.negateExact(number);
        return Long.toBinaryString(negatedNumber);
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

    private void calculateAddition() throws ArithmeticException {
        firstNumber = Math.addExact(firstNumber, secondNumber);
    }

    private void calculateSubtraction() throws ArithmeticException {
        firstNumber = Math.subtractExact(firstNumber, secondNumber);
    }

    private void calculateDivision() {
        firstNumber /= secondNumber;
    }

    private void calculateMultiplication() throws ArithmeticException {
        firstNumber = Math.multiplyExact(firstNumber, secondNumber);
    }


}