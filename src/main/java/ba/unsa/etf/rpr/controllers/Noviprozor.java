package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Noviprozor {
    public TextArea textArea;
    public Label statusBar;

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void akcijaOpen(ActionEvent actionEvent) {
        FileChooser izbornik = new FileChooser();
        izbornik.setTitle("Izaberite datoteku");
        izbornik.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tekstualna datoteka", "*.txt"));
        File izabrani = izbornik.showOpenDialog(textArea.getScene().getWindow());
        if(izabrani == null) return;
        izbornik.showOpenDialog(textArea.getScene().getWindow());
        try {
            String tekst = new String(Files.readAllBytes(izabrani.toPath()));
            textArea.setText(tekst);
            statusBar.setText("Datoteka je ucitana!");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Greska");
            alert.setContentText(e.getMessage());
            alert.setTitle("Ne mogu da otvorim datoteku");
            alert.showAndWait();
        }
    }

    public void akcijaOpenNewWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/properties.fxml"));
        Parent root = loader.load();
        Noviprozor noviprozor = loader.getController();
        //noviprozor.dobrodosaoButtonid.setText(noviprozor.dobrodosaoButtonid.getText() + usernameid.getText());
        stage.setTitle("Properties");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
