package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.InvalidCredentialException;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.model.User;

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

    @FXML
    public void handleRegisterAction() {
        try {
            User user;
            user=UserService.logInDB(usernameField.getText(), passwordField.getText());
            logInMessage.setText("You have succesfully logged in!");
        } catch (InvalidCredentialException e) {
            logInMessage.setText(e.getMessage());
        }
    }
}