package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExitWindowController {
    public Button btnCancel;
    public Button btnExit;
    public AnchorPane root;

    public void btnCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
