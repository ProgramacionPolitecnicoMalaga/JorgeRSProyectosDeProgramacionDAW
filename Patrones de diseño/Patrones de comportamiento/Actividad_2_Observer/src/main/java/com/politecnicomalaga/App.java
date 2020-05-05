package com.politecnicomalaga;

import com.politecnicomalaga.consumidoresSensor.DiarioDeTemperaturas;
import com.politecnicomalaga.consumidoresSensor.PromedioDeTemperaturas;
import com.politecnicomalaga.consumidoresSensor.RegistroDeTemperaturasCriticas;
import com.politecnicomalaga.sensor.SensorTemperaturas;

public class App {
    public static void main(String[] args) {
        SensorTemperaturas sensorTemperaturas = new SensorTemperaturas();
        DiarioDeTemperaturas diarioDeTemperaturas = new DiarioDeTemperaturas();
        RegistroDeTemperaturasCriticas registroDeTemperaturasCriticas = new RegistroDeTemperaturasCriticas();
        PromedioDeTemperaturas promedioDeTemperaturas = new PromedioDeTemperaturas();
        sensorTemperaturas.registrarConsumidor(diarioDeTemperaturas);
        sensorTemperaturas.registrarConsumidor(registroDeTemperaturasCriticas);
        sensorTemperaturas.registrarConsumidor(promedioDeTemperaturas);
        sensorTemperaturas.setTemperatura(105);
        sensorTemperaturas.setHora("10:50");
        sensorTemperaturas.informarAConsumidores();
        sensorTemperaturas.setTemperatura(68);
        sensorTemperaturas.setHora("14:30");
        sensorTemperaturas.informarAConsumidores();
        sensorTemperaturas.setTemperatura(88);
        sensorTemperaturas.setHora("19:25");
        sensorTemperaturas.informarAConsumidores();
        System.out.println(diarioDeTemperaturas);
        System.out.println(registroDeTemperaturasCriticas);
        System.out.println(promedioDeTemperaturas);
    }
}
