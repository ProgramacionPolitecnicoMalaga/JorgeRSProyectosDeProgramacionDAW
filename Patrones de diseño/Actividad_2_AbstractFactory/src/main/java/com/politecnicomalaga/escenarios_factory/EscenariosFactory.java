package com.politecnicomalaga.escenarios_factory;

import com.politecnicomalaga.modelo.Jugador;
import com.politecnicomalaga.modelo.Obstáculos;
import com.politecnicomalaga.modelo.Villano;

public interface EscenariosFactory {

    public static final int ESCENARIO_SELVA = 1;
    public static final int ESCENARIO_DESIERTO = 2;
    public static final int ESCENARIO_ESPACIO = 3;

    public Jugador crearJugador();
    public Villano crearVillano();
    public Obstáculos crearObstáculos();
}
