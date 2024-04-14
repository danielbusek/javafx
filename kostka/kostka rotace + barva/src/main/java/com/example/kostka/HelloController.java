package com.example.kostka;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private Rectangle kostka;

    @FXML
    private Slider slider;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    public void initialize() {
        kostka.setFill(Color.BLUE);


        colorPicker.setOnAction(event -> kostka.setFill(colorPicker.getValue()));


        slider.setMin(0);
        slider.setMax(360);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            kostka.setRotate(newValue.doubleValue());
        });
    }
}
