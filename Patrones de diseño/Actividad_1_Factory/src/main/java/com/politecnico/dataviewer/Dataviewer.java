package com.politecnico.dataviewer;

import com.politecnico.modelo.Padron;

import java.util.ArrayList;

public interface Dataviewer {

    public final static int HTML_DATAVIEWER = 1;
    public final static int TEXT_DATAVIEWER = 2;

    public String mostrarInformacion(ArrayList<Padron> listaEmpadronados);
}
