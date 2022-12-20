package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
    public Button okdugmeid;
    public TextField usernameid;

    @FXML
    public void initialize() {
        usernameid.getStyleClass().add("poljeNijeIspravno");
        usernameid.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.trim().isEmpty()) {
                    usernameid.getStyleClass().removeAll("poljeJeIspravno");
                    usernameid.getStyleClass().add("poljeNijeIspravno");
                } else {
                    usernameid.getStyleClass().removeAll("poljeNijeIspravno");
                    usernameid.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }

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
