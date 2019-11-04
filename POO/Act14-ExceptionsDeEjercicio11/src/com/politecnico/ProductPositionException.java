package com.politecnico;

public class ProductPositionException extends ArrayIndexOutOfBoundsException {

    public ProductPositionException(String message, int ultimaPosicionOcupada){
        super(message);
        System.out.println("La ultima posicion de la lista es " + ultimaPosicionOcupada);
    }
}
