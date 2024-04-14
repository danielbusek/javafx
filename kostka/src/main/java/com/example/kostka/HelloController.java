package com.example.kostka;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class HelloController {

    @FXML
    private Button button;


    @FXML
    private ImageView k6;



    @FXML
    public void initialize() {

        button.setOnAction(event -> {

            int randomNumber = new Random().nextInt(6) + 1;

            // Nastavení správného obrázku podle náhodného čísla
            String imagePath = "/dice" + randomNumber + ".jpg";
            Image image1 = new Image(getClass().getResourceAsStream("/Vystrizek_1.jpg"));
            Image image2 = new Image(getClass().getResourceAsStream("/Vystrizek_2.jpg"));
            Image image3 = new Image(getClass().getResourceAsStream("/Vystrizek_3.jpg"));
            Image image4 = new Image(getClass().getResourceAsStream("/Vystrizek_4.jpg"));
            Image image5 = new Image(getClass().getResourceAsStream("/Vystrizek_5.jpg"));
            Image image6 = new Image(getClass().getResourceAsStream("/Vystrizek_6.jpg"));

            // Nastavení správného obrázku do odpovídající ImageView
            switch (randomNumber) {
                case 1:
                    k6.setImage(image1);
                    break;
                case 2:
                    k6.setImage(image2);
                    break;
                case 3:
                    k6.setImage(image3);
                    break;
                case 4:
                    k6.setImage(image4);
                    break;
                case 5:
                    k6.setImage(image5);
                    break;
                case 6:
                    k6.setImage(image6);
                    break;
            }


        });
    }
}

