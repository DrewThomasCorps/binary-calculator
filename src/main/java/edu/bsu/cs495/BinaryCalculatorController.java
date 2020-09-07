package edu.bsu.cs495;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class BinaryCalculatorController {
    private final BinaryCalculator binaryCalculator = new BinaryCalculator();

    @FXML
    private Label resultDisplay;

    @FXML
    private Label alertDisplay;

    public void handleDigit(ActionEvent event) {

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
                break;
            case "-":
                binaryCalculator.subtract(resultDisplay.getText());
                break;
            case "/":
                binaryCalculator.divide(resultDisplay.getText());
                break;
            case "*":
                binaryCalculator.multiply(resultDisplay.getText());
                break;
            default:
                setAlert();
        }
    }

    public void handleEquals() {

    }

    public void handleToggle() {

    }

    public void handleSignToggle() {

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
