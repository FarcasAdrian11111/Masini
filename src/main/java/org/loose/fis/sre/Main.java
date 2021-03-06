package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.*;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            initDirectory();
            UserService.initDatabase();
            CumparatorService.initDatabase();
            VanzatorService.initDatabase();
            MasinaService.initDatabase();
            OfertaService.initDatabase();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("logIn.fxml"));
            primaryStage.setTitle("Aplicatie - Comercializare Masini");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
