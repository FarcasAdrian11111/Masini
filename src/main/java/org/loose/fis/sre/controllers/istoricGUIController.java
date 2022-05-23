package org.loose.fis.sre.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Masina;

import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class istoricGUIController implements Initializable {

    @FXML
    private ListView myListView;
    @FXML
    private Text myText;

    private ArrayList<String> masini=null;
    private ArrayList<Integer> pret=null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //myText.setText("Istoricul masinilor incarcate pe site");
    }

    public void transferMasini(ArrayList<String> masini){
        this.masini=masini;
        ArrayList<String> mas = new ArrayList<>();
        for(String car : masini){
            mas.add(car);
        }
        myListView.getItems().addAll(mas);
    }
}
