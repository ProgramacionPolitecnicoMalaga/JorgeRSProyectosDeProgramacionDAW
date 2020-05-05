package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidoresSensor.ConsumidorDeTemperaturas;
import java.util.ArrayList;

public class SensorTemperaturas implements FuenteDeTemperaturas {

    private double temperatura;
    private String hora;
    private ArrayList<ConsumidorDeTemperaturas> listaConsumidores;

    public SensorTemperaturas(){
        listaConsumidores=new ArrayList<>();
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
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        listaConsumidores.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for(ConsumidorDeTemperaturas consumidorDeTemperaturas:listaConsumidores){
            consumidorDeTemperaturas.actualizarTemperatura(temperatura, hora);
        }
    }
}
