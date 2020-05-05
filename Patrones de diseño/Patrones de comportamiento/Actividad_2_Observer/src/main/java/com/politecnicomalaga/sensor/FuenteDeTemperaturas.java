package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidoresSensor.ConsumidorDeTemperaturas;

public interface FuenteDeTemperaturas {

    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas);
    public void informarAConsumidores();
}
