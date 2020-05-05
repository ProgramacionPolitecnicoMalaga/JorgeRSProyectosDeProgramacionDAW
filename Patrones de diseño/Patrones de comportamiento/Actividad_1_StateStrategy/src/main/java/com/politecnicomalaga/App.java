package com.politecnicomalaga;

import com.politecnicomalaga.criterios.SelectorDeCriterio;
import com.politecnicomalaga.criterios.SelectorDeMejorProducto;
import com.politecnicomalaga.factory_criterios.CriteriosFactory;
import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

import java.util.Scanner;

public class App {

    public static void main( String[] args ) {
        Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
        LoteDeProductos loteProductos = new LoteDeProductos();
        loteProductos.addProducto(new Producto("Madera de roble",55,3));
        loteProductos.addProducto(new Producto("Madera de nogal",83,5));
        loteProductos.addProducto(new Producto("Aglomerado",22,1));
        loteProductos.addProducto(new Producto("Contrachapado",25,4));
        loteProductos.addProducto(new Producto("Madera de pino",40,2));

        System.out.println("-------------------------------------\n");
        System.out.print( "¿Que producto desea obtener?\n" +
                        "1. Producto con mejor valoracion\n" +
                        "2. Producto con mejor precio\n" +
                        "3. Producto con mejor relacion calidad/precio\n" +
                        "Opción: ");
        int opcion = lectorTeclado.nextInt();
        System.out.println("------------------------------------");

        SelectorDeMejorProducto selectorDeMejorProducto= CriteriosFactory.crearCriterioDeEleccion(opcion);
        SelectorDeCriterio selectorDeCriterio = new SelectorDeCriterio();
        selectorDeCriterio.setCriterioSeleccionado(selectorDeMejorProducto);

        System.out.println(selectorDeCriterio.getProducto(loteProductos));

    }
}
