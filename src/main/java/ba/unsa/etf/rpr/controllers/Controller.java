package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.VetsManager;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Controller {
    public Button okdugmeid;
    public TextField usernameid;
    public PasswordField loginPasswordField;

    @FXML
    public void initialize() {
        usernameid.getStyleClass().add("poljeNijeIspravno");
        usernameid.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.trim().length() < 3) {
                    usernameid.getStyleClass().removeAll("poljeJeIspravno");
                    usernameid.getStyleClass().add("poljeNijeIspravno");
                } else {
                    usernameid.getStyleClass().removeAll("poljeNijeIspravno");
                    usernameid.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
        loginPasswordField.getStyleClass().add("poljeNijeIspravno");
        loginPasswordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.trim().length() < 3) {
                    loginPasswordField.getStyleClass().removeAll("poljeJeIspravno");
                    loginPasswordField.getStyleClass().add("poljeNijeIspravno");
                } else {
                    loginPasswordField.getStyleClass().removeAll("poljeNijeIspravno");
                    loginPasswordField.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }
    public void okButtonClick(ActionEvent actionEvent) throws FarmVetException, IOException {
        boolean correct = true;
        VetsManager vm = new VetsManager();
        List<Vets> l1 = new ArrayList<>();
        l1 = vm.searchByName(usernameid.getText());
        List<Vets> l2 = new ArrayList<>();
        l2 = vm.searchByPassword(loginPasswordField.getText());
        if (usernameid.getText().length() < 3 || loginPasswordField.getText().length() < 3 ||
        l1.isEmpty() || l2.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Status prijave:");
            alert.setContentText("Neuspješna prijava!");
            alert.showAndWait();
            correct = false;
        } else {
            correct = true;
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Noviprozor.fxml"));
            Noviprozor c = new Noviprozor(usernameid.getText());
            loader.setController(c);
            stage.setTitle("FarmVet");
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
        }
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
