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

public class marcaVGUIController implements Initializable {
    @FXML
    private Button golireB;
    @FXML
    private ListView myListView;

    private Vanzator seller;
    private String marca;
    private int i;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //(String)myListView.getSelectionModel().getSelectedItem() - chestie
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {/*
                String[] sequence = ((String)myListView.getSelectionModel().getSelectedItem()).split(" ");
                int j=-1;
                for(mdc mdcs : seller.getObjw()){
                    j++;
                    if(mdcs.getMasina().getMarca().equals(this.marca))
                        break;
                }
                for(Cumparator buyer : seller.getObjw().get(j).getBuyers()){
                    if(buyer.getNume().equals(sequence[3])==false){
                        buyer.addInMesaje("Vi s-a refuzat oferta/ofertele de catre " + seller.getNume()/*+ " pentru masina cu marca " + this.marca + "!"*//*);*/
                    }
                    /*else{
                        buyer.addInMesaje("Vi s-a acceptat oferta in valoare de: " + sequence[1]+ " de catre " + seller.getNume()/*+ " pentru masina cu marca " + this.marca + "!"*//*);*/
                        //seller.getVandute().add("Masina cu marca "+this.marca+" a fost vanduta cumparatorului: " + buyer.getNume());*/
                        /*seller.getVandute().add("Masina a fost vanduta cumparatorului: " + buyer.getNume());
                        myListView.getItems().clear();
                        seller.getObjw().get(j).deVanzare(false);
                        VanzatorService.updateazaDB_Objw(seller);
                    }
                }*/

        });
}
    }

    public void handleGolireB(ActionEvent e) throws IOException{

    }

    public void getSeller(Vanzator seller){
        this.seller=seller;
    }

    public void getMarca(String marca){
        this.marca=marca;
        i=-1;
        /*ArrayList<Cumparator> cump = null;
        for(mdc mdc2 : seller.getObjw()) {
            i++;
            if (mdc2.getMasina().getMarca().equals(marca)) {
                cump=mdc2.getBuyers();
                break;
            }
        }*/
        /*ArrayList<String> numeCump = new ArrayList<>();
        for(Cumparator c : cump){
            numeCump.add(c.getNume()+" "+OfertaVanzare.getOferta(seller, marca));
        }
        /*for(Cumparator buyer : cump){
            numeCump.add(buyer.getNume());
        }*/

        //myListView.getItems().addAll(numeCump);
        OfertaService.initDatabase();
        //System.out.println(seller.getNume());




        /*eroare*/
        //myListView.getItems().addAll(OfertaService.getOferta(seller, marca));
    }
}