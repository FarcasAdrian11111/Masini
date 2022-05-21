package org.loose.fis.sre.model;

import java.util.ArrayList;
import java.util.Collections;

public class mdc{ //masina - disponibilitate - vectori de cumparatori
    private Masina masina;
    private boolean deVanzare;
    private ArrayList<Cumparator> buyers;

    public mdc(Masina masina, boolean deVanzare, ArrayList<Cumparator> buyers){
        this.masina=masina;
        this.deVanzare=deVanzare;
        this.buyers=buyers;
    }

    public mdc(){

    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    public boolean getDeVanzare() {
        return deVanzare;
    }

    public void setDeVanzare(boolean deVanzare) {
        this.deVanzare = deVanzare;
    }

    public ArrayList<Cumparator> getBuyers() {
        return buyers;
    }

    public void setBuyers(ArrayList<Cumparator> buyers) {
        this.buyers = buyers;
    }


}