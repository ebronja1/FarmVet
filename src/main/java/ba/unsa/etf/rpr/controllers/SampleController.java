package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
    public Button okdugmeid;
    public TextField usernameid;

    public void okButtonClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FarmVet");
        alert.setHeaderText("Login");
        alert.setContentText("Welcome!");

        alert.showAndWait();
    }
}
