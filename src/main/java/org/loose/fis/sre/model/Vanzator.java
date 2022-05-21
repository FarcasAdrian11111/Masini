package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;
import java.util.Collections;

//import org.loose.fis.sre.services.CumparatorService;

public class Vanzator {
    @Id
    private String nume;
    private ArrayList<mdc> objw; //intra pe clasa mdc pentru a afla de unde vine prescurtarea
    private ArrayList<String> vandute;  //dupa ce accepta cumpararea, se transfera si in acest vector, produsul

    public Vanzator(String nume, ArrayList<mdc> objw, ArrayList<String> vandute){
        this.nume=nume;
        this.objw=objw;
        this.vandute=vandute;
    }

    public Vanzator(){

    }

    public java.lang.String getNume() {
        return nume;
    }

    public void setNume(java.lang.String nume) {
        this.nume = nume;
    }

    public ArrayList<mdc> getObjw() {
        return objw;
    }

    public void setObjw(ArrayList<mdc> objw) {
        this.objw = objw;
    }

    public ArrayList<String> getVandute(){
        return this.vandute;
    }

    public void setVandute(ArrayList<String> vandute){
        this.vandute=vandute;
    }
}