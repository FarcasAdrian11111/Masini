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
import org.loose.fis.sre.services.VanzatorService;
import org.loose.fis.sre.model.Cumparator;
import org.loose.fis.sre.model.Vanzator;
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

public class vanzareGUIController /*implements Initializable*/ {
    @FXML
    private Button adaugaB;
    @FXML
    private Button modificaB;
    @FXML
    private Button indisponibilB;
    @FXML
    private Button istoricB;
    @FXML
    private TextField marcaT;
    @FXML
    private Button marcaB;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Vanzator seller;

    public void handleAdaugaB(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("adaugaMasiniGUI.fxml"));
        root = loader.load();
        adaugaMasiniGUIController pgc = loader.getController();
        pgc.getSeller(this.seller);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleModificaB(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("modificaMasiniGUI.fxml"));
        root = loader.load();
        modificaMasinaGUIController mgc = loader.getController();
        mgc.getSeller(this.seller);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleIndisponibilB(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("indisponibilizeazaGUI.fxml"));
        root = loader.load();
        indisponibilizeazaGUIController igc = loader.getController();
        igc.getSeller(this.seller);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleIstoricB(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("istoricGUI.fxml"));
        root = loader.load();
        istoricGUIController lgc = loader.getController();
        lgc.transferMasini(seller.getVandute());
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleMarcaB(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("marcaVGUI.fxml"));
        root = loader.load();
        marcaVGUIController mvgc = loader.getController();
        mvgc.getSeller(this.seller);
        mvgc.getMarca(marcaT.getText());
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getSeller(Vanzator seller){
        this.seller=seller;
    }
}