package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicinesManager;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.compress.archivers.dump.DumpArchiveException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Noviprozor {
    private final MedicinesManager medicinesManager = new MedicinesManager();
    public TextArea textArea;
    public Label statusBar;
    @FXML
    public TableView<Medicines> medicinesTable;
    @FXML
    public TableColumn<Medicines,String> medicineColumn;
    @FXML
    public TableColumn<Medicines,String> animalColumn;
    @FXML
    public TableColumn<Medicines, String> takenColumn;
    @FXML
    public TableColumn<Medicines,String> vetColumn;
    private String nameNP;

    public Noviprozor(String nameNP) {
        this.nameNP = nameNP;
    }
    @FXML
    public void initialize() {
        medicineColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedicine()));
        animalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAnimal().getName()));
        takenColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTaked().toString()));
        vetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVet().getName()));
        refreshMedicines();
    }

    private void refreshMedicines(){
        try{
            medicinesTable.setItems(FXCollections.observableList(medicinesManager.getAll()));
            medicinesTable.refresh();
        }
        catch(FarmVetException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK).showAndWait();
        }
    }

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void akcijaOpenNewWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/properties.fxml"));
        Parent root = loader.load();
        stage.setTitle("Properties");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
