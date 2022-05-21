package org.loose.fis.sre.model;

import java.util.ArrayList;
import java.util.Collections;

public class Oferta{
    private Cumparator buyer;
    private Vanzator seller;
    private int oferta;
    private String marca;

    public Oferta(Cumparator buyer, Vanzator seller, int oferta, String marca){
        this.buyer = buyer;
        this.seller = seller;
        this.oferta = oferta;
        this.marca = marca;
    }

    public Oferta(){

    }

    public Cumparator getBuyer() {
        return buyer;
    }

    public void setBuyer(Cumparator buyer) {
        this.buyer = buyer;
    }

    public Vanzator getSeller() {
        return seller;
    }

    public void setSeller(Vanzator seller) {
        this.seller = seller;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public java.lang.String getMarca() {
        return marca;
    }

    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }
}