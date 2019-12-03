import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void crearListActProyecto(ArrayList<Actividad> listaActividades, Proyecto proyecto){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element eProyecto = doc.createElement("proyecto");
            doc.appendChild(eProyecto);
            Attr attr = doc.createAttribute("nombre");
            attr.setValue(proyecto.getNombre());
            eProyecto.setAttributeNode(attr);
            Element eDepartamento = doc.createElement("departamento");
            eDepartamento.appendChild(doc.createTextNode(proyecto.getDepartamento()));
            eProyecto.appendChild(eDepartamento);
            Element eDescripcion = doc.createElement("descripcion");
            eDescripcion.appendChild(doc.createTextNode(proyecto.getDescripcion()));
            eProyecto.appendChild(eDescripcion);

            Iterator<Actividad> it = listaActividades.iterator();
            while (it.hasNext()) {
                Actividad actividad = it.next();
                if (actividad.getProyecto() == proyecto) {

                    Element eEmpleado = doc.createElement("empleado");
                    eProyecto.appendChild(eEmpleado);
                    Attr attr2 = doc.createAttribute("nombre");
                    attr2.setValue(actividad.getEmpleado().getNombre());
                    eEmpleado.setAttributeNode(attr2);

                    Element eDuracion = doc.createElement("duracion");
                    eDuracion.appendChild(doc.createTextNode(Double.toString(actividad.getHorasRealizadas())));
                    eEmpleado.appendChild(eDuracion);

                    Element eDescripcionActividad = doc.createElement("actividad");
                    eDescripcionActividad.appendChild(doc.createTextNode(actividad.getDescripcion()));
                    eEmpleado.appendChild(eDescripcionActividad);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(proyecto.getNombre()+".xml"));
            transformer.transform(source, result);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
