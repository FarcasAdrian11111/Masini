package org.loose.fis.sre.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Masina;
import org.loose.fis.sre.services.CumparatorService;
import org.loose.fis.sre.services.VanzatorService;
import org.loose.fis.sre.model.Cumparator;
import org.loose.fis.sre.model.Vanzator;
import org.loose.fis.sre.model.mdc;
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

public class adaugaMasiniGUIController /*implements Initializable*/ {
    @FXML
    private Button adaugaB;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;

    private Vanzator seller;

    public void handleAdaugaB(ActionEvent e) throws IOException{
        Masina masina = new Masina(tf4.getText(), Integer.parseInt(tf1.getText()), Integer.parseInt(tf2.getText()), Integer.parseInt(tf3.getText()), this.seller.getNume());
        seller.getObjw().add(new mdc(masina, true, new ArrayList<Cumparator>()));
        VanzatorService.updateazaDB_Objw(seller);
        //MasinaService.initDatabase();
        MasinaService.inserare(masina);
    }

    public void getSeller(Vanzator seller){
        this.seller=seller;
    }
}