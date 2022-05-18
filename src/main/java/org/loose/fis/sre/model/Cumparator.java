package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;
import java.util.Collections;

import org.loose.fis.sre.services.CumparatorService;

public class Cumparator {
    @Id
    private String nume;
    private ArrayList<String> preferinte;
    private ArrayList<Masina> istoric;
    private ArrayList<String> mesaje;

    public Cumparator(String nume, ArrayList<String> preferinte, ArrayList<Masina> istoric, ArrayList<String> mesaje) {
        this.nume = nume;
        this.preferinte = preferinte;
        this.istoric = istoric;
        this.mesaje = mesaje;
    }

    public Cumparator() {
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPreferinte(ArrayList<String> preferinte) {
        this.preferinte = preferinte;
    }

    public ArrayList<String> getPreferinte() {
        return this.preferinte;
    }

    public void setIstoric(ArrayList<Masina> istoric) {
        this.istoric = istoric;
    }

    public ArrayList<Masina> getIstoric() {
        return this.istoric;
    }

    public void setMesaje(ArrayList<String> mesaje) {
        this.mesaje = mesaje;
    }

    public ArrayList<String> getMesaje() {
        return this.mesaje;
    }

    public void addInPreferinte(String preferinta){
        this.preferinte.add(preferinta);
        CumparatorService.updateazaDBPreferinte(this.nume, this.preferinte);
    }

    public void addInIstoric(Masina history){
        this.istoric.add(history);
        CumparatorService.updateazaDBIstoric(this.nume, this.istoric);
    }

    public void addInMesaje(String mesaj){
        this.mesaje.add(mesaj);
        /*for(String mesajul : this.mesaje){
            System.out.println(mesajul);
        }*/
        CumparatorService.updateazaDBMesaje(this.nume, this.mesaje);
    }
}