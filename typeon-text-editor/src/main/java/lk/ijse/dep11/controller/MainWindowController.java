package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWindowController {
    public MenuItem miNew;
    public MenuItem miUserGuide;
    public MenuItem miAboutUs;
    public AnchorPane rootMain;
    public MenuItem miOpen;
    public MenuItem miSave;
    public MenuItem miSaveAs;
    public MenuItem miPrint;
    public MenuItem miExit;
    public HTMLEditor htmlEditor;

    public void initialize() {

    }

    public void miNewOnAction(ActionEvent actionEvent) throws Exception {

        AnchorPane rootMain = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
        Scene mainScene = new Scene(rootMain);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("TypeOn Text Editor");
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }

    public void miOpenOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));
        fileChooser.setTitle("Select a text file");

        File textFile = fileChooser.showOpenDialog(rootMain.getScene().getWindow());

        Path path = Paths.get(textFile.toURI());
        try {
            String content = Files.readString(path);
            htmlEditor.setHtmlText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try(var fis = new FileReader(textFile.getAbsolutePath());
//            var bis = new BufferedReader(fis)) {
//
//            String content = "";
//            while ((bis.readLine()) != null) {
//                content += bis.readLine() + "\n";
//            }
//            htmlEditor.setHtmlText(content);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public void miSaveOnAction(ActionEvent actionEvent) {
    }

    public void miSaveAsOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(rootMain.getScene().getWindow());

        try {
            try(var fos = new FileWriter(file);
                var bos = new BufferedWriter(fos)) {

                String content = htmlEditor.getHtmlText();
                bos.write(content);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void miAboutUsOnAction(ActionEvent actionEvent) throws Exception {

        AnchorPane rootAboutUS = FXMLLoader.load(getClass().getResource("/view/AboutUs.fxml"));
        Scene aboutUsScene = new Scene(rootAboutUS);
        Stage stageAboutUs = new Stage();

        stageAboutUs.initStyle(StageStyle.TRANSPARENT);

        rootAboutUS.setBackground(Background.fill(Color.TRANSPARENT));
        aboutUsScene.setFill(Color.TRANSPARENT);

        stageAboutUs.setScene(aboutUsScene);
        stageAboutUs.setTitle("About Us");
        stageAboutUs.setMaximized(true);
        stageAboutUs.centerOnScreen();
        stageAboutUs.show();
    }

    public void miUserGuideOnAction(ActionEvent actionEvent) throws Exception {

        ScrollPane rootUserGuide = FXMLLoader.load(getClass().getResource("/view/UserGuide.fxml"));
        Scene mainScene = new Scene(rootUserGuide);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("User Guide");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void miPrintOnAction(ActionEvent actionEvent) {
    }

    public void miExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
