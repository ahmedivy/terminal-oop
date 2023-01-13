package com.example.terminaloop;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AverageBMIController implements Initializable {

    @FXML
    private Label averageLabel;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        averageLabel.setText(String.format("%.2f", Util.calculateAverage(BMIController.personList)));
        backButton.setOnAction((e) -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("bmi.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            stage.setTitle("BMI Calculator");
            stage.setScene(scene);
            stage.show();
        });
    }
}
