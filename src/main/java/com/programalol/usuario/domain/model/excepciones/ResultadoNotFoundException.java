package com.programalol.usuario.domain.model.excepciones;

public class ResultadoNotFoundException extends RuntimeException {

    public ResultadoNotFoundException(String message) {
        super(message);
    }
}
