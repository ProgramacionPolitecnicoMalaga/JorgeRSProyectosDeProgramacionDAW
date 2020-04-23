package com.politecnicomalaga.configuracion;

import java.io.*;
import java.util.Properties;

public class Propiedades {

    public final static String NOMBRE_ARCHIVO_PROPIEDADES = "config.properties";
    private Properties properties;

    public Propiedades() throws IOException {
        File archivoPropiedades = new File(NOMBRE_ARCHIVO_PROPIEDADES);
        properties = new Properties();
        if (archivoPropiedades.exists()){
            properties.load(new FileInputStream(archivoPropiedades));
        }
    }

    public String getPropiedad(String nombrePropiedad){
        return properties.getProperty(nombrePropiedad);
    }

    public void setPropiedad(String nombrePropiedad, String valorPropiedad){
        properties.setProperty(nombrePropiedad, valorPropiedad);
    }

    public void guardar() throws IOException {
        FileOutputStream output = new FileOutputStream(new File(NOMBRE_ARCHIVO_PROPIEDADES));
        properties.store(output, "Configuración de sesión");
    }

    public void borrar(String nombrePropiedad){
        properties.remove(nombrePropiedad);
    }
}
