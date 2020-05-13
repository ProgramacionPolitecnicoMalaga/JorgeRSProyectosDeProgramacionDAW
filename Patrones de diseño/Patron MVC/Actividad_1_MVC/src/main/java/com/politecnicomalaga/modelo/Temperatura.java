package com.politecnicomalaga.modelo;

public class Temperatura {

    private double temperatura;
    private String hora;

    public Temperatura(double temperatura, String hora){
        this.temperatura=temperatura;
        this.hora=hora;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Hora: " + hora +" ------ Temperatura alcanzada: " + temperatura;
    }
}
