package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class Tareas {

    private static Tareas instancia = null;
    private int últimaTareaRealizada=0;
    private List<String> tareas;

    public Tareas(){
        tareas = new ArrayList<>();
    }

    public static Tareas getInstance(){
        if (instancia == null)
            instancia = new Tareas();
        return instancia;
    }

    public void addTarea(String tarea){
        tareas.add(tarea);
    }

    public String getÚltimaTarea() {
        String tarea ="";
        try {
            tarea = tareas.get(últimaTareaRealizada);
        } catch (IndexOutOfBoundsException e) {
            if (últimaTareaRealizada < 0 && !tareas.isEmpty()) {
                últimaTareaRealizada=0;
                tarea = tareas.get(últimaTareaRealizada);
            } else if (tareas.isEmpty()) {
                System.out.println("No existen tareas en la lista.");
            } else {
                últimaTareaRealizada=tareas.size() - 1;
                tarea = tareas.get(últimaTareaRealizada);
            }
        }
        return tarea;
    }
    public void cambiarÚltimaTareaRealizada(int númeroDeTareas){
        últimaTareaRealizada = últimaTareaRealizada + númeroDeTareas;
    }
}
