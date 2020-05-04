package com.politecnicomalaga.controlador;

import com.politecnicomalaga.modelo.PlanActividades;
import com.politecnicomalaga.planBuilder.PlanActividadesBuilder;
import com.politecnicomalaga.planBuilder.PlanActividadesDirector;
import com.politecnicomalaga.vista.UserInterface;

public class ControladorPlanes {

    private PlanActividades planActividades;
    private PlanActividadesBuilder planActividadesBuilder = new PlanActividadesBuilder();
    private PlanActividadesDirector planActividadesDirector = new PlanActividadesDirector(planActividadesBuilder);

    public void procesarOpcionLeidaEnInterfazDeConsola(int opcion) {
        if (opcion != UserInterface.TERMINAR) {
            switch (opcion) {
                case UserInterface.GENERAR_PACK_BASICO:
                    planActividades = planActividadesDirector.generarPackBásico();
                    break;
                case UserInterface.GENERAR_PACK_ROMANCE:
                    planActividades = planActividadesDirector.generarPackRomance();
                    break;
                case UserInterface.GENERAR_PACK_FAMILIAR:
                    planActividades = planActividadesDirector.generarPackFamiliar();
                    break;
                case UserInterface.GENERAR_PACK_PADRES_RELAJADOS:
                    planActividades = planActividadesDirector.generarPackPadresRelajados();
                    break;
                case UserInterface.GENERAR_PACK_DELUXE:
                    planActividades = planActividadesDirector.generarPackDeluxe();
                    break;
                case UserInterface.GENERAR_PACK_DELUXE_FAMILIAR:
                    planActividades = planActividadesDirector.generarPackDeluxeFamiliar();
                    break;
            }
            System.out.println("Usted a contratado el pack con los siguientes servicios:\n" + planActividades.toString());
        }
    }
}
