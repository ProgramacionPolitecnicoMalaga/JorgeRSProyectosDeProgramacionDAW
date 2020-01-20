package com.politecnico;

public class CalculadoraPorHoras implements CalculadorSalario {

    private final float sueldoPorHora=18;

    @Override
    public float calcSalario(float horasTrabajadas, int numVentas) {
        return horasTrabajadas * sueldoPorHora;
    }
}
