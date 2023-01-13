package com.example.terminaloop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BMIController implements Initializable {
    @FXML
    private Label ageLabel;
    @FXML
    private Label bmiLabel;
    @FXML
    private Button calculateButton;
    @FXML
    private DatePicker dobField;
    @FXML
    private RadioButton femaleGroup;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label genderLabel;
    @FXML
    private Slider heightSlider;
    @FXML
    private Label index;
    @FXML
    private RadioButton maleGroup;
    @FXML
    private TextField unitField;
    @FXML
    private TextField weightField;
    public static List<Person> personList = new ArrayList<Person>();
    @FXML
    private Button averageButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bmiLabel.setVisible(false);
        ageLabel.setVisible(false);
        genderLabel.setVisible(false);
        index.setVisible(false);

        calculateButton.setOnAction((e) -> {

            if (!isValidated()) return;

            Person person;

            if (maleGroup.isSelected()) {
                person = new Male(Double.parseDouble(weightField.getText()), heightSlider.getValue(), dobField.getValue());
            } else {
                person = new Female(Double.parseDouble(weightField.getText()), heightSlider.getValue(), dobField.getValue());
            }

            personList.add(person);
            bmiLabel.setText(String.format("BMI : %.2f", person.calculateBMI()));
            bmiLabel.setVisible(true);

            genderLabel.setText("Gender: " + (maleGroup.isSelected() ? "Male" : "Female"));
            genderLabel.setVisible(true);

            ageLabel.setText(String.format("Age: %s years", person.getAge()));
            ageLabel.setVisible(true);

            index.setText(String.format("Healthiness Index: %s", (
                    person.isHealthy() ? "Healthy" : "Not Healthy"
                    )));
            index.setVisible(true);
        });

        averageButton.setOnAction((e) -> {

            // Changing scene
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("averageBMI.fxml"));
            Stage stage = (Stage) averageButton.getScene().getWindow();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            stage.setTitle("Average BMI");
            stage.setScene(scene);
            stage.show();
        });
    }

    public boolean isValidated() {
        try {
            Double.parseDouble(weightField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
