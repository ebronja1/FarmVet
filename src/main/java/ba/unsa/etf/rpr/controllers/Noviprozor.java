package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicinesManager;
import ba.unsa.etf.rpr.business.VetsManager;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Noviprozor {
    private final MedicinesManager medicinesManager = new MedicinesManager();
    public TextArea textArea;
    public Label statusBar;
    public Label NPusername;
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
        NPusername.setText(nameNP);
        medicineColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedicine()));
        animalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAnimal().getName()));
        takenColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTaked().toString()));
        vetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVet().getName()));
        refreshMedicines(nameNP);
    }

    private void refreshMedicines(String name){
        try{
            VetsManager vm = new VetsManager();
            List<Vets> l = new ArrayList<>();
            l = vm.searchByUserName(name);
            medicinesTable.setItems(FXCollections.observableList(medicinesManager.searchByVets(l.get(0))));
            medicinesTable.refresh();
        }
        catch(FarmVetException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK).showAndWait();
        }
    }

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);
    }
    public void deleteRecipe() {
        try {
            medicinesManager.delete(medicinesTable.getSelectionModel().getSelectedItem().getId());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unsuccessfull delete:");
            alert.setContentText("You didn't select a recipe!");
            alert.showAndWait();
        };
        medicinesTable.getItems().remove(medicinesTable.getSelectionModel().getSelectedItem());
        medicinesTable.refresh();
    }
    public void akcijaOpenNewWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/properties.fxml"));
        Properties c = new Properties();
        loader.setController(c);
        stage.setTitle("Add new recipe");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(x -> {
            Medicines m = c.returnMedicines();
            medicinesTable.getItems().add(m);
            medicinesTable.refresh();
        });
    }
}
