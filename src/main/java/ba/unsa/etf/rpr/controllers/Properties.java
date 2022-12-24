package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Properties {
    public Button buttonCancelProperties;

    public void actionClose(ActionEvent actionEvent) {
        Stage stage = (Stage)buttonCancelProperties.getScene().getWindow();
        stage.close();
    }
}
