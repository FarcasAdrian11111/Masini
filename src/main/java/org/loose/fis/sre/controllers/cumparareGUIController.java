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
import org.loose.fis.sre.services.CumparatorService;
import org.loose.fis.sre.model.Cumparator;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.MasinaService;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;

public class cumparareGUIController implements Initializable {
    @FXML
    private ListView myListView;

    @FXML
    private Button butonCautare;

    @FXML
    private Button butonOferte;

    @FXML
    private TextField textFieldMarca;

    @FXML
    private TextField textFieldOferta;

    @FXML
    private ImageView imagine;

    private Cumparator buyer;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //initDirectory();
        MasinaService.initDatabase();
        //MasinaService.initializare();
        ArrayList<String> car = MasinaService.returnareObiecte();
        myListView.getItems().addAll(car);
        //functie care adauga in preferinte
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                buyer.addInPreferinte((String) myListView.getSelectionModel().getSelectedItem());
            }
        });
        //imagini
        Image[] myImages = new Image[7];
        myImages[0] = new Image(getClass().getClassLoader().getResource("honda.jpg").toString(), true);
        myImages[1] = new Image(getClass().getClassLoader().getResource("ford.jpg").toString(), true);
        myImages[2] = new Image(getClass().getClassLoader().getResource("nissan.jpg").toString(), true);
        myImages[3] = new Image(getClass().getClassLoader().getResource("suzuki.jpg").toString(), true);
        myImages[4] = new Image(getClass().getClassLoader().getResource("fiat.jpg").toString(), true);
        myImages[5] = new Image(getClass().getClassLoader().getResource("bmw.jpg").toString(), true);
        myImages[6] = new Image(getClass().getClassLoader().getResource("volkswagen.jpg").toString(), true);
        imagine.setImage(myImages[1]);
    }


    public void getBuyer(Cumparator buyer) {
        this.buyer = buyer;
    }

    public void handleCautareAction() {
        ArrayList<String> car = MasinaService.returnareObiecteMarca(textFieldMarca.getText());
        myListView.getItems().clear();
        myListView.getItems().addAll(car);
    }

    public void handleOferteAction(){
        ArrayList<String> car = MasinaService.returnareObiecteOferte(textFieldOferta.getText());
        myListView.getItems().clear();
        myListView.getItems().addAll(car);
    }
}