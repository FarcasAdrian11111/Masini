package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Cumparator;
import org.loose.fis.sre.model.Masina;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CumparatorService {
    private static ObjectRepository<Cumparator> cumparatorRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath("C:\\Users\\iulia\\Desktop\\fisSapt7\\src\\buyer.db")
                .openOrCreate("test2", "test2");

        cumparatorRepository = database.getRepository(Cumparator.class);
    }

    public static void initializare(){
    }

    public static void addCumparator(String nume, ArrayList<String> preferinte, ArrayList<Masina> istoric, ArrayList<String> mesaje){
        cumparatorRepository.insert(new Cumparator(nume, preferinte, istoric, mesaje));
    }

    public static Cumparator getCumparator(String nume){
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(nume)){
                return buyer;
            }
        }
        return null;
    }

    /*public static ArrayList<String> returnareIstoric(String nume){
        ArrayList<String> masini = new ArrayList<>();
        ArrayList<Masina> aux;
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(nume))
                aux=buyer.getIstoric();
        }
        for(Masina car : aux){
            masini.add(car);
        }
        return masini;
    }

    public static ArrayList<String> returnarePreferinte(String nume){
        ArrayList<String> masini = new ArrayList<>();
        ArrayList<Masina> aux;
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(nume))
                aux=buyer.getPreferinte();
        }
        for(Masina car : aux){
            masini.add(car);
        }
        return masini;
    }*/

    public static void updateazaDBMesaje(String name, ArrayList<String> mesaje){
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(name)){
                buyer.setMesaje(mesaje);
                cumparatorRepository.update(buyer);
            }
        }
    }

    public static void updateazaDBIstoric(String name, ArrayList<Masina> Istoric){
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(name)){
                buyer.setIstoric(Istoric);
                cumparatorRepository.update(buyer);
            }
        }
    }

    public static void updateazaDBPreferinte(String name, ArrayList<String> preferinte){
        for(Cumparator buyer : cumparatorRepository.find()){
            if(buyer.getNume().equals(name)){
                buyer.setPreferinte(preferinte);
                cumparatorRepository.update(buyer);
            }
        }
    }

    public static List<Cumparator> getAllBuyers(){
        return cumparatorRepository.find().toList();
    }
}
