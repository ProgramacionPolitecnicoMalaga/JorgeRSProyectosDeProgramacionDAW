import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MapAirports {
    private JComboBox cBoxListaPaises;
    private JButton butBuscar;
    private JPanel panelMain;
    private JLabel lblPais;
    private JMapViewer map;
    private static NodeList nodos;

    public MapAirports() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pais= cBoxListaPaises.getSelectedItem().toString();
                map.removeAllMapMarkers();
                for (int i=0; i < nodos.getLength(); i++){
                    if (pais.compareToIgnoreCase(nodos.item(i).getAttributes().getNamedItem("pais").getNodeValue())==0){
                        if (isNumeric(nodos.item(i).getAttributes().getNamedItem("lat").getNodeValue())&&isNumeric(nodos.item(i).getAttributes().getNamedItem("lon").getNodeValue())) {
                            double lat=Double.parseDouble(nodos.item(i).getAttributes().getNamedItem("lat").getNodeValue());
                            double lon=Double.parseDouble(nodos.item(i).getAttributes().getNamedItem("lon").getNodeValue());
                            map.addMapMarker(new MapMarkerDot(lat, lon));
                            map.setDisplayToFitMapMarkers();
                        } else {
                        butBuscar.grabFocus();
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MapAirports");
        frame.setContentPane(new MapAirports().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static NodeList leerArchivo(String archivo) {
        try {
            String dir = System.getProperty("user.dir");
            File archEnt = new File(dir + File.separator + archivo);
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder constructor = factoria.newDocumentBuilder();
            Document doc = constructor.parse(archEnt);
            doc.getDocumentElement().normalize();
            NodeList nodos = doc.getElementsByTagName("aeropuerto");
            return nodos;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodos;
    }

    private void createUIComponents() {
        cBoxListaPaises=new JComboBox();
        nodos = leerArchivo("aeropuertos.xml");
        ArrayList<String> listaPaises = new ArrayList<>();
        String pais;
        for (int i=0; i < nodos.getLength(); i++) {
            pais = nodos.item(i).getAttributes().getNamedItem("pais").getNodeValue();
            listaPaises.add(i, pais);
        }
        Collections.sort(listaPaises);
        Iterator<String> it = listaPaises.iterator();
        String paisActual="";
        while (it.hasNext()) {
            pais = it.next();
            if (paisActual.compareTo(pais) != 0) {
                cBoxListaPaises.addItem(pais);
                paisActual = pais;
            }
        }
    }

    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
}
