package com.politecnico.modelo;

public class Padron {

    private String año;
    private String nacionalidad;
    private String num_empadronados;

    public Padron (String año, String nacionalidad, String num_empadronados){
        this.año=año;
        this.nacionalidad=nacionalidad;
        this.num_empadronados=num_empadronados;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNum_empadronados() {
        return num_empadronados;
    }

    public void setNum_empadronados(String num_empadronados) {
        this.num_empadronados = num_empadronados;
    }
}
