package org.loose.fis.sre.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.services.MasinaService;
import org.loose.fis.sre.model.Masina;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class cumparareGUIController implements Initializable {
    @FXML
    private ListView myListView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //initDirectory();
        MasinaService.initDatabase();
        MasinaService.initializare();
        ArrayList<String> car = MasinaService.returnareObiecte();
        for(int i=0; i<3; i++){
            System.out.println(i+car.get(i));
        }
        myListView.getItems().addAll(MasinaService.returnareObiecte());
    }
}