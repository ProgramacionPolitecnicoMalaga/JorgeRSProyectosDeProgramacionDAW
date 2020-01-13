package com.politecnico;
abstract class Empleado {

    private String nombre;
    private String apellidos;
    private float horasTrabajadas;
    private int numVentas;

    public Empleado (String nombre, String apellidos, float horasTrabajadas, int numVentas){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.horasTrabajadas=horasTrabajadas;
        this.numVentas=numVentas;
    }

    public abstract float getSalario();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellidos: " + apellidos +
                "\nHoras trabajadas: " + horasTrabajadas +
                "\nVentas: " + numVentas +
                "\nSalario total: " + getSalario() + "\n";
    }
}
