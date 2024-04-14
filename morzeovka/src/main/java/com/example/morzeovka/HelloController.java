package com.example.morzeovka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField input;

    @FXML
    private TextArea output;


    @FXML
    void button(ActionEvent event) {
        String text = input.getText();
        String morseovka = "";
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'a':
                case 'A':
                    morseovka += ".- ";
                    System.out.println("Přidáno: .-");
                    break;
                case 'b':
                case 'B':
                    morseovka += "-... ";
                    System.out.println("Přidáno: -...");
                    break;
                case 'c':
                case 'C':
                    morseovka += "-.-. ";
                    System.out.println("Přidáno: -.-.");
                    break;
                case 'd':
                case 'D':
                    morseovka += "-.. ";
                    System.out.println("Přidáno: -..");
                    break;
                case 'e':
                case 'E':
                    morseovka += ". ";
                    System.out.println("Přidáno: .");
                    break;
                case 'f':
                case 'F':
                    morseovka += "..-.";
                    System.out.println("Přidáno: ..-.");
                    break;
                case 'g':
                case 'G':
                    morseovka += "--. ";
                    System.out.println("Přidáno: --.");
                    break;
                case 'h':
                case 'H':
                    morseovka += ".... ";
                    System.out.println("Přidáno: ....");
                    break;
                case 'i':
                case 'I':
                    morseovka += ".. ";
                    System.out.println("Přidáno: ..");
                    break;
                case 'j':
                case 'J':
                    morseovka += ".--- ";
                    System.out.println("Přidáno: .---");
                    break;
                case 'k':
                case 'K':
                    morseovka += "-.- ";
                    System.out.println("Přidáno: -.-");
                    break;
                case 'l':
                case 'L':
                    morseovka += ".-.. ";
                    System.out.println("Přidáno: .-..");
                    break;
                case 'm':
                case 'M':
                    morseovka += "-- ";
                    System.out.println("Přidáno: --");
                    break;
                case 'n':
                case 'N':
                    morseovka += "-. ";
                    System.out.println("Přidáno: -.");
                    break;
                case 'o':
                case 'O':
                    morseovka += "--- ";
                    System.out.println("Přidáno: ---");
                    break;
                case 'p':
                case 'P':
                    morseovka += ".--. ";
                    System.out.println("Přidáno: .--.");
                    break;
                case 'q':
                case 'Q':
                    morseovka += "--.- ";
                    System.out.println("Přidáno: --.-");
                    break;
                case 'r':
                case 'R':
                    morseovka += ".-. ";
                    System.out.println("Přidáno: .-.");
                    break;
                case 's':
                case 'S':
                    morseovka += "... ";
                    System.out.println("Přidáno: ...");
                    break;
                case 't':
                case 'T':
                    morseovka += "- ";
                    System.out.println("Přidáno: -");
                    break;
                case 'u':
                case 'U':
                    morseovka += "..- ";
                    System.out.println("Přidáno: ..-");
                    break;
                case 'v':
                case 'V':
                    morseovka += "...- ";
                    System.out.println("Přidáno: ...-");
                    break;
                case 'w':
                case 'W':
                    morseovka += ".-- ";
                    System.out.println("Přidáno: .--");
                    break;
                case 'x':
                case 'X':
                    morseovka += "-..- ";
                    System.out.println("Přidáno: -.-.");
                    break;
                case 'y':
                case 'Y':
                    morseovka += "-.-- ";
                    System.out.println("Přidáno: --.-");
                    break;
                case 'z':
                case 'Z':
                    morseovka += "--.. ";
                    System.out.println("Přidáno: --..");
                    break;
                case '0':
                    morseovka += "----- ";
                    System.out.println("Přidáno: -----");
                    break;
                case '1':
                    morseovka += ".---- ";
                    System.out.println("Přidáno: .----");
                    break;
                case '2':
                    morseovka += "..--- ";
                    System.out.println("Přidáno: ..---");
                    break;
                case '3':
                    morseovka += "...-- ";
                    System.out.println("Přidáno: ...--");
                    break;
                case '4':
                    morseovka += "....- ";
                    System.out.println("Přidáno: ....-");
                    break;
                case '5':
                    morseovka += "..... ";
                    System.out.println("Přidáno: .....");
                    break;
                case '6':
                    morseovka += "-.... ";
                    System.out.println("Přidáno: -....");
                    break;
                case '7':
                    morseovka += "--... ";
                    System.out.println("Přidáno: --... ");
                    break;
                case '8':
                    morseovka += "---.. ";
                    System.out.println("Přidáno: ---..");
                    break;
                case '9':
                    morseovka += "----. ";
                    System.out.println("Přidáno: ----.");
                    break;
                default:
                    morseovka += " "; // neznámý znak nahrazeno mezerou
                    System.out.println("Přidána mezera");
            }
        }
        // Nastavení textu v outputu
        output.setText(morseovka);
        System.out.println("Výsledná morseovka: " + morseovka);
    }
}
