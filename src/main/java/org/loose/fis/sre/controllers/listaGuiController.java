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
import javafx.scene.text.Text;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.MasinaService;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.Collections;

public class listaGuiController implements Initializable {
    @FXML
    private ListView myListView;
    @FXML
    private Text myText;

    private ArrayList<Masina> masini=null;
    private ArrayList<String> mesaje=null;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myText.setText("Liste secundare: aici apar ori mesajele primite sau istoricul cumparaturilor depinzand de optiunea selectata.");
        /*if(masini==null){
            if(mesaje != null)
            myListView.getItems().addAll(mesaje);
            else{
                myText.setText("Acest Cumparator n-are istoric de cumparari sau mesaje de la vanzatori!");
            }
        }
        else{
            ArrayList<String> cars = new ArrayList<>();
            for(Masina car : masini){
                cars.add(car.toString2());
            }
            myListView.getItems().addAll(cars);
        }*/
    }

    public void transferMasini(ArrayList<Masina> masini){
        this.masini=masini;
        ArrayList<String> mas = new ArrayList<>();
        for(Masina car : masini){
            mas.add(car.toString1());
        }
        myListView.getItems().addAll(mas);
    }

    public void transferMesaje(ArrayList<String> mesaje){
        this.mesaje=mesaje;
        myListView.getItems().addAll(this.mesaje);
    }
}