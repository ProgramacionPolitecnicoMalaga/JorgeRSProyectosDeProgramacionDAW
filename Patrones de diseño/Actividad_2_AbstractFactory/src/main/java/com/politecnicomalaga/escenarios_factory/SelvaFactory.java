package com.politecnicomalaga.escenarios_factory;

import com.politecnicomalaga.modelo.*;

public class SelvaFactory implements EscenariosFactory{
    @Override
    public Jugador crearJugador() {
        return new Indiana();
    }

    @Override
    public Villano crearVillano() {
        return new Molaram();
    }

    @Override
    public Obstáculos crearObstáculos() {
        return new CarceleroTurco();
    }


}
