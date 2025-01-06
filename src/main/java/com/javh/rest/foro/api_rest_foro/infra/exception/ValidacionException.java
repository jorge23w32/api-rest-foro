package com.javh.rest.foro.api_rest_foro.infra.exception;

public class ValidacionException extends RuntimeException{
    public ValidacionException(String mensaje){
        super(mensaje);
    }
}
