package org.loose.fis.sre.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.services.CumparatorService;
import org.loose.fis.sre.services.VanzatorService;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import org.loose.fis.sre.model.Masina;
import org.loose.fis.sre.model.mdc;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize() {
        role.getItems().addAll("Vanzator", "Cumparator");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(), phoneNumberField.getText(), emailField.getText());
            registrationMessage.setText("Account created successfully!");
            if(((String) role.getValue()).equals("Cumparator")){
                //CumparatorService.initDatabase();
                CumparatorService.addCumparator(usernameField.getText(), new ArrayList<String>(), new ArrayList<Masina>(), new ArrayList<String>());
            }
            else{
                //VanzatorService.initDatabase();
                VanzatorService.addVanzator(usernameField.getText(), new ArrayList<mdc>(), new ArrayList<String>());
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleLogInAction(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("logIn.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
