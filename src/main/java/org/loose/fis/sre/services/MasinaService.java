package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.model.Masina;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class MasinaService {

    private static ObjectRepository<Masina> masinaRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                //.filePath("/C.db")
                .openOrCreate("test1", "test1");

        masinaRepository = database.getRepository(Masina.class);
    }

    public static void initializare(){
        masinaRepository.insert(new Masina("rac", "bac"));
        masinaRepository.insert(new Masina("dac", "bac"));
        masinaRepository.insert(new Masina("vrac", "car"));
    }

    public static ArrayList<String> returnareObiecte(){
        ArrayList<String> masini = new ArrayList<>();
        for(Masina car : masinaRepository.find()){
            masini.add(car.toString());
        }
        Collections.sort(masini);
        return masini;
    }
}