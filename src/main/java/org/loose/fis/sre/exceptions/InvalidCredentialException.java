package org.loose.fis.sre.exceptions;

public class InvalidCredentialException extends Exception{

    public InvalidCredentialException() {
        super(String.format("Either username or password are incorrect!"));
    }

}
