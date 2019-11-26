package com.politecnico;

import java.util.ArrayList;
import java.util.HashMap;

public class ConversorCSVtoXML {
    static HashMap <String,ArrayList <Aeropuerto>> listadoPaisAeropuerto=new HashMap<>();
    static HashMap <String,ArrayList <Aerolinea>> listadoPaisAerolinea=new HashMap<>();
    static boolean conSangria=false;

    public static void main(String[] args) {
        ArchivoAeropuertos archivoAeropuertos= new ArchivoAeropuertos();
        ArchivoAerolineas archivoAerolineas= new ArchivoAerolineas();
        archivoAeropuertos.importarDeArchivo("airports.dat", listadoPaisAeropuerto);
        archivoAerolineas.importarDeArchivo("airlines.dat", listadoPaisAerolinea);
        long inicioCronoAP=System.nanoTime();
        archivoAeropuertos.escribirAeropuertos("aeropuertosSinSangria.xml",listadoPaisAeropuerto, conSangria);
        long duracionCronoAP = System.nanoTime()-inicioCronoAP;
        System.out.println("En contruir el documento XML de Aeropuertos solo String, ha tardado " + duracionCronoAP);
        long inicioCronoAL=System.nanoTime();
        archivoAerolineas.escribirAerolineas("aerolineasSinSangria.xml",listadoPaisAerolinea, conSangria);
        long duracionCronoAL = System.nanoTime()-inicioCronoAL;
        System.out.println("En contruir el documento XML de Aerolineas solo String, ha tardado " + duracionCronoAL);
        conSangria = true;
        long inicioCronoAP2=System.nanoTime();
        archivoAeropuertos.escribirAeropuertos("aeropuertosConSangria.xml",listadoPaisAeropuerto, conSangria);
        long duracionCronoAP2 = System.nanoTime()-inicioCronoAP2;
        System.out.println("En contruir el documento XML de Aeropuertos con sangria, ha tardado " + duracionCronoAP2);
        long inicioCronoAL2=System.nanoTime();
        archivoAerolineas.escribirAerolineas("aerolineasConSangria.xml",listadoPaisAerolinea, conSangria);
        long duracionCronoAL2 = System.nanoTime()-inicioCronoAL2;
        System.out.println("En contruir el documento XML de Aerolineas con sangria, ha tardado " + duracionCronoAL2);
    }

    /*
    public void escribirArchivo (String xmlFile){

        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter(xmlFile));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            if (conSangria) {
                bw.newLine();
            }
            bw.write("<aeropuertos>");
            if (conSangria)
                bw.newLine();
            Iterator<String> iteratorPaises=listadoPaisAeropuerto.keySet().iterator();
            while (iteratorPaises.hasNext()) {
                String pais= iteratorPaises.next();
                if (conSangria) {
                    bw.write("\t");
                }
                bw.write("<Pais name=\"" + pais + "\">");
                if (conSangria)
                    bw.newLine();
                ArrayList<Aeropuerto> listaDeAeropuertos=listadoPaisAeropuerto.get(pais);
                Iterator<Aeropuerto> iteratorAeropuertos = listaDeAeropuertos.iterator();
                while (iteratorAeropuertos.hasNext()) {
                    Aeropuerto aeropuerto = iteratorAeropuertos.next();
                    if (conSangria) {
                        bw.write("\t\t");
                    }
                    bw.write("<aeropuerto>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t");
                    }
                    bw.write("<nombre><![CDATA["+ aeropuerto.getNombreAeropuerto()+"]]></nombre>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t");
                    }
                    bw.write("<iata>"+ aeropuerto.getIata() + "</iata>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t");
                    }
                    bw.write("<localizacion>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t\t");
                    }
                    bw.write("<ciudad><![CDATA["+aeropuerto.getCiudad()+"]]></ciudad>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t\t");
                    }
                    bw.write("<latitud>"+aeropuerto.getLatitud()+"</latitud>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t\t");
                    }
                    bw.write("<longitud>"+aeropuerto.getLongitud()+"</longitud>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t\t");
                    }
                    bw.write("</localizacion>");
                    if (conSangria) {
                        bw.newLine();
                        bw.write("\t\t");
                    }
                    bw.write("</aeropuerto>");
                }
                if (conSangria) {
                    bw.newLine();
                    bw.write("\t");
                }
                bw.write("</Pais>");
                if (conSangria) {
                    bw.newLine();
                }
            }
            bw.write("</aeropuertos>");
            bw.close();
        } catch (Throwable t) {}
    }

 */
}
