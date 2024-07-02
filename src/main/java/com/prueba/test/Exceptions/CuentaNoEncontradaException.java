package com.prueba.test.Exceptions;

public class CuentaNoEncontradaException extends RuntimeException{
    public CuentaNoEncontradaException(String message){
        super(message);
    }
}
