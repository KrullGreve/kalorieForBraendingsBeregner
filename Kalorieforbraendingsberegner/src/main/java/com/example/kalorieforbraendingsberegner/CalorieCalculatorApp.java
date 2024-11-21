package com.example.kalorieforbraendingsberegner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalorieCalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CalorieCalculatorUI.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Kalorieberegner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}