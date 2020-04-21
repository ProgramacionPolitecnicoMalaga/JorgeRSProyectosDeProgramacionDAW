package com.politecnicomalaga;

public class AvanceTarea {

    private Tareas tareas = Tareas.getInstance();

    public void avanzar(int númeroDeTareas){
        tareas.cambiarÚltimaTareaRealizada(númeroDeTareas);
    }

    public String mostrarÚltimaTareaRealizada(){
        return tareas.getÚltimaTarea();
    }
}
