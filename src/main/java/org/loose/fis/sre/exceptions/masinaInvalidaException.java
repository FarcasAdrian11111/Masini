package org.loose.fis.sre.exceptions;

public class masinaInvalidaException extends Exception{

    public masinaInvalidaException() {
        super(String.format("Masina nu mai este disponibila!"));
    }
}