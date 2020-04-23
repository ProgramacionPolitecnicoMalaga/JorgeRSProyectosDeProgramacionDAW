package com.politecnicomalaga.modelo;

public class Usuario {

    String id;
    String nombre;

    public Usuario(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
