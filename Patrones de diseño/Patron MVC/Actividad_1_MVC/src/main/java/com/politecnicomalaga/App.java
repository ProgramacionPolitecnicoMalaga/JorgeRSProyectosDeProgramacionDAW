package com.politecnicomalaga;

import com.politecnicomalaga.controlador.ControladorTemperaturas;
import com.politecnicomalaga.modelo.SensorTemperaturas;

public class App {
    public static void main(String[] args) {
        SensorTemperaturas sensorTemperaturas=new SensorTemperaturas();
        ControladorTemperaturas controladorTemperaturas=new ControladorTemperaturas(sensorTemperaturas);
    }
}
