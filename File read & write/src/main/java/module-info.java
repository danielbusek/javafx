module com.example.demo_hbb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo_hbb to javafx.fxml;
    exports com.example.demo_hbb;
}