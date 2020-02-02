import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {
    public final static int CREAR_CATEGORIA = 1;
    public final static int MOSTRAR_CATEGORIAS = 2;
    public final static int CREAR_TAREA = 3;
    public final static int CONSULTAR_TAREAS = 4;
    public final static int COMPLETAR_TAREA = 5;
    public final static int CONSULTAR_TAREAS_CATEGORIA = 6;
    public final static int CONSULTAR_TAREAS_FECHA = 7;
    public final static int CONSULTAR_TAREAS_EN_PLAZO = 8;
    public final static int CONSULTAR_TAREAS_RETRASADAS = 9;
    public final static int TERMINAR = 0;

    private Scanner lectorTeclado;

    public Vista() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("Opciones:\n" +
                "1. Crear una nueva categoría.\n" +
                "2. Mostrar las categorías existentes.\n" +
                "3. Crear una nueva tarea.\n" +
                "4. Consultar las tareas pendientes.\n" +
                "5. Completar una tarea.\n" +
                "6. Consultar las tareas de una categoría.\n" +
                "7. Consultar las tareas en una fecha.\n" +
                "8. Consultar las tareas en tiempo.\n" +
                "9. Consultar las tareas retrasadas.\n" +
                "0. Salir.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public String crearCategoriaPorNombre() {
        System.out.println("Introduce el nombre de la categoría: ");
        return lectorTeclado.next();

    }

    public void mostrarCategorias() {
        System.out.println("Las categorías existentes son:");
    }

    public String pedirNombreCategoriaParaAñadirTarea() {
        System.out.println("Nombre de la categoría donde añadir la tarea: ");
        return lectorTeclado.next();
    }

    public String pedirNombreTarea() {
        System.out.println("Nombre de la tarea: ");
        return lectorTeclado.next();
    }

    public LocalDate pedirFechaTarea() {
        System.out.println("Fecha de la tarea (dd/mm/yyyy/): ");
        String fechaTxt = lectorTeclado.next();
        DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaTxt,formatoTiempo);
        return fecha;
    }

    public String pedirDescripcionTarea() {
        System.out.println("Descripcion de la tarea: ");
        return lectorTeclado.next();
    }

    public String pedirNombreCategoriaAMostrar() {
        System.out.println("Dime el nombre de la categoría a mostrar: ");
        return lectorTeclado.next();
    }

    public void mostrarTareasPendientes() {
        System.out.println("Las tareas pendientes son: ");
    }

    public void mostrarTareasEnUnaFecha() {
        System.out.println("Las tareas que hay para la fecha seleccionada son: ");
    }

    public String pedirNombreTareaACompletar() {
        System.out.println("Dime el nombre de la tarea a considerar completada: ");
        return lectorTeclado.next();
    }

    public void mensajeCategoriaNoExistente (){
        System.out.println("Lo sentimos, pero debe crear una categoría con ese nombre primero.");
    }
}