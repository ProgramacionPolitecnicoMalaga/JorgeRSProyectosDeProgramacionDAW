package com.politecnicomalaga.consumidoresSensor;

import java.util.TreeMap;

public class DiarioDeTemperaturas implements ConsumidorDeTemperaturas {

    private TreeMap<String, Double> registroDeTemperaturasDelDia;

    public DiarioDeTemperaturas(){
        registroDeTemperaturasDelDia=new TreeMap<>();
    }

    @Override
    public void actualizarTemperatura(double temperatura, String hora) {
        registroDeTemperaturasDelDia.put(hora, temperatura);
    }

    @Override
    public String toString() {
        String mensajeResultado = "El registro de temperaturas del día es el siguiente: \n";
        for(String hora: registroDeTemperaturasDelDia.keySet()){
            mensajeResultado += "Hora: " + hora + " - Temperatura: " + registroDeTemperaturasDelDia.get(hora) + " grados.\n";
        }
        return mensajeResultado;
    }
}
