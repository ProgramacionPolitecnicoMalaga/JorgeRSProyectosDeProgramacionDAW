package com.politecnicomalaga.Modelo;

import java.time.LocalDate;

public class Item {

    private String autor;
    private LocalDate fecha;
    private String texto;
    private Tipo tipo;

    public Item(Tipo tipo, String autor, LocalDate fecha, String texto) {
        this.tipo=tipo;
        this.autor = autor;
        this.fecha = fecha;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "autor='" + autor + '\'' +
                ", fecha=" + fecha +
                ", texto='" + texto + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
