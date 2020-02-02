package com.politecnico.modelo;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado (String color) {
        super(color);
    }

    public void setLado(double lado){
        this.lado=lado;
    }

    public double getLado(){
        return lado;
    }
}
