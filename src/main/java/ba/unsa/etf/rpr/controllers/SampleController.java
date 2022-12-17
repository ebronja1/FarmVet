package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
    public Button okdugmeid;
    public TextField usernameid;

    public void nekaakcija(ActionEvent actionEvent) {
        usernameid.setText("Please type username");
    }
}
