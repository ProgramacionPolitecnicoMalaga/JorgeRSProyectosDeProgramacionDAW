package com.politecnicomalaga.modelo;

public class Credencial {

    private String nombre;
    private Integer algoritmo;
    private String hash;
    private String salt;

    public Credencial (String nombre, Integer algoritmo, String hash, String salt){
        this.nombre=nombre;
        this.algoritmo=algoritmo;
        this.hash=hash;
        this.salt=salt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(Integer algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
