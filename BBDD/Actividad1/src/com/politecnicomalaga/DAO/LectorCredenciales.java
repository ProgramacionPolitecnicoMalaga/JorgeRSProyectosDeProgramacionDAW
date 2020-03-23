package com.politecnicomalaga.DAO;

import io.github.cdimascio.dotenv.Dotenv;

public class LectorCredenciales {

    Dotenv dotenv;

    public LectorCredenciales (){
        dotenv = Dotenv.configure().directory("D:\\Módulo SDAW\\Programacion\\BBDD\\Actividad1\\lib").load();
    }

    public String getUser (){
        return dotenv.get("DDBB_USER");
    }

    public String getPassword (){
        return dotenv.get("DDBB_PASSWORD");
    }

    public String getDatabase (){
        return dotenv.get("DDBB_DATABASE");
    }

    public String getHost (){
        return dotenv.get("DDBB_HOST");
    }
}
