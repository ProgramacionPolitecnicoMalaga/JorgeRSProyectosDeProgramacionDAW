package com.politecnico;

import java.util.Scanner;

public class Operaciones {
   private double cateto1;
   private double cateto2;
   private double hipotenusa;
   private Scanner lectorTeclado;

   public Operaciones(){
       lectorTeclado=new Scanner(System.in).useDelimiter("\n");
   }
    public double operacion1 (){
        System.out.print("Introduce la longitud del primer cateto: ");
        cateto1 = lectorTeclado.nextDouble();
        System.out.print("Introduce la longitud del segundo cateto: ");
        cateto2 = lectorTeclado.nextDouble();
        hipotenusa = Math.sqrt(Math.pow(cateto1,2)+Math.pow(cateto2,2));
        return hipotenusa;
    }

    public double operacion2 (){
        System.out.print("Introduce la longitud del primer cateto: ");
        cateto1 = lectorTeclado.nextDouble();
        System.out.print("Introduce la longitud de la hipotenusa: ");
        hipotenusa = lectorTeclado.nextDouble();
        cateto2 = Math.sqrt(Math.pow(hipotenusa,2) - Math.pow(cateto1,2));
        return cateto2;
    }

    public double operacion3 (){
        double área=0;
        System.out.print("Introduce la longitud del primer cateto: ");
        cateto1 = lectorTeclado.nextDouble();
        System.out.print("Introduce la longitud de la hipotenusa: ");
        hipotenusa = lectorTeclado.nextDouble();
        área=(cateto1*hipotenusa)/2;
        return área;
    }

    public double operacion4 (){
        double área=0;
        System.out.print("Introduce la longitud del primer cateto: ");
        cateto1 = lectorTeclado.nextDouble();
        System.out.print("Introduce la longitud del segundo cateto: ");
        cateto2 = lectorTeclado.nextDouble();
        hipotenusa = Math.sqrt(Math.pow(cateto1,2)+Math.pow(cateto2,2));
        área=(cateto1*hipotenusa)/2;
        return área;
    }

    public double realizarOperacion (int opcionOperacion){
       double resultado=0;
        switch (opcionOperacion){
            case 1: resultado=operacion1();
                break;
            case 2: resultado=operacion2();
                break;
            case 3: resultado=operacion3();
                break;
            case 4: resultado=operacion4();
            default:
                System.out.println("Operación no válida. Por favor, vuelva a introducir un valor correcto.\n");
                opcionOperacion=lectorTeclado.nextInt();
                realizarOperacion(opcionOperacion);
        }
    return resultado;
    }
}
