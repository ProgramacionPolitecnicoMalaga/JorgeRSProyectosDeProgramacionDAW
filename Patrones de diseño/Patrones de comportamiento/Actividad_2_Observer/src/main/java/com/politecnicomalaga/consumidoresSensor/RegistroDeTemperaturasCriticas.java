package com.politecnicomalaga.consumidoresSensor;

import java.util.TreeMap;

public class RegistroDeTemperaturasCriticas implements ConsumidorDeTemperaturas {

    private final double umbralTemperaturaCritica = 78.0;
    private TreeMap<String, Double> temperaturasCriticasEnDeterminadasHora;

    public RegistroDeTemperaturasCriticas(){
        temperaturasCriticasEnDeterminadasHora=new TreeMap<>();
    }

    @Override
    public void actualizarTemperatura(double temperatura, String hora) {
        if(temperatura>=umbralTemperaturaCritica){
            temperaturasCriticasEnDeterminadasHora.put(hora, temperatura);
        }
    }

    @Override
    public String toString() {
        String mensajeResultado = "El registro de temperaturas criticas es el siguiente: \n";
        for(String hora: temperaturasCriticasEnDeterminadasHora.keySet()){
            mensajeResultado += "Hora: " + hora + " - Temperatura: " + temperaturasCriticasEnDeterminadasHora.get(hora) + " grados.\n";
        }
        return mensajeResultado;
    }
}
