package com.politecnicomalaga.operaciones;

import java.util.logging.Logger;

public class Suma {

    public int sumar(int numeroA, int numeroB){
        Logger.getLogger(this.getClass().getName()).info("a = " + numeroA + "; b = " + numeroB);
        return numeroA+numeroB;
    }
}
