package com.politecnicomalaga.escenarios_factory;

import com.politecnicomalaga.modelo.*;

public class EspacioFactory implements EscenariosFactory{
    @Override
    public Jugador crearJugador() {
        return new USSEnterprise();
    }

    @Override
    public Villano crearVillano() {
        return new Khan();
    }

    @Override
    public Obstáculos crearObstáculos() {
        return new NavesKlingon();
    }
}
