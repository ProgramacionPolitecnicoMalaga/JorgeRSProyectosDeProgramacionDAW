package com.politecnico;

public class Asalariado extends Empleado {

    private final float salarioMensual=980;

    public Asalariado(String nombre, String apellidos, float horasTrabajadas, int numVentas) {
        super(nombre, apellidos, horasTrabajadas, numVentas);
    }

    @Override
    public float getSalario() {
        return salarioMensual;
    }
}
