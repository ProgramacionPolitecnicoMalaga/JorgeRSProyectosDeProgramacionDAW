package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Credencial;

public class DataTransferACredencial {

    public static Credencial transformar(DataTransfer datos){
        int algoritmo = 0;
        String nombre = (String) datos.get("nombre");
        if (datos.get("algoritmo") != null) {
            algoritmo = (int) datos.get("algoritmo");
        }
        String password = (String) datos.get("password");
        String salt = (String) datos.get("salt");
        return new Credencial(nombre,algoritmo,password,salt);
    }
}
