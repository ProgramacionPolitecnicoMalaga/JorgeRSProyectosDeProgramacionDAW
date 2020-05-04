package com.politecnicomalaga.escenarios_factory;

public class SelectorJuego {

    public static EscenariosFactory generarEscenario (int tipoEscenario){
        EscenariosFactory escenario=null;
        switch (tipoEscenario){
            case EscenariosFactory.ESCENARIO_SELVA: escenario = new SelvaFactory();
            break;
            case EscenariosFactory.ESCENARIO_DESIERTO: escenario = new DesiertoFactory();
            break;
            case EscenariosFactory.ESCENARIO_ESPACIO: escenario = new EspacioFactory();
            break;
        }
        return escenario;
    }
}
