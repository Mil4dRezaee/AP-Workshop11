package com.example.workshop11;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class CalculatorController {
    @FXML
    private TextField display;

    private double firstOperand = 0;
    private double secondOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    public void initialize() {
        display.setText("0");
        display.requestFocus();
    }

    @FXML
    public void handleButtonAction(javafx.event.ActionEvent event) {
        String buttonText = ((javafx.scene.control.Button) event.getSource()).getText();
        processInput(buttonText);
    }

    @FXML
    public void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            processInput("C");
            return;
        }
        if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.EQUALS) {
            processInput("=");
            return;
        }

        String key = event.getText();
        if (key.matches("[0-9]")) {
            processInput(key);
        } else if (key.equals("+")) {
            processInput("+");
        } else if (key.equals("-")) {
            processInput("-");
        } else if (key.equals("*")) {
            processInput("*");
        } else if (key.equals("/")) {
            processInput("/");
        }
    }

    private void processInput(String input) {
        switch (input) {
            case "C":
                display.setText("0");
                firstOperand = 0;
                secondOperand = 0;
                operator = "";
                startNewNumber = true;
                break;

            case "=":
                calculateResult();
                break;

            case "+": case "-": case "*": case "/":
                setOperator(input);
                break;

            default:
                appendNumber(input);
                break;
        }
    }

    private void appendNumber(String number) {
        if (startNewNumber) {
            display.setText(number);
            startNewNumber = false;
        } else {
            String currentText = display.getText();
            if (currentText.equals("0")) {
                display.setText(number);
            } else {
                display.appendText(number);
            }
        }
    }

    private void setOperator(String op) {
        try {
            firstOperand = Double.parseDouble(display.getText());
            operator = op;
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    private void calculateResult() {
        try {
            if (operator.isEmpty()) return;

            secondOperand = Double.parseDouble(display.getText());
            double result;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
                default:
                    return;
            }

            String formattedResult = formatResult(result);
            display.setText(formattedResult);
            firstOperand = result;
            operator = "";
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        }
        return String.format("%.8g", result);
    }
}