package com.politecnicomalaga;

public class RetrocesoTarea {

    private Tareas tareas = Tareas.getInstance();

    public void retroceder(int númeroDeTareas){
        tareas.cambiarÚltimaTareaRealizada(-númeroDeTareas);
    }

    public String mostrarÚltimaTareaRealizada(){
        return tareas.getÚltimaTarea();
    }
}
