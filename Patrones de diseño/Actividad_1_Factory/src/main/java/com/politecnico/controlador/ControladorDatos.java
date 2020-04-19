package com.politecnico.controlador;

import com.politecnico.dataviewer.Dataviewer;
import com.politecnico.dataviewer.GeneradorDataViewer;
import com.politecnico.lectura_datos.LectorENV;
import com.politecnico.lectura_datos.LectorXML;
import com.politecnico.modelo.ListaEmpadronados;
import com.politecnico.modelo.Padron;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ControladorDatos {

    ListaEmpadronados listaEmpadronados;

    public ControladorDatos (){
        listaEmpadronados = new ListaEmpadronados();
        crearListaEmpadronados(LectorXML.leer("poblacion-por-nacionalidades_2016-2018_alcobendas.xml"));
    }

    private void crearListaEmpadronados (NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            listaEmpadronados.insertPadronEnLista(new Padron(nodo.getAttributes().getNamedItem("Año").getNodeValue(), nodo.getAttributes().getNamedItem("Nacionalidad").getNodeValue(), nodo.getAttributes().getNamedItem("Número_de_empadronados").getNodeValue()));
        }
    }

    public void crearViewer (String tipoViewer){
        if(tipoViewer.equals("html")) {
            System.out.println(GeneradorDataViewer.generarDataViewer(Dataviewer.HTML_DATAVIEWER).mostrarInformacion(listaEmpadronados.getListaEmpadronados()));
        } else System.out.println(GeneradorDataViewer.generarDataViewer(Dataviewer.TEXT_DATAVIEWER).mostrarInformacion(listaEmpadronados.getListaEmpadronados()));
    }
}
