package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryCalculatorController {
    private Boolean isBinary = true;
    private final BinaryCalculator binaryCalculator = new BinaryCalculator();

    @FXML
    private Label resultDisplay;

    @FXML
    private Label alertDisplay;

    public void handleDigit(ActionEvent event) {
        stateReset();

        Pattern p = Pattern.compile("[+-/*]");
        Matcher m = p.matcher(resultDisplay.getText());

        if (m.matches()) {
            clearResultLabel();
        }

        if (resultDisplay.getText().length() < 64) {
            String digitValue = ((Button)event.getSource()).getText();
            resultDisplay.setText(resultDisplay.getText() + digitValue);
        }
    }

    public void handleOperator(ActionEvent event) {
        stateReset();

        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
            return;
        }

        String operator = ((Button)event.getSource()).getText();

        switch (operator) {
            case "+":
                binaryCalculator.add(resultDisplay.getText());
                resultDisplay.setText(operator);
                break;
            case "-":
                binaryCalculator.subtract(resultDisplay.getText());
                resultDisplay.setText(operator);
                break;
            case "/":
                binaryCalculator.divide(resultDisplay.getText());
                resultDisplay.setText(operator);
                break;
            case "*":
                binaryCalculator.multiply(resultDisplay.getText());
                resultDisplay.setText(operator);
                break;
            default:
                setAlert("Invalid operator");
        }
    }

    public void handleEquals() {
        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
            return;
        }

        try {
            resultDisplay.setText(binaryCalculator.calculate(resultDisplay.getText()).toString());
        } catch (ArithmeticException e) {
            setAlert("Operation not permitted: "+ e.getMessage());
        }

    }

    public void handleToggle() {
        String text = resultDisplay.getText();

        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
            return;
        }

        if (isBinary) {
            resultDisplay.setText(binaryCalculator.convertToDecimal(text));
        } else {
            resultDisplay.setText(binaryCalculator.convertToBinary(text));
        }
        isBinary = !isBinary;
    }

    public void handleSignToggle() {
        stateReset();

        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
            return;
        }

        try {
            resultDisplay.setText(binaryCalculator.toggleSign(resultDisplay.getText()));
        } catch (ArithmeticException e) {
            setAlert("Operation not permitted: " + e.getMessage());
        }

    }

    public void handleClear() {
        stateReset();
        clearResultLabel();

        binaryCalculator.clear();
    }

    public void handleSquareRoot() {
        stateReset();

        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
        } else {
            resultDisplay.setText((binaryCalculator.squareRoot(resultDisplay.getText())).toString());
        }
    }

    public void handleSquare() {
        stateReset();

        if (isEmpty()) {
            setAlert("Operation not permitted: No input");
            return;
        }

        try {
            resultDisplay.setText((binaryCalculator.square(resultDisplay.getText())).toString());
        } catch (ArithmeticException e) {
            setAlert("Operation not permitted: " + e.getMessage());
        }

    }

    public void clearResultLabel(){
        resultDisplay.setText("");
    }

    public void setAlert(String alertText) {
        alertDisplay.setText(alertText);
    }

    public void clearAlert() {
        alertDisplay.setText("");
    }

    public void preEventToggle() {
        if (!isBinary) {
            handleToggle();
        }
    }

    public void stateReset() {
        preEventToggle();
        clearAlert();
    }

    public boolean isEmpty() {
        return resultDisplay.getText().equals("");
    }

}
