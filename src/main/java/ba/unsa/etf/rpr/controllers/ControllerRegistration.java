package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.VetsManager;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
                if (n.trim().isEmpty()) {
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
    public void actionRegistration(ActionEvent actionEvent) throws FarmVetException {
        boolean correct = true;

            if (registrationName.getText().length() < 3 || registrationPassword.getText().length() < 3) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Status registracije:");
                alert.setContentText("Neuspješna registracija!");
                alert.showAndWait();
                correct = false;
            } else {
                correct = true;
                String name = registrationName.getText();
                String password = registrationPassword.getText();
                VetsManager vManager = new VetsManager();
                Vets v = new Vets(0, name, password);
                vManager.add(v);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Status registracije:");
                alert.setContentText("Uspješno ste registrovani!");
                alert.showAndWait();
                Stage stage = (Stage) registrationButton.getScene().getWindow();
                stage.close();
            }
    }
}
