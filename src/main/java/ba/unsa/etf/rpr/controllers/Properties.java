package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Properties {
    public Button buttonCancelProperties;
    public TextField fldIme;
    public TextField fldPrezime;
    public DatePicker fldDatum;
    public TextField fldMedicine;
    public TextField fldAnimalName;
    public TextField fldKind;

    public void actionClose(ActionEvent actionEvent) {
        Stage stage = (Stage)buttonCancelProperties.getScene().getWindow();
        stage.close();
    }

    public void actionSubmit(ActionEvent actionEvent) {
        if (!validiraj()) return;
    }
    private boolean validiraj() {
        boolean sveIspravno = true;
        if(fldIme.getText().isEmpty()) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Field name can't be empty");
            upozorenje.showAndWait();
            fldIme.requestFocus();
            fldIme.getStyleClass().removeAll("poljeJeIspravno");
            fldIme.getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
            fldIme.getStyleClass().removeAll("poljeNijeeIspravno");
            fldIme.getStyleClass().add("poljeJeIspravno");
        }
        if(fldKind.getText().isEmpty()) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Field Kind can't be empty");
            upozorenje.showAndWait();
            fldKind.requestFocus();
            fldKind.getStyleClass().removeAll("poljeJeIspravno");
            fldKind.getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
                fldKind.getStyleClass().removeAll("poljeNijeeIspravno");
                fldKind.getStyleClass().add("poljeJeIspravno");
        }
        if(fldAnimalName.getText().isEmpty()) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Field Animal's name can't be empty");
            upozorenje.showAndWait();
            fldAnimalName.requestFocus();
            fldAnimalName.getStyleClass().removeAll("poljeJeIspravno");
            fldAnimalName.getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
            fldAnimalName.getStyleClass().removeAll("poljeNijeeIspravno");
            fldAnimalName.getStyleClass().add("poljeJeIspravno");
        }
        if(fldMedicine.getText().isEmpty()) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Field Medicine can't be empty");
            upozorenje.showAndWait();
            fldMedicine.requestFocus();
            fldMedicine.getStyleClass().removeAll("poljeJeIspravno");
            fldMedicine.getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
            fldMedicine.getStyleClass().removeAll("poljeNijeeIspravno");
            fldMedicine.getStyleClass().add("poljeJeIspravno");
        }
        if (fldDatum.getValue() == null) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Datum polje ne moze biti prazno");
            upozorenje.showAndWait();
            fldDatum.requestFocus();
            fldDatum.getEditor().getStyleClass().removeAll("poljeJeIspravno");
            fldDatum.getEditor().getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
            return sveIspravno;
        }
        else {
            fldDatum.getEditor().getStyleClass().removeAll("poljeNijeeIspravno");
            fldDatum.getEditor().getStyleClass().add("poljeJeIspravno");
        }
        if (fldDatum.getValue().isAfter(LocalDate.now())) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Datum je u buducnosti");
            upozorenje.showAndWait();
            fldDatum.requestFocus();
            fldDatum.getEditor().getStyleClass().removeAll("poljeJeIspravno");
            fldDatum.getEditor().getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
            fldDatum.getEditor().getStyleClass().removeAll("poljeNijeeIspravno");
            fldDatum.getEditor().getStyleClass().add("poljeJeIspravno");
        }
    return sveIspravno;
    }

    public void addNewAnimal(ActionEvent actionEvent) {
    }
}
