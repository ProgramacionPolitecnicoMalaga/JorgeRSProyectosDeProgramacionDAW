package com.politecnico;

public class Aerolinea {

    private int idAerolinea;
    private String nombreAerolinea;
    private String iata;
    private String pais;
    private String codigoLlamada;

    public Aerolinea(int idAerolinea, String nombreAerolinea, String iata, String pais, String codigoLlamada) {
        this.idAerolinea = idAerolinea;
        this.nombreAerolinea = nombreAerolinea;
        this.iata = iata;
        this.pais = pais;
        this.codigoLlamada = codigoLlamada;
    }

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoLlamada() {
        return codigoLlamada;
    }

    public void setCodigoLlamada(String codigoLlamada) {
        this.codigoLlamada = codigoLlamada;
    }
}
