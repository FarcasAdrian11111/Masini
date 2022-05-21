package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Cumparator;
import org.loose.fis.sre.model.Vanzator;
import org.loose.fis.sre.model.Masina;
import org.loose.fis.sre.model.mdc;
import org.loose.fis.sre.model.Oferta;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;

public class OfertaService {
    private static ObjectRepository<Oferta> ofertaRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath("C:\\Users\\iulia\\Desktop\\fisSapt7\\src\\buyer2.db")
                .openOrCreate("test4", "test4");

        ofertaRepository = database.getRepository(Oferta.class);
    }

    public static void initializare() {
    }

    public static void getOferte(){
        for(Oferta ofert : ofertaRepository.find()){
            System.out.println(ofert.getBuyer().getNume()/*+ofert.getSeller().getNume()*/+ofert.getOferta()+ofert.getMarca());
        }
    }

    public static void insereaza(Cumparator buyer, Vanzator seller, int oferta, String marca){
        System.out.println(seller.getNume()+"*******");
        ofertaRepository.insert(new Oferta(buyer, seller, oferta, marca));
    }

    public static ArrayList<String> getOferta(Vanzator seller, String marca){
        ArrayList<String> oferte = new ArrayList<>();
        OfertaService.getOferte();
        for(Oferta ofert : ofertaRepository.find()){
            if(ofert.getSeller().getNume().equals(seller.getNume()) && ofert.getMarca().equals(marca))
                oferte.add("Oferta: "+ ofert.getOferta()+" "+ "Cumparator: "+ofert.getBuyer().getNume());
        }
        return oferte;
    }
}

//null.equals.(un string)

/*
null.metoda()

 */