package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Masina {
    @Id
    private String marca;
    private int pret;
    private int marja;
    private int vechime;
    private String vanzator;

    public Masina(String marca, int pret, int marja, int vechime, String vanzator){
        this.marca=marca;
        this.pret=pret;
        this.marja=marja;
        this.vechime=vechime;
        this.vanzator=vanzator;
    }

    //eroare la baza de date fara constructor gol
    public Masina(){

    }

    public String toString1(){
        return "Marca: "+this.marca+" Vanzator: "+this.vanzator;
    }

    public String toString2() { return "Marca: "+this.marca+" pret: "+this.pret+" Marja: " +this.marja+ " Vechime: " +this.vechime+ " Vanzator: " + this.vanzator; }

    public void setMarca(String marca) {
        this.marca=marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setPret(int pret){
        this.pret=pret;
    }

    public int getPret(){
        return this.pret;
    }

    public void setMarja(int marja){
        this.marja=marja;
    }

    public int getMarja(){
        return this.marja;
    }

    public void setVechime(int vechime){
        this.vechime=vechime;
    }

    public int getVechime(){
        return this.vechime;
    }

    public void setVanzator(String vanzator) {
        this.vanzator=vanzator;
    }

    public String getVanzator() {
        return this.vanzator;
    }
}