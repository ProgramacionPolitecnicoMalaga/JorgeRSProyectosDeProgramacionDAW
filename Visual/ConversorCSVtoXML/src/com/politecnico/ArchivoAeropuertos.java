package com.politecnico;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ArchivoAeropuertos {

    public void importarDeArchivo (String datFile, HashMap<String,ArrayList <Aeropuerto>> listadoPaisAeropuerto){
        String linea;
        int n = 0;
        try {
            BufferedReader br = new BufferedReader (new FileReader(datFile));
            while ((linea = br.readLine()) != null) {
                String[] camposAeropuerto = linea.split(",");
                Aeropuerto aeropuerto;
                if (isNumeric(camposAeropuerto[6])&&isNumeric(camposAeropuerto[7])) {
                    aeropuerto = new Aeropuerto((camposAeropuerto[1]).replace("\"", ""), camposAeropuerto[4].replace("\"", ""), camposAeropuerto[3].replace("\"", ""), camposAeropuerto[2].replace("\"", ""), Double.parseDouble((camposAeropuerto[6])), Double.parseDouble((camposAeropuerto[7])));
                }else aeropuerto = new Aeropuerto((camposAeropuerto[1]).replace("\"", ""), camposAeropuerto[4].replace("\"", ""), camposAeropuerto[3].replace("\"", ""), camposAeropuerto[2].replace("\"", ""), 0.0, 0.0);
                ArrayList<Aeropuerto> listaAeropuertos = listadoPaisAeropuerto.get(aeropuerto.getPais());
                if (listaAeropuertos == null) {
                    listaAeropuertos = new ArrayList<>();
                    listadoPaisAeropuerto.put(aeropuerto.getPais(), listaAeropuertos);
                }
                listaAeropuertos.add(aeropuerto);
                n++;
            }
            if (br != null) {
                br.close();
            }
        } catch (Throwable t) {}
    }

    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }

    public void escribirAeropuertos(String archivo, HashMap<String,ArrayList <Aeropuerto>> listadoPaisAeropuerto, boolean conSangria){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eAeropuertos = doc.createElement("aeropuertos");
            doc.appendChild(eAeropuertos);
            Iterator<String> iteratorPaises=listadoPaisAeropuerto.keySet().iterator();
            while (iteratorPaises.hasNext()) {
                String pais = iteratorPaises.next();

                Element ePais = doc.createElement("Pais");
                eAeropuertos.appendChild(ePais);

                Attr attr = doc.createAttribute("name");
                attr.setValue(pais);
                ePais.setAttributeNode(attr);

                ArrayList<Aeropuerto> listaDeAeropuertos = listadoPaisAeropuerto.get(pais);
                Iterator<Aeropuerto> iteratorAeropuertos = listaDeAeropuertos.iterator();
                while (iteratorAeropuertos.hasNext()) {
                    Aeropuerto aeropuerto = iteratorAeropuertos.next();

                    Element eAeropuerto = doc.createElement("aeropuerto");
                    ePais.appendChild(eAeropuerto);

                    Element eNombre = doc.createElement("nombre");
                    eNombre.appendChild(doc.createTextNode(aeropuerto.getNombreAeropuerto()));
                    eAeropuerto.appendChild(eNombre);

                    Element eIata = doc.createElement("iata");
                    eIata.appendChild(doc.createTextNode(aeropuerto.getIata()));
                    eAeropuerto.appendChild(eIata);

                    Element eLocalizacion = doc.createElement("localizacion");
                    eAeropuerto.appendChild(eLocalizacion);

                    Element eCiudad = doc.createElement("ciudad");
                    eCiudad.appendChild(doc.createTextNode(aeropuerto.getCiudad()));
                    eLocalizacion.appendChild(eCiudad);

                    Element eLatitud = doc.createElement("latitud");
                    eLatitud.appendChild(doc.createTextNode(Double.toString(aeropuerto.getLatitud())));
                    eLocalizacion.appendChild(eLatitud);

                    Element eLongitud = doc.createElement("longitud");
                    eLongitud.appendChild(doc.createTextNode(Double.toString(aeropuerto.getLongitud())));
                    eLocalizacion.appendChild(eLongitud);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            if (conSangria) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "nombre ciudad");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
