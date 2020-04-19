package com.politecnicomalaga;

import com.politecnicomalaga.controlador.Controlador;
import com.politecnicomalaga.vista.UserInterface;

public class App {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Controlador controlador = new Controlador();
        int opcionLeida = ui.mostrarMenu();
        controlador.procesarOpcionLeidaEnInterfazDeConsola(opcionLeida, ui);
    }
}
