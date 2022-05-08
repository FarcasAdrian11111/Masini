package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Masina {
    @Id
    private String nume;
    private String marca;
    //private String price;

    public Masina(String nume, String marca){
        this.nume=nume;
        this.marca=marca;
    }

    //eroare la baza de date fara constructor gol
    public Masina(){

    }

    public void setNume(String nume) {
        this.nume=nume;
    }

    public String getNume(String nume){
        return this.nume;
    }

    public void setMarca(String marca) {
        this.marca=marca;
    }

    public String getMarca() {
        return this.marca;
    }

    @Override
    public String toString(){
        return "Marca: "+this.marca+" Nume: "+this.nume;
    }
}