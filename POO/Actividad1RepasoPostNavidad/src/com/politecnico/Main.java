package com.politecnico;

public class Main {
    public static void main(String[] args) {

        InterfazUsuario menu=new InterfazUsuario();
        menu.menuMedidas();
        menu.leerOpcionMedida();
        menu.menuOperacion();
        menu.realizarOperacion();
    }
}
