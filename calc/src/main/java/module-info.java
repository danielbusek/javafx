module com.example.calc {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports main;
}