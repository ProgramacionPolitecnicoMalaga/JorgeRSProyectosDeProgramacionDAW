package com.politecnicomalaga.modelo;

import java.util.List;

public class CalcularPromedioDeTemperaturas {

    public static double calcularPromedioDeTemperaturas(List<Temperatura> listaTemperaturasParaPromedio){
        double totalDeTodasLasTemperaturas=0;
        for(Temperatura temperatura:listaTemperaturasParaPromedio){
            totalDeTodasLasTemperaturas+=temperatura.getTemperatura();
        }
        return totalDeTodasLasTemperaturas/listaTemperaturasParaPromedio.size();
    }
}
