package com.politecnicomalaga.consumidoresSensor;

import java.util.ArrayList;

public class PromedioDeTemperaturas implements ConsumidorDeTemperaturas {

    ArrayList<Double> listaTemperaturasParaPromedio;

    public PromedioDeTemperaturas(){
        listaTemperaturasParaPromedio=new ArrayList<>();
    }

    @Override
    public void actualizarTemperatura(double temperatura, String hora) {
        listaTemperaturasParaPromedio.add(temperatura);
    }

    @Override
    public String toString() {
        return "El promedio de las temperaturas obtenidas hasta ahora es de: " + calcularPromedioDeTemperaturas() + " grados.";
    }

    public double calcularPromedioDeTemperaturas(){
        double totalDeTodasLasTemperaturas=0;
        for(double temperatura:listaTemperaturasParaPromedio){
            totalDeTodasLasTemperaturas+=temperatura;
        }
        return totalDeTodasLasTemperaturas/listaTemperaturasParaPromedio.size();
    }
}
