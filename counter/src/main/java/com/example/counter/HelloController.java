package com.example.counter;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Locale;

public class HelloController implements Runnable{

    @FXML
    private Label countLabel;

    private volatile boolean isRunning;
    private double count;
    private final ReentrantLock lock;



    public HelloController() {
        isRunning = false;
        count = 0.0;
        lock = new ReentrantLock();
    }

    public void startCounter() {
       if(isRunning == false){
           isRunning = true;
           Thread counterThread = new Thread(() -> {
               while (isRunning) {
                   lock.lock(); // Acquire the lock
                   count += 0.01;
                   updateLabel();
                   lock.unlock(); // Release the lock
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
       });

        counterThread.setDaemon(true);
        counterThread.start();
    }
    }

    public void pauseCounter() {
        isRunning = false;
    }

    public void resetCounter() {
        isRunning = false;
        count = 0.0;
        updateLabel();
    }

    public void setCountLabel(Label label) {
        countLabel = label;
    }

    public void updateLabel() {
        Platform.runLater(() -> {
            if (countLabel != null) {
                String formattedCount = String.format(Locale.US, "%.2f", count);
                countLabel.setText(formattedCount);
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (isRunning) {
                    count++;
                    updateLabel();
                    Thread.sleep(1000);
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}