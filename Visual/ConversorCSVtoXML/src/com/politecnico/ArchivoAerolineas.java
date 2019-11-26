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

public class ArchivoAerolineas {
    public void importarDeArchivo (String datFile, HashMap<String, ArrayList<Aerolinea>> listadoPaisAerolinea){
        String linea;
        int n = 0;
        try {
            BufferedReader br = new BufferedReader (new FileReader(datFile));
            while ((linea = br.readLine()) != null) {
                String[] camposAerolinea = linea.split(",");
                Aerolinea aerolinea;
                if (Integer.parseInt(camposAerolinea[0])>=0) {
                    aerolinea = new Aerolinea((Integer.parseInt(camposAerolinea[0])), camposAerolinea[1].replace("\"", ""), camposAerolinea[4].replace("\"", ""), camposAerolinea[6].replace("\"", ""), camposAerolinea[5].replace("\"", ""));
                    ArrayList<Aerolinea> listaAerolineas = listadoPaisAerolinea.get(aerolinea.getPais());
                    if (listaAerolineas == null) {
                        listaAerolineas = new ArrayList<>();
                        listadoPaisAerolinea.put(aerolinea.getPais(), listaAerolineas);
                    }
                    listaAerolineas.add(aerolinea);
                    n++;
                }
            }
            if (br != null) {
                br.close();
            }
        } catch (Throwable t) {}
    }

    public void escribirAerolineas(String archivo, HashMap<String,ArrayList <Aerolinea>> listadoPaisAerolinea, boolean conSangria){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eAerolineas = doc.createElement("aerolineas");
            doc.appendChild(eAerolineas);
            Iterator<String> iteratorPaises=listadoPaisAerolinea.keySet().iterator();
            while (iteratorPaises.hasNext()) {
                String pais = iteratorPaises.next();

                Element ePais = doc.createElement("Pais");
                eAerolineas.appendChild(ePais);

                Attr attr = doc.createAttribute("id");
                attr.setValue(pais);
                ePais.setAttributeNode(attr);

                ArrayList<Aerolinea> listaDeAerolineas = listadoPaisAerolinea.get(pais);
                Iterator<Aerolinea> iteratorAerolineas = listaDeAerolineas.iterator();
                while (iteratorAerolineas.hasNext()) {
                    Aerolinea aerolinea = iteratorAerolineas.next();

                    Element eAerolinea = doc.createElement("aerolinea");
                    ePais.appendChild(eAerolinea);

                    Attr attribute = doc.createAttribute("id");
                    attribute.setValue(Integer.toString(aerolinea.getIdAerolinea()));
                    eAerolinea.setAttributeNode(attribute);

                    Element eNombre = doc.createElement("nombre");
                    eNombre.appendChild(doc.createTextNode(aerolinea.getNombreAerolinea()));
                    eAerolinea.appendChild(eNombre);

                    Element eIata = doc.createElement("iata");
                    eIata.appendChild(doc.createTextNode(aerolinea.getIata()));
                    eAerolinea.appendChild(eIata);

                    Element eCodigoLlamada = doc.createElement("codigoLlamada");
                    eCodigoLlamada.appendChild(doc.createTextNode(aerolinea.getCodigoLlamada()));
                    eAerolinea.appendChild(eCodigoLlamada);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            if (conSangria) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
