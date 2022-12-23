package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Noviprozor {
    public TextArea textArea;

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void akcijaOpen(ActionEvent actionEvent) {
        FileChooser izbornik = new FileChooser();
        izbornik.setTitle("Izaberite datoteku");
        izbornik.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tekstualna datoteka", "*.txt"));
        File izabrani = izbornik.showOpenDialog(textArea.getScene().getWindow());
        izbornik.showOpenDialog(textArea.getScene().getWindow());
        try {
            String tekst = new String(Files.readAllBytes(izabrani.toPath()));
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Greska");
            alert.setContentText(e.getMessage());
            alert.setTitle("Ne mogu da otvorim datoteku");
            alert.showAndWait();
        }
    }
}
