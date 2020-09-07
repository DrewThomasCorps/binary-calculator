package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class BinaryCalculatorController {
    private final BinaryCalculator binaryCalculator = new BinaryCalculator();

    @FXML
    private Label resultDisplay;
    private String firstBinaryDigit = "";
    private String secondBinaryDigit = "";
    private String operator = "";
    private boolean isInStartState = true;


    public void handleDigit(ActionEvent event) {

        if (resultDisplay.getText().length() < 64) {
            String digitValue = ((Button)event.getSource()).getText();
            resultDisplay.setText(resultDisplay.getText() + digitValue);
            isInStartState = false;
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
        binaryCalculator.calculate(firstBinaryDigit);
        clearOperator();
        clearDigits();
        resetStartState();

    }

    public void handleToggle() {

        System.out.println("clicked toggle");
        //TODO Implement toggle

    }

    public void handleSignToggle() {

    }

    public void handleClear() {

        clearResultLabel();
        clearDigits();
        clearOperator();
        resetStartState();
        binaryCalculator.clear();

    }

    public void handleSquareRoot() {

        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            System.out.println("clicked sqrt");
            binaryCalculator.squareRoot(firstBinaryDigit);
            //TODO Implement square root operation
            clearOperator();
            clearDigits();
            resetStartState();

        }

    }

    public void handleSquare() {
        /*
        if (operator.isEmpty() && !firstBinaryDigit.isEmpty()) {

            resultDisplay.setText((binaryCalculator.square(firstBinaryDigit)).toString());

            clearOperator();
            clearDigits();
            resetStartState();

        }
        */
        resultDisplay.setText((binaryCalculator.square(resultDisplay.getText())).toString());
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
