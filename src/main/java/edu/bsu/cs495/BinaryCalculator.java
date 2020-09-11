package edu.bsu.cs495;

public class BinaryCalculator {

    private Number firstNumber;
    private Number secondNumber;
    private TwoNumberOperations operation;

    private enum TwoNumberOperations {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
    }

    public StringBuilder square(String binary) throws ArithmeticException {
        if (binary == null || binary.equals("")) {
            return new StringBuilder();
        }
        firstNumber = new Number(binary);
        double squaredValue = Math.pow(firstNumber.getValue(), 2);
        if (squaredValue > Long.MAX_VALUE) {
            throw new ArithmeticException("Long overflow");
        }
        firstNumber = new Number((long) squaredValue);
        return new StringBuilder(firstNumber.toBinaryString());
    }

    public StringBuilder squareRoot(String binary) {
        firstNumber = new Number(binary);
        if (firstNumber.getValue() < 0) {
            throw new ArithmeticException("Cannot take the square root of a negative");
        }
        firstNumber = new Number((long) Math.sqrt(firstNumber.getValue()));
        return new StringBuilder(firstNumber.toBinaryString());
    }

    public void add(String binary) {
        firstNumber = new Number(binary);
        operation = TwoNumberOperations.ADD;
    }

    public void subtract(String binary) {
        firstNumber = new Number(binary);
        operation = TwoNumberOperations.SUBTRACT;
    }

    public void multiply(String binary) {
        firstNumber = new Number(binary);
        operation = TwoNumberOperations.MULTIPLY;
    }

    public void divide(String binary) {
        firstNumber = new Number(binary);
        operation = TwoNumberOperations.DIVIDE;
    }

    public StringBuilder calculate(String binary) {
        if (operation == null) {
            throw new IllegalStateException("No operation was selected.");
        }
        if (firstNumber == null) {
            throw new IllegalStateException("There is not another number to operate with.");
        }
        secondNumber = new Number(binary);
        performCalculation();
        secondNumber = null;
        operation = null;
        return new StringBuilder(firstNumber.toBinaryString());
    }

    public void clear() {
        firstNumber = null;
        secondNumber = null;
        operation = null;
    }

    public String convertToDecimal(String binary) {
        return new Number(binary).toDecimalString();
    }

    public String convertToBinary(String decimal) {
        long number = Long.parseLong(decimal);
        return new Number(number).toBinaryString();
    }

    public String toggleSign(String binary) throws ArithmeticException {
        Number number = new Number(binary);
        Number negatedNumber = new Number(Math.negateExact(number.getValue()));
        return negatedNumber.toBinaryString();
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
        firstNumber = new Number(
                Math.addExact(firstNumber.getValue(), secondNumber.getValue())
        );
    }

    private void calculateSubtraction() throws ArithmeticException {
        firstNumber = new Number(
                Math.subtractExact(firstNumber.getValue(), secondNumber.getValue())
        );
    }

    private void calculateDivision() {
        firstNumber = new Number(
                firstNumber.getValue() / secondNumber.getValue()
        );
    }

    private void calculateMultiplication() throws ArithmeticException {
        firstNumber = new Number(
                Math.multiplyExact(firstNumber.getValue(), secondNumber.getValue())
        );
    }


}