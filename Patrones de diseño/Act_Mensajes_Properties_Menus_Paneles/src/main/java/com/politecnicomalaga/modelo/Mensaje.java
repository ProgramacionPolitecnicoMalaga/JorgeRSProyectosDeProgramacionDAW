package com.politecnicomalaga.modelo;

public class Mensaje {

    String titulo;
    String texto;
    String idDestinatario;
    String nombreRemitente;
    String fechaEnvioMensaje;

    public Mensaje(String titulo, String texto, String idDestinatario, String nombreRemitente, String fechaEnvioMensaje){
        this.titulo = titulo;
        this.texto = texto;
        this.idDestinatario = idDestinatario;
        this.nombreRemitente = nombreRemitente;
        this.fechaEnvioMensaje = fechaEnvioMensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public String getFechaEnvioMensaje() {
        return fechaEnvioMensaje;
    }
}
