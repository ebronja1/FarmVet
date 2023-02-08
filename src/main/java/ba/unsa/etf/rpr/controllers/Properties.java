package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AnimalsManager;
import ba.unsa.etf.rpr.business.MedicinesManager;
import ba.unsa.etf.rpr.business.VetsManager;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Properties {
    public Button buttonCancelProperties;
    public TextField fldIme;
    public DatePicker fldDatum;
    public TextField fldMedicine;
    public TextField fldAnimalName;
    public TextField fldKind;
    private Animals animal;
    private Medicines m = new Medicines();
    public void actionClose(ActionEvent actionEvent) {
        Stage stage = (Stage)buttonCancelProperties.getScene().getWindow();
        stage.close();
    }

    public void actionSubmit(ActionEvent actionEvent) throws FarmVetException {
        if (!validiraj()) return;
        m.setMedicine(fldMedicine.getText());
        if (animal == null) {
            AnimalsManager am = new AnimalsManager();
            List<Animals> l = new ArrayList<>();
            l = am.searchByName(fldAnimalName.getText());
            am = null;
            animal =  l.get(0);
        }
        m.setAnimal(animal);
        VetsManager vm = new VetsManager();
        List<Vets> l = new ArrayList<>();
        try {
            l = vm.searchByName(fldIme.getText());
        } catch (FarmVetException e) {
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setTitle("Wrong name");
            upozorenje.showAndWait();
        }
        Vets vet = l.get(0);
        vm = null;
        m.setVet(vet);
        Date date = new Date();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        m.setTaked(date.from(fldDatum.getValue().atStartOfDay(defaultZoneId).toInstant()));
        m.setId(0);
        MedicinesManager mm = new MedicinesManager();
        try {
            mm.add(m);
        } catch (FarmVetException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK).showAndWait();
        }
        mm = null;
        Stage s1 = (Stage) fldMedicine.getScene().getWindow();
        s1.close();
    }
    public Medicines returnMedicines() {
        return m;
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
            fldDatum.getEditor().getStyleClass().removeAll("poljeNijeIspravno");
            fldDatum.getEditor().getStyleClass().add("poljeJeIspravno");
        }
    return sveIspravno;
    }

    public void addNewAnimal(ActionEvent actionEvent) {
        animal = new Animals();
        animal.setId(0);
        animal.setName(fldAnimalName.getText());
        animal.setKind(fldKind.getText());
        AnimalsManager am = new AnimalsManager();
        try {
            am.add(animal);
        } catch (FarmVetException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage(), ButtonType.OK).showAndWait();
        }
        am = null;
    }
}
