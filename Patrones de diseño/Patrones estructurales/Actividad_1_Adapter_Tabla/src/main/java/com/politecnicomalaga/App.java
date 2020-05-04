package com.politecnicomalaga;

import com.politecnicomalaga.modelo.Persona;
import com.politecnicomalaga.vista.Principal;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main( String[] args ) {

        List<Persona> listaPersonas = crearLista();

        JFrame frame = new JFrame("Personas");
        frame.setContentPane(new Principal(listaPersonas).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static List<Persona> crearLista() {
        List<Persona> lista = new ArrayList<>(){
            @Override
            public String toString() {
                String resultado = "\n-----------------------------------";
                resultado += "\nEl estado actual de la lista es:";
                for (Persona persona: this)
                    resultado += "\n" + persona.toString();
                return resultado;
            }
        };

        lista.add(new Persona("Javier","Ramírez",25));
        lista.add(new Persona("Lucía","Fernández",32));
        lista.add(new Persona("Benito","Álvarez",22));
        lista.add(new Persona("Nico","Barrionuevo",58));
        lista.add(new Persona("Gema","Zaragoza",43));
        return lista;
    }
}
