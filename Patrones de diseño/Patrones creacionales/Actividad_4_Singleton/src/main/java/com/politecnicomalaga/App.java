package com.politecnicomalaga;

public class App {
    public static void main(String[] args) {
        Tareas tareas = Tareas.getInstance();
        AvanceTarea avanceTarea = new AvanceTarea();
        RetrocesoTarea retrocesoTarea = new RetrocesoTarea();
        tareas.addTarea("Imprimir documento");
        tareas.addTarea("Realizar inventario");
        tareas.addTarea("Firmar formularios");
        tareas.addTarea("Reunir requisitos");
        tareas.addTarea("Implementar mejoras");
        tareas.addTarea("Reparar equipo");
        tareas.addTarea("Limpiar oficina");
        tareas.addTarea("Realizar videollamadas a inversores");
        avanceTarea.avanzar(2);
        System.out.println(avanceTarea.mostrarÚltimaTareaRealizada());
        avanceTarea.avanzar(3);
        System.out.println(avanceTarea.mostrarÚltimaTareaRealizada());
        avanceTarea.avanzar(5);
        System.out.println(avanceTarea.mostrarÚltimaTareaRealizada());
        retrocesoTarea.retroceder(5);
        System.out.println(retrocesoTarea.mostrarÚltimaTareaRealizada());
        retrocesoTarea.retroceder(5);
        System.out.println(retrocesoTarea.mostrarÚltimaTareaRealizada());
    }
}
