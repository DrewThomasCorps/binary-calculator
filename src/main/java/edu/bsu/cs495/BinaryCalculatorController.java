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
    private Boolean isbinary = true;
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
                setAlert();
        }
    }

    public void handleEquals() {

    }

    public void handleToggle() {
        String text = resultDisplay.getText();
        if (isbinary) {
            BigInteger number = new BigInteger(text, 2);
            resultDisplay.setText(number.toString());
        } else {
            long number = new BigInteger(text, 10).longValue();
            resultDisplay.setText(Long.toBinaryString(number));
        }
        isbinary = !isbinary;
    }

    public void handleSignToggle() {
        long Num = Long.parseUnsignedLong(resultDisplay.getText(),2);
        Num = Num* -1;
        String outNum = Long.toBinaryString(Num);
        resultDisplay.setText(outNum);


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

    public void setAlert() {

    }

}
