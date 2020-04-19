package com.politecnicomalaga.escenarios_factory;

import com.politecnicomalaga.modelo.*;

public class DesiertoFactory implements EscenariosFactory{
    @Override
    public Jugador crearJugador() {
        return new Patton();
    }

    @Override
    public Villano crearVillano() {
        return new Rommel();
    }

    @Override
    public Obstáculos crearObstáculos() {
        return new Tanques();
    }
}
