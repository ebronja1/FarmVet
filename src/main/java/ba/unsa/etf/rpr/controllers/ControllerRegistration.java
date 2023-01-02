package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerRegistration {
    public Button registrationButton;
    public TextField registrationPassword;
    public TextField registrationName;

    @FXML
    public void initialize() {
        registrationName.getStyleClass().add("poljeNijeIspravno");
        registrationName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.trim().length() < 3) {
                    registrationName.getStyleClass().removeAll("poljeJeIspravno");
                    registrationName.getStyleClass().add("poljeNijeIspravno");
                } else {
                    registrationName.getStyleClass().removeAll("poljeNijeIspravno");
                    registrationName.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
        registrationPassword.getStyleClass().add("poljeNijeIspravno");
        registrationPassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.trim().length() < 3) {
                    registrationPassword.getStyleClass().removeAll("poljeJeIspravno");
                    registrationPassword.getStyleClass().add("poljeNijeIspravno");
                } else {
                    registrationPassword.getStyleClass().removeAll("poljeNijeIspravno");
                    registrationPassword.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }
    public void actionRegistration(ActionEvent actionEvent) {
    }
}
