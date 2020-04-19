package com.politecnico.dataviewer;

import com.politecnico.modelo.Padron;

import java.util.ArrayList;

public class TextDataViewer implements Dataviewer{


    @Override
    public String mostrarInformacion(ArrayList<Padron> listaEmpadronados) {
        String mostrarDatosEnTexto = "Listado de empadronamientos:\n";
        for (Padron padron : listaEmpadronados) {
            mostrarDatosEnTexto = mostrarDatosEnTexto + "\tEl total de empadronados en " + padron.getAño() + " procedentes de " + padron.getNacionalidad() + " fue de " + padron.getNum_empadronados() + " personas.\n";
        }
        return mostrarDatosEnTexto;
    }
}
