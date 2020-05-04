package com.politecnicomalaga;

import com.politecnicomalaga.controlador.ControladorPlanes;
import com.politecnicomalaga.vista.UserInterface;

public class App {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        ControladorPlanes controladorPlanes = new ControladorPlanes();
        int opcion = userInterface.mostrarMenu();
        controladorPlanes.procesarOpcionLeidaEnInterfazDeConsola(opcion);
    }
}
