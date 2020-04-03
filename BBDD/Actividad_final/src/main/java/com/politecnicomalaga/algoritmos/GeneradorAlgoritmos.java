package com.politecnicomalaga.algoritmos;

import java.security.NoSuchAlgorithmException;

public class GeneradorAlgoritmos {

    public static final int ALGORITMOBCRYPT = 0;
    public static final int ALGORITMOSHA3_512 = 1;

    public static IAlgoritmo generarAlgoritmo (int tipo) throws NoSuchAlgorithmException {
        IAlgoritmo algoritmo = null;
        switch (tipo){
            case ALGORITMOBCRYPT: algoritmo = new AlgoritmoBcrypt();
            break;
            case ALGORITMOSHA3_512: algoritmo = new AlgoritmoSHA3_512();
            break;
        }
        return algoritmo;
    }

    public static String getNombreAlgoritmo(int tipo){
        String nombreAlgoritmo="";
        switch (tipo){
            case ALGORITMOBCRYPT: nombreAlgoritmo="BCRYPT";
            break;
            case ALGORITMOSHA3_512: nombreAlgoritmo="SHA3-512";
            break;
        }
        return nombreAlgoritmo;
    }
}
