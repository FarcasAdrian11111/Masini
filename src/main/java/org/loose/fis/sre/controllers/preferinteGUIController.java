package org.loose.fis.sre.controllers;

import java.io.IOException;
import java.util.*;

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
import org.loose.fis.sre.services.OfertaService;
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
import javafx.scene.text.Text;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.MasinaService;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.Collections;
import org.loose.fis.sre.exceptions.masinaInvalidaException;


public class preferinteGUIController implements Initializable {
    @FXML
    private ListView myListView;

    @FXML
    private TextField myTextField;

    @FXML
    private Label myLabel;
    @FXML
    private Text myText;

    private Cumparator buyer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //se executa prima, chiar inainte de getBuyer, deci poate ca buyer sa fie pe null initial
        //myListView.getItems().addAll(buyer.getPreferinte());
        //ce se intampla cand selectam si pretul e deja introdus => se trimite la vanzator sa se ocupe de el.
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String[] sequence = ((String)myListView.getSelectionModel().getSelectedItem()).split(" ");
                String marca = sequence[1];
                String vanzator = sequence[sequence.length - 1];
                VanzatorService.initDatabase();//nu mai poti selecta mai multe oferte pentru ca baza de date e deschisa deja la selectia initiala;
                Vanzator seller = VanzatorService.getVanzator(vanzator);
                //System.out.println(seller.getNume());
                //introducere in DB Oferte
                //
                int i=-1;
                for(mdc mdc2 : seller.getObjw()) {
                    i++;
                    if (mdc2.getMasina().getMarca().equals(marca)) {
                        //System.out.println(mdc2.getDeVanzare());
                        try {
                            if (mdc2.getDeVanzare()) {
                                mdc2.getBuyers().add(CumparatorService.getCumparator(buyer.getNume()));
                                VanzatorService.updateazaDB_Objw(seller);
                                OfertaService.initDatabase();
                                System.out.println(buyer.getNume() + seller.getNume());
                                OfertaService.insereaza(buyer, seller, Integer.parseInt(myTextField.getText()), marca);
                                myText.setText("Ati introdus oferta!");
                            } else {
                                throw new masinaInvalidaException();
                            }
                            break;
                        } catch (masinaInvalidaException ex){
                            myText.setText(ex.getMessage());
                        }
                    }
                }
            }
        });
    }

    public void getBuyerT(Cumparator buyer){
        this.buyer=buyer;
        myListView.getItems().addAll(buyer.getPreferinte());
    }
}