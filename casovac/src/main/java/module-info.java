module com.example.casovac {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.casovac to javafx.fxml;
    exports com.example.casovac;
}