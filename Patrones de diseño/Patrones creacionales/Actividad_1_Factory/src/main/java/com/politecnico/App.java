package com.politecnico;

import com.politecnico.controlador.ControladorDatos;
import com.politecnico.lectura_datos.LectorENV;

public class App {

    public static final String tipo_viewer = LectorENV.getViewer();

    public static void main(String[] args) {
        ControladorDatos controladorDatos = new ControladorDatos();
        controladorDatos.crearViewer(tipo_viewer);
    }
}
