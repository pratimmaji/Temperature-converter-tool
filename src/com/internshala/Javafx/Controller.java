package com.internshala.Javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> chBox;
    @FXML
    public TextField textField;
    @FXML
    public Button btn;

private static final String CTOF = "Celsius to Fahrenheit";
private static final String FTOC = "Fahrenheit to celsius";

private boolean isCTOF = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        chBox.getItems().add(CTOF);
        chBox.getItems().add(FTOC);
        chBox.setValue(CTOF);

        chBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->

        {

            if (newValue.equals(CTOF)){
                isCTOF = true;
            }else {
                isCTOF = false;
            }

        });

        btn.setOnAction(event -> {
           convert();

        });

    }

    private void convert(){

        String input = textField.getText();

        float enteredTemperature = 0.0f;
        try {
            enteredTemperature = Float.parseFloat(input);
        }catch (Exception exception){
            warnUser();
            return;
        }


        float newTemperature = 0.0f;
        if (isCTOF){
            newTemperature = (enteredTemperature * 9 / 5) + 32;
        }else{
            newTemperature = (enteredTemperature - 32) * 5/9;
        }

        display(newTemperature);

    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isCTOF? " F" : " C";
        System.out.println("The New Temperature is :" + newTemperature + unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The New Temperature Is : " + newTemperature + unit);
                alert.show();
    }

}
