import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

public class ListaEmpleados {

    private ArrayList<Empleado> listaEmpleados;

    public ListaEmpleados(){
        listaEmpleados=new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }

    public void crearNomina(ArrayList<Actividad>listaActividades){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eEmpleados = doc.createElement("empleados");
            doc.appendChild(eEmpleados);
            Iterator<Empleado>it=listaEmpleados.iterator();
            while (it.hasNext()) {
                Empleado empleado = it.next();
                Element eEmpleado = doc.createElement("empleado");
                eEmpleados.appendChild(eEmpleado);

                Attr attr = doc.createAttribute("dni");
                attr.setValue(empleado.getDni());
                eEmpleado.setAttributeNode(attr);

                Attr attr2 = doc.createAttribute("nombre");
                attr2.setValue(empleado.getNombre());
                eEmpleado.setAttributeNode(attr2);

                Attr attr3 = doc.createAttribute("sueldo_base");
                attr3.setValue(Double.toString(empleado.getSueldoBase()));
                eEmpleado.setAttributeNode(attr3);

                Attr attr4 = doc.createAttribute("productividad");
                attr4.setValue(Double.toString(empleado.getProductividad(listaActividades)));
                eEmpleado.setAttributeNode(attr4);

                Attr attr5 = doc.createAttribute("sueldo_total");
                attr5.setValue(Double.toString(empleado.getProductividad(listaActividades) + empleado.getSueldoBase()));
                eEmpleado.setAttributeNode(attr5);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("nominas.xml"));
            transformer.transform(source, result);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void crearListActEmpleado(ArrayList<Actividad> listaActividades, Empleado empleado){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eEmpleado = doc.createElement("empleado");
            doc.appendChild(eEmpleado);
            Attr attr = doc.createAttribute("dni");
            attr.setValue(empleado.getDni());
            eEmpleado.setAttributeNode(attr);

            Attr attr2 = doc.createAttribute("nombre");
            attr2.setValue(empleado.getNombre());
            eEmpleado.setAttributeNode(attr2);

            Iterator<Actividad>it=listaActividades.iterator();
            while (it.hasNext()) {
                Actividad actividad=it.next();
                if (actividad.getEmpleado()==empleado) {

                    Element eTiempo = doc.createElement("tiempo_dedicado");
                    eTiempo.appendChild(doc.createTextNode(Double.toString(actividad.getHorasRealizadas())));
                    eEmpleado.appendChild(eTiempo);

                    Element eDescripcion = doc.createElement("descripcion");
                    eDescripcion.appendChild(doc.createTextNode(actividad.getDescripcion()));
                    eEmpleado.appendChild(eDescripcion);

                    Element eProyecto = doc.createElement("proyecto");
                    eProyecto.appendChild(doc.createTextNode(actividad.getProyecto().getNombre()));
                    eEmpleado.appendChild(eProyecto);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(empleado.getDni()+".xml"));
            transformer.transform(source, result);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
