package com.politecnico.lectura_datos;

import io.github.cdimascio.dotenv.Dotenv;

public class LectorENV {

    private static Dotenv dotenv = Dotenv.configure().load();


    public static String getViewer (){
        return dotenv.get("VIEWER");
    }
}
