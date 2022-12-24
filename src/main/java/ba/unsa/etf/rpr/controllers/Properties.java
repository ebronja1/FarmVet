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
            upozorenje.setTitle("Ime ne moze biti prazno");
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
        /*if(fldPrezime.getText().isEmpty()) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Prezime ne moze biti prazno");
            upozorenje.showAndWait();
            fldPrezime.requestFocus();
            fldPrezime.getStyleClass().removeAll("poljeJeIspravno");
            fldPrezime.getStyleClass().add("poljeNijeIspravno");
            sveIspravno = false;
        }
        else {
                fldPrezime.getStyleClass().removeAll("poljeNijeeIspravno");
                fldPrezime.getStyleClass().add("poljeJeIspravno");
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
        }*/
    return sveIspravno;
    }
}
