package com.politecnicomalaga.controlador;

import com.politecnicomalaga.escenarios_factory.EscenariosFactory;
import com.politecnicomalaga.escenarios_factory.SelectorJuego;
import com.politecnicomalaga.modelo.Jugador;
import com.politecnicomalaga.modelo.Obstáculos;
import com.politecnicomalaga.modelo.Villano;
import com.politecnicomalaga.vista.UserInterface;

public class Controlador {

    public void procesarOpcionLeidaEnInterfazDeConsola(int opcion, UserInterface ui) {
        while (opcion != UserInterface.TERMINAR) {
            switch (opcion) {
                case UserInterface.CREAR_ESCENARIO_SELVA:
                    EscenariosFactory escenarioSelva = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_SELVA);
                    Jugador jugadorSelva = escenarioSelva.crearJugador();
                    Villano villanoSelva = escenarioSelva.crearVillano();
                    Obstáculos obstáculosSelva = escenarioSelva.crearObstáculos();
                    System.out.println("Jugador: " + jugadorSelva.getTipoJugador());
                    System.out.println("Villano: " + villanoSelva.getTipoVillano());
                    System.out.println("Obstáculos: " + obstáculosSelva.getTipoObstáculo());
                    break;
                case UserInterface.CREAR_ESCENARIO_DESIERTO:
                    Jugador jugadorDesierto = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_DESIERTO).crearJugador();
                    Villano villanoDesierto = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_DESIERTO).crearVillano();
                    Obstáculos obstáculosDesierto = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_DESIERTO).crearObstáculos();
                    System.out.println("Jugador: " + jugadorDesierto.getTipoJugador());
                    System.out.println("Villano: " + villanoDesierto.getTipoVillano());
                    System.out.println("Obstáculos: " + obstáculosDesierto.getTipoObstáculo());
                    break;
                case UserInterface.CREAR_ESCENARIO_ESPACIO:
                    Jugador jugadorEspacio = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_ESPACIO).crearJugador();
                    Villano villanoEspacio = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_ESPACIO).crearVillano();
                    Obstáculos obstáculosEspacio = SelectorJuego.generarEscenario(EscenariosFactory.ESCENARIO_ESPACIO).crearObstáculos();
                    System.out.println("Jugador: " + jugadorEspacio.getTipoJugador());
                    System.out.println("Villano: " + villanoEspacio.getTipoVillano());
                    System.out.println("Obstáculos: " + obstáculosEspacio.getTipoObstáculo());
                    break;
            }
            opcion = ui.mostrarMenu();
        }
    }
}
