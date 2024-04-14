package com.example.demo_hbb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class HelloController {

    @FXML
    private TextField path;

    @FXML
    private TextArea text;

    @FXML
    private TextField filename;

    @FXML
    private ListView<?> list;

    @FXML
    void browse(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Destination Folder");

        // Open directory chooser and allow selecting folders
        File folder = directoryChooser.showDialog(null);

        if (folder != null) {
            path.setText(folder.getAbsolutePath());
        }
    }

    @FXML
    void create(ActionEvent event) {
        String folderPath = path.getText();
        String fileName = filename.getText();
        String content = text.getText();

        if (folderPath.isEmpty() || fileName.isEmpty() || content.isEmpty()) {
            // Show error message if any field is empty
            System.out.println("Please fill all fields!");
            return;
        }

        File file = new File(folderPath, fileName + ".txt");

        try {
            // Check if file already exists (optional)
            if (file.exists()) {
                // Prompt user for confirmation before overwriting
                // You can implement confirmation logic here (e.g., using Alert)
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("File created successfully!");

        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }


    @FXML
    void read(ActionEvent event) {
        String folderPath = path.getText();
        String fileName = filename.getText();

        if (folderPath.isEmpty() || fileName.isEmpty()) {
            System.out.println("Please enter folder path and filename!");
            return;
        }

        File file = new File(folderPath, fileName + ".txt");

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try {
            FileReader reader = new FileReader(file);
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            reader.close();
            text.setText(content.toString());
            System.out.println("File read successfully!");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
