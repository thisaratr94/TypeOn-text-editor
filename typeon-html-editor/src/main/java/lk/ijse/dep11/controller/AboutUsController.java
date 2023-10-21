package lk.ijse.dep11.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;


public class AboutUsController {
    public AnchorPane rootAboutUs;
    public Button btnX;
    public ImageView ivNotice;
    public AnchorPane rootPane;

    private double xPos = 0;
    private double yPos = 0;

    public void initialize() {
        Platform.runLater(() -> {
            Stage stage = (Stage) rootAboutUs.getScene().getWindow();
            rootPane.setLayoutX(stage.getX() + (stage.getWidth() - rootPane.getWidth())/2);
            rootPane.setLayoutY(stage.getY() + (stage.getHeight() - rootPane.getHeight())/2);
        });
    }

    public void btnXOnAction(ActionEvent actionEvent) {
        Stage stageAboutUs = (Stage) rootAboutUs.getScene().getWindow();
        stageAboutUs.close();
    }

    public void rootPaneOnMouseDragged(MouseEvent mouseEvent) {
        rootPane.setLayoutX(mouseEvent.getSceneX() - xPos);
        rootPane.setLayoutY(mouseEvent.getSceneY() - yPos);
    }

    public void rootPaneOnMousePressed(MouseEvent mouseEvent) {
        xPos = mouseEvent.getX();
        yPos = mouseEvent.getY();
    }
}
