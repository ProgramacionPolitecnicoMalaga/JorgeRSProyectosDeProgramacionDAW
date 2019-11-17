package com.politecnico;

import java.util.LinkedList;
import java.util.ListIterator;

public class Jugador {
    private String color;
    private String nombreJugador;
    private int casillaActual;
    private int numeroDeMovimientosTotales=0;
    LinkedList historialMovimientos;
    LinkedList redoUndo=new LinkedList();

    public Jugador(String color, String nombreJugador){
        this.color=color;
        this.nombreJugador=nombreJugador;
        casillaActual=0;
        historialMovimientos=new LinkedList();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public void avanzarCasillas (int numeroCasillasAvance){
        casillaActual= casillaActual + numeroCasillasAvance;
        Movimiento avance=new Movimiento("Avance", casillaActual);
        historialMovimientos.addLast(avance);
        redoUndo=new LinkedList();

    }

    public void retrocederACasilla (int numeroCasillaAIr) {
        casillaActual=numeroCasillaAIr;
        Movimiento retroceso=new Movimiento("Retroceso", casillaActual);
        historialMovimientos.addLast(retroceso);
    }

    public void historial(){
        ListIterator<Movimiento> iterator= historialMovimientos.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public void undo(){
        if (historialMovimientos.size()>=1){
            Movimiento movimiento=(Movimiento)(historialMovimientos.getLast());
            historialMovimientos.removeLast();
            redoUndo.addLast(movimiento);
            if (historialMovimientos.size() > 0) {
                casillaActual = ((Movimiento)(historialMovimientos.getLast())).getNumeroCasilla();
            } else {
                casillaActual = 0;
            }
        } else {
            System.out.println("Casilla de salida " + casillaActual);
        }
    }

    public void redo(){
        if (redoUndo.size()>=1){
            Movimiento movimiento=(Movimiento)(redoUndo.getLast());
            historialMovimientos.addLast(movimiento);
            casillaActual=movimiento.getNumeroCasilla();
            redoUndo.removeLast();
        } else System.out.println("No tienes más movimientos por rehacer");
    }
}
