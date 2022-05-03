package org.loose.fis.sre.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.model.User;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class logInController {
    @FXML
    private Text logInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    @FXML
    public void initialize() {

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void handleLogInAction() {
        try {
            User user;
            user=UserService.logInDB(usernameField.getText(), passwordField.getText());
            logInMessage.setText("You have succesfully logged in!");
        } catch (InvalidCredentialException e) {
            logInMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleRegisterAction(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}