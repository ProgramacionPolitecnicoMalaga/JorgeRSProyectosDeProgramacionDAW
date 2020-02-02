package com.politecnico.modelo;

public class Circulo extends Figura{
    private double radio;

    public Circulo(String color) {
        super(color);
    }

    public void setRadio(double radio){
        this.radio=radio;
    }

    public double getRadio(){
        return radio;
    }
}
