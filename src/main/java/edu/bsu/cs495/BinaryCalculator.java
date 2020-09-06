package edu.bsu.cs495;

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

    }

    public void multiply(String binary) {

    }

    public void divide(String binary) {

    }

    public StringBuilder calculate(String binary) {
        if (operation == null) {
            throw new IllegalStateException("No operation was selected.");
        }
        if (firstNumber == null) {
            throw new IllegalStateException("There is not another number to operate with.");
        }
        secondNumber = Long.parseLong(binary, 2);
        performCalculation();
        operation = null;
        secondNumber = null;
        return new StringBuilder(Long.toBinaryString(firstNumber));
    }

    public String convertToDecimal(String binary) {
        // Todo Implement
        return binary;
    }

    public StringBuilder convertToBinary(String binary) {
        // Todo Implement
        return new StringBuilder(binary);
    }

    public void clear() {
        firstNumber = null;
        secondNumber = null;
        operation = null;
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

    private void calculateAddition() {
        // Todo Check for overflow and throw exception
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
