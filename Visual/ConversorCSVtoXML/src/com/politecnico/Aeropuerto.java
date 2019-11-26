package com.politecnico;

public class Aeropuerto {

    private String nombreAeropuerto;
    private String iata;
    private String pais;
    private String ciudad;
    private double latitud;
    private double longitud;

    public Aeropuerto(String nombreAeropuerto, String iata, String pais,  String ciudad, double latitud, double longitud){
        this.nombreAeropuerto=nombreAeropuerto;
        this.iata=iata;
        this.pais=pais;
        this.ciudad=ciudad;
        this.latitud=latitud;
        this.longitud=longitud;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
