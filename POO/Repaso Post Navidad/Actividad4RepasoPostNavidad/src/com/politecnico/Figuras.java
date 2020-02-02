package com.politecnico;

import com.politecnico.modelo.Circulo;
import com.politecnico.modelo.Cuadrado;
import com.politecnico.modelo.Figura;
import com.politecnico.modelo.Triangulo;
import com.politecnico.negocio.CalculadoraArea;

public class Figuras {
    static Figura[]figuras;
    public static void main(String[] args) {
        figuras=new Figura[3];

        Figura circulo=new Circulo("rojo");
        ((Circulo)circulo).setRadio(5);

        Figura triangulo=new Triangulo("verde");
        ((Triangulo)triangulo).setAltura(2);
        ((Triangulo)triangulo).setBase(3);

        Figura cuadrado=new Cuadrado("azul");
        ((Cuadrado)cuadrado).setLado(5);

        figuras[0] = circulo;
        figuras[1] = triangulo;
        figuras[2] = cuadrado;

        CalculadoraArea calculadoraArea=new CalculadoraArea();
        for (int i=0; i<figuras.length;i++){
            System.out.println(calculadoraArea.calcular(figuras[i]));
        }
    }
}
