package com.politecnico.modelo;

public class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(String color) {
        super(color);
    }

    public void setBase(double base){
        this.base=base;
    }

    public double getBase(){
        return base;
    }

    public void setAltura(double altura){
        this.altura=altura;
    }

    public double getAltura(){
        return altura;
    }
}
