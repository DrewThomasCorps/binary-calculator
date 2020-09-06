package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class BinaryCalculatorController {
    private BinaryCalculator binaryCalculator = new BinaryCalculator();

    @FXML
    private Label resultDisplay;
    private String firstBinaryDigit = "";
    private String secondBinaryDigit = "";
    private String operator = "";
    private boolean isInStartState = true;


    public void handleDigit(ActionEvent event) {

        String digitValue = ((Button)event.getSource()).getText();

        if (isInStartState) {
            clearResultLabel();
            resultDisplay.setText(resultDisplay.getText() + digitValue);
            firstBinaryDigit = resultDisplay.getText();
            isInStartState = false;

        } else if (operator.isEmpty()) {

            resultDisplay.setText(resultDisplay.getText() + digitValue);
            firstBinaryDigit = resultDisplay.getText();

        } else {

            resultDisplay.setText(resultDisplay.getText() + digitValue);
            secondBinaryDigit = resultDisplay.getText();

        }

    }

    public void handleOperator(ActionEvent event) {

        if (!isInStartState && secondBinaryDigit.isEmpty()) {

            clearResultLabel();

            operator = ((Button)event.getSource()).getText();

        } else if (!secondBinaryDigit.isEmpty()) {

            System.out.println("I'm waiting for you to press = or clear");

        } else {

            System.out.println("I'm waiting for a digit");

        }
    }

    public void handleEquals() {

        System.out.println("clicked equals");
        //TODO Implement operation execution
        clearOperator();
        clearDigits();
        resetStartState();

    }

    public void handleToggle() {

        System.out.println("clicked toggle");
        //TODO Implement toggle

    }

    public void handleClear() {

        clearResultLabel();
        clearDigits();
        clearOperator();
        resetStartState();

    }

    public void handleSquareRoot() {

        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            System.out.println("clicked sqrt");
            //TODO Implement square root operation
            clearOperator();
            clearDigits();
            resetStartState();

        }

    }

    public void handleSquare() {

        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            resultDisplay.setText((binaryCalculator.square(firstBinaryDigit)).toString());

            clearOperator();
            clearDigits();
            resetStartState();

        }

    }

    public void clearResultLabel(){

        resultDisplay.setText("");

    }

    public void clearOperator() {

        operator = "";

    }

    public void clearDigits() {
        firstBinaryDigit = "";
        secondBinaryDigit = "";
    }

    public void resetStartState() {
        isInStartState = true;
    }
}
