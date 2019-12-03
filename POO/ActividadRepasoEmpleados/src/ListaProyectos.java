import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ListaProyectos {
    private ArrayList<Proyecto> listaProyectos;

    public ListaProyectos(){
        listaProyectos=new ArrayList<>();
    }

    public void crearLista (NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);
            listaProyectos.add(new Proyecto(nodo.getAttributes().getNamedItem("nombre").getNodeValue().trim(), nodo.getAttributes().getNamedItem("departamento").getNodeValue().trim(), Double.parseDouble(nodo.getAttributes().getNamedItem("fprod").getNodeValue().trim()), nodo.getTextContent().trim()));
        }
    }

    public Proyecto getProyecto(int numProyecto){
        return listaProyectos.get(numProyecto);
    }
}
