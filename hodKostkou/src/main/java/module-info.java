module com.example.hodkostkou {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hodkostkou to javafx.fxml;
    exports com.example.hodkostkou;
}