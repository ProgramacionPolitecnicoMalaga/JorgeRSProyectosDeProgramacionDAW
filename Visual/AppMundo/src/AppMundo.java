import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
import java.util.Comparator;
import java.util.Iterator;

public class AppMundo {
    private JComboBox cBoxPaises;
    private JTextArea textAeropuertos;
    private JButton butBuscar;
    private JPanel panelMain;
    private ArrayList<Aeropuerto> aeropuertos;

    public AppMundo() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAeropuertos.setText("");
                String pais=(String)(cBoxPaises.getSelectedItem());
                Iterator <Aeropuerto> itAeropuertos = aeropuertos.iterator();
                boolean primero = true;
                while (itAeropuertos.hasNext()) {
                Aeropuerto aeropuerto = itAeropuertos.next();
                    if (aeropuerto.getPais().compareTo(pais) == 0) {
                        if (primero) {
                            primero = false;
                        } else {
                            textAeropuertos.append("\n");
                        }
                        textAeropuertos.append(aeropuerto.getNombre());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AppMundo");
        frame.setContentPane(new AppMundo().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static ArrayList<Aeropuerto> leerAeropuertos(String archivo) {
        try {
            String dir = System.getProperty("user.dir");
            File archEnt = new File(dir + File.separator + archivo);
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder constructor = factoria.newDocumentBuilder();
            Document doc = constructor.parse(archEnt);
            doc.getDocumentElement().normalize();
            NodeList nodos = doc.getElementsByTagName("aeropuerto");
            ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                aeropuertos.add(new Aeropuerto(nodo.getAttributes().getNamedItem("nombreLargo").getNodeValue().trim(), nodo.getAttributes().getNamedItem("pais").getNodeValue().trim()));
            }
            return aeropuertos;
        } catch (ParserConfigurationException e) {
            return new ArrayList<Aeropuerto>();
        } catch (SAXException e) {
            return new ArrayList<Aeropuerto>();
        } catch (IOException e) {
            return new ArrayList<Aeropuerto>();
        }

    }

    public  ArrayList<String> getPaises() {
        aeropuertos.sort(COMPARE_BY_NAME);
        String nombre = new String();
        ArrayList<String> paises = new ArrayList<>();
        Iterator<Aeropuerto> it = aeropuertos.iterator();
        while (it.hasNext()) {
            Aeropuerto aeropuerto = it.next();
            if (aeropuerto.getPais().compareTo(nombre) != 0) {
                nombre = aeropuerto.getPais();
                paises.add(nombre);
            }
        }
        return paises;
    }

    private void createUIComponents() {
        cBoxPaises=new JComboBox();
        aeropuertos= leerAeropuertos("aeropuertos.xml");
        ArrayList <String> paises = getPaises();
        Iterator<String> it = paises.iterator();
        while (it.hasNext()) {
            String pais = it.next();
           cBoxPaises.addItem(pais);
        }
    }
    public static Comparator<Aeropuerto> COMPARE_BY_NAME = new Comparator<Aeropuerto>() {
        @Override
        public int compare(Aeropuerto a1, Aeropuerto a2) {
            return a1.getPais().compareTo(a2.getPais());
        }
    };
}