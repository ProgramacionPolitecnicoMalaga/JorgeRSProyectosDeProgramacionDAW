package com.politecnico;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Azul", "Bernardo");

        j1.avanzarCasillas(3);
        j1.avanzarCasillas(1);
        j1.avanzarCasillas(5);
        j1.avanzarCasillas(5);
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.undo();
        j1.undo();
        j1.undo();
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.undo();
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.avanzarCasillas(2);
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.undo();
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.redo();
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.retrocederACasilla(1);
        j1.historial();
        System.out.println("-----------------------------------------");
        j1.redo();
        j1.historial();
        System.out.println("-----------------------------------------");
    }
}
