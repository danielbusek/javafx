package com.example.casovac;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.net.URL;
//import javafx.media; // javafx.media není podporovaná
import java.util.ResourceBundle;


public class HelloController implements Initializable, Runnable{

    @FXML
    private ComboBox<Integer> comboMin;

    @FXML
    private ComboBox<Integer> comboHod;

    @FXML
    private ComboBox<Integer> comboSek;

    @FXML
    private GridPane panelOdpoctu;

    @FXML
    private GridPane panelNastaveni;

    @FXML
    private Label popisekHod;

    @FXML
    private Label popisekMin;

    @FXML
    private Label popisekSek;

    private int sekundy;

    private boolean bezi = false;
    private Thread t;

    private boolean pauza = false;
    Object monitor = new Object();
   // MediaPlayer mp;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Integer> hodinyList = FXCollections.observableArrayList();
        ObservableList<Integer> minutyASekundyList = FXCollections.observableArrayList();
        for(int i=0;i<60;i++){
            if(i>=0 && i<24) hodinyList.add(new Integer(i));
            minutyASekundyList.add(new Integer(i));
        }
        comboHod.setItems(hodinyList);
        comboHod.setValue(0);
        comboMin.setItems(minutyASekundyList);
        comboMin.setValue(0);
        comboSek.setItems(minutyASekundyList);
        comboSek.setValue(0);
    }

    @FXML
    void zapnutiCasovace(ActionEvent event) {
        animaceNahoru();
        bezi = true;
        pauza = false;
        t = new Thread(this); // Předáváme instanci třídy HelloController, která implementuje Runnable
        t.setDaemon(true);
        nacteniCasu();
        t.start();
    }

    private void nacteniCasu() {
        sekundy = comboHod.getValue()*3600+comboMin.getValue()*60+comboSek.getValue();
    }

    @FXML
    void zastaveniCasovace(ActionEvent event) {
        animaceDolu();
        sekundy = 0;
        bezi = false;
        pauza = true;
        synchronized (monitor){
            monitor.notify();
            pauza = false;
        }
    }

    public void animaceNahoru(){
        TranslateTransition tt1 = new TranslateTransition();
        tt1.setDuration(Duration.millis(500));
        tt1.setToX(0);
        tt1.setToY(-200);
        tt1.setNode(panelNastaveni);
        tt1.play();
    }
    public void animaceDolu(){
        TranslateTransition tt1 = new TranslateTransition();
        tt1.setDuration(Duration.millis(500));
        tt1.setToX(0);
        tt1.setToY(0);
        tt1.setNode(panelNastaveni);
        tt1.play();
    }

    @Override
    public void run() {
        //pocitat cas ve vlakne
        long cas = System.currentTimeMillis()+1000; //aktualni cas + 1s
       // System.out.println("jsem vlakno a bežím");
        while(bezi){
            synchronized (monitor){
                if(pauza) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            if(System.currentTimeMillis()>cas){ //ubehla 1s
                Platform.runLater(() -> aktualizujCas());
                if(sekundy == 0){
                    bezi = false;
                 /* Media bell = new Media(getClass().getResource("resources/echoFart.mp3").toString());
                    bezi = false;
                    mp = new MediaPlayer(bell);
                    mp.play();

                  */
                }
                else sekundy--;
                cas = System.currentTimeMillis()+1000;
            }
        }

    }
    }

    private void aktualizujCas() {
        short hod = (short) (sekundy/3600);
        popisekHod.setText((hod<10)?"0"+hod:""+hod);
        short min = (short) ((sekundy%3600)/60);
        popisekMin.setText((min<10)?"0"+min:""+min);
        short sek = (short) (sekundy%60);
        popisekSek.setText((sek<10)?"0"+sek:""+sek);

    }

    @FXML
    void pauzaCasovace(ActionEvent event) {
        if(!pauza) pauza = true;
        else {
            synchronized (monitor){
                monitor.notify();
                pauza = false;
            }
        }
    }

    @FXML
    void resetCasovace(ActionEvent event) {
        nacteniCasu();
    }

}
