package com.politecnico;

public class Movimiento {
    int numeroCasilla;
    String tipoDeMovimiento;

    public Movimiento (String tipoDeMovimiento, int numeroCasilla){
        this.tipoDeMovimiento=tipoDeMovimiento;
        this.numeroCasilla = numeroCasilla;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public void setNumeroCasilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    @Override
    public String toString() {
        return tipoDeMovimiento + " a la casilla " + numeroCasilla;
    }
}
