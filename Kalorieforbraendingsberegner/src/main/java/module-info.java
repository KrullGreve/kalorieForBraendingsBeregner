module com.example.kalorieforbraendingsberegner {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalorieforbraendingsberegner to javafx.fxml;
    exports com.example.kalorieforbraendingsberegner;
}