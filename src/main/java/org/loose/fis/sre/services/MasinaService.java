package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Masina;
import org.loose.fis.sre.model.Cumparator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;

public class MasinaService {

    private static ObjectRepository<Masina> masinaRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath("C:\\Users\\iulia\\Desktop\\fisSapt7\\src\\main.db")
                .openOrCreate("test1", "test1");

        masinaRepository = database.getRepository(Masina.class);
    }

    /*public static void initializare(){
        Cumparator unu = new Cumparator("unu", new ArrayList<String>(), new ArrayList<Masina>(), new ArrayList<String>());
        Cumparator doi = new Cumparator("doi", new ArrayList<String>(), new ArrayList<Masina>(), new ArrayList<String>());
        Cumparator trei = new Cumparator("trei", new ArrayList<String>(), new ArrayList<Masina>(), new ArrayList<String>());
        masinaRepository.insert(new Masina("rac", 1, 2, 3, "bac"/*, true, new cumparatorPret(unu, -1)*//*));
        masinaRepository.insert(new Masina("dac", 4, 5, 6, "bac"/*, true, new cumparatorPret(doi, -2)*//*));
        masinaRepository.insert(new Masina("vrac", 7, 8, 9, "car"/*, true, new cumparatorPret(trei, -3)*//*));
    }*/

    public static void inserare(Masina aux){
        masinaRepository.insert(aux);
    }

    /*public static void returnareMasinaVanzator(String marca, String vanzator){
        ArrayList<Masina> masini = new Arraylist<>();
        (Masina car : masinaRepository.find()){
            if(car.getMarca().equals(marca) && car.getVanzator().equals(vanzator))
            return car;
        }
        return masini;
    }*/

    public static void stergeMasina(String marca, String vanzator){
        for(Masina car : masinaRepository.find()){
            if(car.getMarca().equals(marca) && car.getVanzator().equals(vanzator)){
                masinaRepository.remove(car);
                break;
            }
        }
    }

    public static ArrayList<String> returnareObiecte(){
        ArrayList<String> masini = new ArrayList<>();
        for(Masina car : masinaRepository.find()){
            masini.add(car.toString1());
        }
        Collections.sort(masini);
        return masini;
    }

    public static ArrayList<String> returnareObiecteMarca(String marca){
        ArrayList<String> masini = new ArrayList<>();
        for(Masina car : masinaRepository.find()){
            if(car.getMarca().equals(marca))
            masini.add(car.toString1());
        }
        Collections.sort(masini);
        return masini;
    }

    public static ArrayList<String> returnareObiecteOferte(String marca){
        ArrayList<String> masini = new ArrayList<>();
        for(Masina car : masinaRepository.find()){
            if(car.getMarca().equals(marca))
                masini.add(car.toString2());
        }
        Collections.sort(masini);
        return masini;
    }
}