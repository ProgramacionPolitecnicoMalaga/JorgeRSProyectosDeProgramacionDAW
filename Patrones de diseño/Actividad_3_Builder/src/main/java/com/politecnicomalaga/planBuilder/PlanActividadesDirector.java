package com.politecnicomalaga.planBuilder;

import com.politecnicomalaga.modelo.PlanActividades;
import com.politecnicomalaga.modelo.TipoHabitacion;

public class PlanActividadesDirector {

    private PlanActividadesBuilder planActividadesBuilder;

    public PlanActividadesDirector(PlanActividadesBuilder planActividadesBuilder){
        this.planActividadesBuilder=planActividadesBuilder;
    }

    public PlanActividades generarPackBásico(){
        return planActividadesBuilder.setDesayuno()
                                    .setTipoHabitacion(TipoHabitacion.simple)
                                    .getResultado();
    }

    public PlanActividades generarPackRomance(){
        return planActividadesBuilder.setCena()
                                    .setTipoHabitacion(TipoHabitacion.doble)
                                    .getResultado();
    }

    public PlanActividades generarPackFamiliar(){
        return planActividadesBuilder.setDesayuno()
                                    .setAlmuerzo()
                                    .setCena()
                                    .setTipoHabitacion(TipoHabitacion.doble)
                                    .setCamaAdicional()
                                    .setActividadesInfantiles()
                                    .setParqueDeAtracciones()
                                    .setCineEnPlaya()
                                    .getResultado();
    }

    public PlanActividades generarPackPadresRelajados(){
        return planActividadesBuilder.setDesayuno()
                                    .setAlmuerzo()
                                    .setCena()
                                    .setTipoHabitacion(TipoHabitacion.doble)
                                    .setCamaAdicional()
                                    .setActividadesInfantiles()
                                    .setCursoKiteSurf()
                                    .setCineEnPlaya()
                                    .getResultado();
    }

    public PlanActividades generarPackDeluxe(){
        return planActividadesBuilder.setDesayuno()
                                    .setAlmuerzo()
                                    .setCena()
                                    .setTipoHabitacion(TipoHabitacion.suite)
                                    .setCursoKiteSurf()
                                    .setCineEnPlaya()
                                    .getResultado();
    }

    public PlanActividades generarPackDeluxeFamiliar(){
        return planActividadesBuilder.setDesayuno()
                                    .setAlmuerzo()
                                    .setCena()
                                    .setTipoHabitacion(TipoHabitacion.suite)
                                    .setCamaAdicional()
                                    .setCursoKiteSurf()
                                    .setActividadesInfantiles()
                                    .setParqueDeAtracciones()
                                    .setCineEnPlaya()
                                    .getResultado();
    }
}
