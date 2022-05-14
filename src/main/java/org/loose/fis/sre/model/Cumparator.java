package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;
import java.util.Collections;

public class Cumparator {
    @Id
    private String nume;
    private ArrayList<Masina> preferinte;
    private ArrayList<Masina> istoric;
    private ArrayList<String> mesaje;

    public Cumparator(String nume){
        this.nume=nume;
    }

    public String getNume(){
        return this.nume;
    }

    public void setNume(String nume){
        this.nume=nume;
    }

    public void setPreferinte(ArrayList<Masina> preferinte){
        this.preferinte=preferinte;
    }

    public ArrayList<Masina> getPreferinte(){
        return this.preferinte;
    }

    public void setIstoric(ArrayList<Masina> istoric){
        this.istoric=istoric;
    }

    public ArrayList<Masina> getIstoric(){
        return this.istoric;
    }

    public void setMesaje(ArrayList<String> mesaje){
        this.mesaje=mesaje;
    }

    public ArrayList<String> getMesaje(){
        return this.mesaje;
    }
}