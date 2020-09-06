package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class BinaryCalculatorController {

    @FXML
    private Label resultDisplay;
    private String firstBinaryDigit = "";
    private String secondBinaryDigit = "";
    private String operator = "";
    private boolean isInStartState = true;


    public void handleDigit(ActionEvent event) {

        String digitValue = ((Button)event.getSource()).getText();

        if (isInStartState) {
            resultDisplay.setText("");
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

        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            clearResultLabel();

            operator = ((Button)event.getSource()).getText();

        } else if (!secondBinaryDigit.isEmpty()) {

            System.out.println("I'm waiting for you to press = or clear");

        } else {

            System.out.println("I'm waiting for a digit");

        }

        //TODO Decide how to handle an operator if equals has been pressed already. Reset state?
        // Add to the currently displayed number?
    }

    public void handleEquals() {

        System.out.println("clicked equals");
        clearOperator();
        clearDigits();
        resetStartState();

    }

    public void handleToggle() {

        System.out.println("clicked toggle");

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

        }

    }

    public void handleSquare() {

        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            System.out.println("clicked square");
            operator = "**";

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
