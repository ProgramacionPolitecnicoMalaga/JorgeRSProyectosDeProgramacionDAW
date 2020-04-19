package com.politecnico.dataviewer;

import com.politecnico.modelo.Padron;
import java.util.ArrayList;

public class HTMLDataViewer implements Dataviewer{

    @Override
    public String mostrarInformacion(ArrayList<Padron> listaEmpadronados) {
        String mostrarDatosEnTablaHtml = "<table>\n" + "\t<tr>\n" + "\t\t<th>Nacionalidad</th><th>Año</th><th>Total</th>\n" + "\t</tr>\n";
        for (Padron padron : listaEmpadronados) {
            mostrarDatosEnTablaHtml = mostrarDatosEnTablaHtml + "\t<tr>\n" + "\t\t<td>" + padron.getNacionalidad() + "</td><td>" + padron.getAño() + "</td><td>" + padron.getNum_empadronados() + "</td>\n" + "\t</tr>\n";
        }
        mostrarDatosEnTablaHtml = mostrarDatosEnTablaHtml + "</table>";
        return mostrarDatosEnTablaHtml;
    }
}
