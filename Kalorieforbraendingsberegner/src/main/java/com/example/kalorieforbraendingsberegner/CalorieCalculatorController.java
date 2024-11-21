package com.example.kalorieforbraendingsberegner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;

public class CalorieCalculatorController {

    @FXML
    private ComboBox<String> activityComboBox;
    @FXML
    private TextField weightField;
    @FXML
    private TextField timeField;
    @FXML
    private TextArea resultArea;
    @FXML
    private Button calculateButton;

    // MET værdier for aktiviteter
    private final HashMap<String, Double> activityMETs = new HashMap<>();

    @FXML
    public void initialize() {
        // Initialiser aktiviteter og deres MET-værdier
        activityMETs.put("Løb, roligt (9,5 km/t)", 9.8);
        activityMETs.put("Cykling, moderat", 7.5);
        activityMETs.put("Svømning, freestyle", 8.0);
        activityMETs.put("Gang, rask tempo", 3.8);
        activityMETs.put("Yoga, afslappende", 2.5);

        activityComboBox.getItems().addAll(activityMETs.keySet());

        calculateButton.setOnAction(e -> calculateCalories());
    }

    private void calculateCalories() {
        try {
            // Hent inputværdier
            String activity = activityComboBox.getValue();
            double weight = Double.parseDouble(weightField.getText());
            double timeMinutes = Double.parseDouble(timeField.getText());

            if (activity == null) {
                resultArea.setText("Vælg venligst en aktivitet.");
                return;
            }

            if (weight <= 0 || timeMinutes <= 0) {
                resultArea.setText("Vægt og tid skal være større end nul.");
                return;
            }

            // Beregn kalorier
            double MET = activityMETs.get(activity);
            double timeHours = timeMinutes / 60.0;
            double calories = MET * weight * timeHours;

            // Vis resultat
            resultArea.setText(String.format("Ved at udføre '%s' i %.1f minutter forbrænder du ca. %.2f kalorier.",
                    activity, timeMinutes, calories));
        } catch (NumberFormatException e) {
            resultArea.setText("Indtast gyldige numeriske værdier for vægt og tid.");
        }
    }
}