package com.politecnico;

public class CalculadoraComisionado implements CalculadorSalario {

    private final float sueldoBase=500;
    private final float comision=50;

    @Override
    public float calcSalario(float horasTrabajadas, int numVentas) {
        return numVentas * comision + sueldoBase;
    }
}
