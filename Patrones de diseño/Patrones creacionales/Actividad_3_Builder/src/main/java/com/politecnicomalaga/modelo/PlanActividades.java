package com.politecnicomalaga.modelo;

public class PlanActividades {

    private boolean desayuno;
    private boolean almuerzo;
    private boolean cena;
    private TipoHabitacion tipoHabitacion;
    private boolean camaAdicional;
    private boolean parqueDeAtracciones;
    private boolean cursoKiteSurf;
    private boolean actividadesInfantiles;
    private boolean cineEnPlaya;

    public PlanActividades (){
        desayuno=false;
        almuerzo=false;
        cena=false;
        tipoHabitacion=TipoHabitacion.simple;
        camaAdicional=false;
        parqueDeAtracciones=false;
        cursoKiteSurf=false;
        actividadesInfantiles=false;
        cineEnPlaya=false;
    }

    public void setDesayuno() {
        desayuno = true;
    }


    public void setAlmuerzo() {
        almuerzo = true;
    }

    public void setCena() {
        cena = true;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setCamaAdicional() {
        camaAdicional = true;
    }

    public void setParqueDeAtracciones() {
        parqueDeAtracciones = true;
    }

    public void setCursoKiteSurf() {
        cursoKiteSurf = true;
    }

    public void setActividadesInfantiles() {
        actividadesInfantiles = true;
    }

    public void setCineEnPlaya() {
        cineEnPlaya = true;
    }

    @Override
    public String toString() {
        String plan = "Desayuno: ";
        plan += (desayuno)? "incluido\n":"no incluido\n";
        plan += "Almuerzo: ";
        plan += (almuerzo)? "incluido\n":"no incluido\n";
        plan += "Cena: ";
        plan += (cena)? "incluido\n":"no incluido\n";
        plan += "Tipo de habitación: " + tipoHabitacion + "\n";
        plan += "Cama adicional: ";
        plan += (camaAdicional)? "incluido\n":"no incluido\n";
        plan += "Parque de atracciones: ";
        plan += (parqueDeAtracciones)? "incluido\n":"no incluido\n";
        plan += "Curso de Kite Surf: ";
        plan += (cursoKiteSurf)? "incluido\n":"no incluido\n";
        plan += "Actividades infantiles: ";
        plan += (actividadesInfantiles)? "incluido\n":"no incluido\n";
        plan += "Cine en la playa: ";
        plan += (cineEnPlaya)? "incluido\n":"no incluido\n";
        return plan;
    }
}
