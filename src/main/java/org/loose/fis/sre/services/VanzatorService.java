package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Cumparator;
import org.loose.fis.sre.model.Vanzator;
import org.loose.fis.sre.model.Masina;
import org.loose.fis.sre.model.mdc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;

public class VanzatorService {
    private static ObjectRepository<Vanzator> vanzatorRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath("C:\\Users\\iulia\\Desktop\\fisSapt7\\src\\seller.db")
                .openOrCreate("test3", "test3");

        vanzatorRepository = database.getRepository(Vanzator.class);
    }

    public static void initializare(){
    }

    public static void addVanzator(String nume, ArrayList<mdc> objw, ArrayList<String> istoric){
        vanzatorRepository.insert(new Vanzator(nume, objw, istoric));
    }

    public static Vanzator getVanzator(String nume){
        for(Vanzator seller : vanzatorRepository.find()){
            if(seller.getNume().equals(nume)){
                return seller;
            }
        }
        return null;
    }

    /*public static void updateazaDB_Objw(Vanzator aux){
        for(Vanzator seller : vanzatorRepository.find()){
            if(seller.getNume().equals(aux.getNume())){
                seller.setObjw(aux.getObjw());
                vanzatorRepository.update(seller);
            }
        }
    }*/

    public static void updateazaDB_Objw(Vanzator aux){
        for(Vanzator seller : vanzatorRepository.find()){
            if(seller.getNume().equals(aux.getNume())){
                seller.setObjw(aux.getObjw());
                vanzatorRepository.update(seller);
            }
        }
    }
}