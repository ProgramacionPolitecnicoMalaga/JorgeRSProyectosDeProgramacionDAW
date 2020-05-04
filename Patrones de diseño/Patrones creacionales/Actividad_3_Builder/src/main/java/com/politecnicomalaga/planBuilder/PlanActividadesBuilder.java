package com.politecnicomalaga.planBuilder;

import com.politecnicomalaga.modelo.PlanActividades;
import com.politecnicomalaga.modelo.TipoHabitacion;

public class PlanActividadesBuilder {

    PlanActividades planActividades;

    public PlanActividadesBuilder(){
        planActividades=new PlanActividades();
    }

    public PlanActividadesBuilder setDesayuno(){
        planActividades.setDesayuno();
        return this;
    }

    public PlanActividadesBuilder setAlmuerzo(){
        planActividades.setAlmuerzo();
        return this;
    }

    public PlanActividadesBuilder setCena(){
        planActividades.setCena();
        return this;
    }

    public PlanActividadesBuilder setTipoHabitacion(TipoHabitacion tipoHabitacion){
        planActividades.setTipoHabitacion(tipoHabitacion);
        return this;
    }

    public PlanActividadesBuilder setCamaAdicional(){
        planActividades.setCamaAdicional();
        return this;
    }

    public PlanActividadesBuilder setParqueDeAtracciones(){
        planActividades.setParqueDeAtracciones();
        return this;
    }

    public PlanActividadesBuilder setCursoKiteSurf(){
        planActividades.setCursoKiteSurf();
        return this;
    }

    public PlanActividadesBuilder setActividadesInfantiles(){
        planActividades.setActividadesInfantiles();
        return this;
    }

    public PlanActividadesBuilder setCineEnPlaya(){
        planActividades.setCineEnPlaya();
        return this;
    }

    public PlanActividades getResultado(){
        return planActividades;
    }
}
