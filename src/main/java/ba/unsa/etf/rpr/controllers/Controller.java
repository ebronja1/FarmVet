package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Controller {
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

    public void okButtonClick(ActionEvent actionEvent) throws IOException {
        if (usernameid.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Neispravni podaci");
            alert.setContentText("Neispravan username");

            alert.showAndWait();
            return;
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Noviprozor.fxml"));
        Parent root = loader.load();
        Noviprozor noviprozor = loader.getController();
        //noviprozor.dobrodosaoButtonid.setText(noviprozor.dobrodosaoButtonid.getText() + usernameid.getText());
        stage.setTitle("FarmVet");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void actionRegisterLinkClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Registration.fxml"));
        Parent root = loader.load();
        ControllerRegistration registration = loader.getController();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
