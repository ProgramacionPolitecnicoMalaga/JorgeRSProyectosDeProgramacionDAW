package com.politecnicomalaga.Modelo;

public class Tipo {

    public static final int IT=0;
    public static final int DESARROLLO=1;
    public static final int MANTENIMIENTO=2;
    public static final int GENERAL=3;
    private int id;
    private String nombreTipo;

    public Tipo(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombreTipo;
    }

    public int getId() {
        return id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoPorId(int id) {
        switch (id){
            case IT: nombreTipo="IT";
            break;
            case DESARROLLO: nombreTipo="DESARROLLO";
                break;
            case MANTENIMIENTO: nombreTipo="MANTENIMIENTO";
                break;
            case GENERAL: nombreTipo="GENERAL";
                break;
        }
    }

    public int getDESARROLLO() {
        return DESARROLLO;
    }

    public int getMANTENIMIENTO() {
        return MANTENIMIENTO;
    }

    public int getGENERAL() {
        return GENERAL;
    }
}
