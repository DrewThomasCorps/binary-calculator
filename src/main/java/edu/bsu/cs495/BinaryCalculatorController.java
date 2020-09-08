package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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

    }

    public void handleToggle() {
        String text = resultDisplay.getText();
        if (isBinary) {
            long number = Long.parseUnsignedLong(text, 2);
            resultDisplay.setText(Long.toString(number));
        } else {
            long number = Long.parseLong(text);
            resultDisplay.setText(Long.toBinaryString(number));
        }
        isBinary = !isBinary;
    }

    public void handleSignToggle() {
        long inputNumber = Long.parseUnsignedLong(resultDisplay.getText(),2);
        inputNumber = inputNumber* -1;
        String outputNumber = Long.toBinaryString(inputNumber);
        resultDisplay.setText(outputNumber);
    }

    public void handleClear() {
        clearResultLabel();
        binaryCalculator.clear();
    }

    public void handleSquareRoot() {
        resultDisplay.setText((binaryCalculator.squareRoot(resultDisplay.getText())).toString());
    }

    public void handleSquare() {
        resultDisplay.setText((binaryCalculator.square(resultDisplay.getText())).toString());
    }

    public void clearResultLabel(){
        resultDisplay.setText("");
    }

    public void setAlert(String alertText) {
        alertDisplay.setText(alertText);
    }

}
