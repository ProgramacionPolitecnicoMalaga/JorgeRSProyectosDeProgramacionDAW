package com.politecnico;

public class CalculadoraAsalariado implements CalculadorSalario {

    private final float salarioMensual=980;


    @Override
    public float calcSalario(float horasTrabajadas, int numVentas) {
        return salarioMensual;
    }
}
