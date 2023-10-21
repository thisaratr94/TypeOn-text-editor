package lk.ijse.dep11.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SplashScreenController {
    public AnchorPane rootSplash;

    public void initialize() throws InterruptedException {

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(1200));

        pauseTransition.setOnFinished(e -> {
            try {
                openMainWindow();
                closeSplashScreen();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        pauseTransition.play();

    }

    private void openMainWindow() throws Exception {

        AnchorPane rootMain = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
        Scene mainScene = new Scene(rootMain);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("TypeOn HTML Editor");
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();

    }

    private void closeSplashScreen() {

        Stage stageSplash = (Stage) rootSplash.getScene().getWindow();
        stageSplash.close();
    }
}
