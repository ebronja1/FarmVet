package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
    public Button okdugmeid;
    public TextField usernameid;

    public void okButtonClick(ActionEvent actionEvent) {
        if (usernameid.getText().isEmpty()) {
            usernameid.getStyleClass().add("poljeNijeIspravno");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FarmVet");
        alert.setHeaderText("Login");
        alert.setContentText("Your username is:" + usernameid.getText());

        alert.showAndWait();
    }
}
