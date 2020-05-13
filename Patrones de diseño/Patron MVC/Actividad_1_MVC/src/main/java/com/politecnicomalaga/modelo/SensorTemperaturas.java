package com.politecnicomalaga.modelo;

import java.util.ArrayList;

public class SensorTemperaturas implements FuenteDeTemperaturas {

    public final static double LIMITE_TEMPERATURA_CRITICA=75.5;
    private ArrayList<Temperatura> listaTemperaturas;
    private ArrayList<ConsumidorDeTemperaturas> listaConsumidores;

    public SensorTemperaturas(){
        listaConsumidores=new ArrayList<>();
        listaTemperaturas=new ArrayList<>();
    }

    public void addTemperatura(double temperatura, String hora){
        listaTemperaturas.add(new Temperatura(temperatura, hora));
        informarAConsumidores();
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        listaConsumidores.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for(ConsumidorDeTemperaturas consumidorDeTemperaturas:listaConsumidores){
            consumidorDeTemperaturas.actualizarTemperatura(listaTemperaturas);
        }
    }
}
