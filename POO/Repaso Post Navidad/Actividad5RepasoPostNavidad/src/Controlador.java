import java.time.LocalDate;

public class Controlador {

    private Vista vista;

    public void inicializarVista() {
        GestorTareas gestorTareas = new GestorTareas();
        vista = new Vista();
        int opcion;
        opcion = vista.mostrarMenu();
        while (opcion != Vista.TERMINAR) {
            switch (opcion) {
                case Vista.CREAR_CATEGORIA:
                    String nombreCategoria = vista.crearCategoriaPorNombre();
                    gestorTareas.añadirCategoria(nombreCategoria);
                    break;
                case Vista.MOSTRAR_CATEGORIAS:
                    vista.mostrarCategorias();
                    System.out.println(gestorTareas.listaNombreCategoriasToString());
                    break;
                case Vista.CREAR_TAREA:
                    String nombreCategoriaAAñadirTarea = vista.pedirNombreCategoriaParaAñadirTarea();
                    Categoria categoriaTemporal=gestorTareas.buscarCategoriaPorNombre(nombreCategoriaAAñadirTarea);
                    if (categoriaTemporal==null){
                        vista.mensajeCategoriaNoExistente();
                    } else {
                        String nombreTarea = vista.pedirNombreTarea();
                        LocalDate fecha = vista.pedirFechaTarea();
                        String descripcion = vista.pedirDescripcionTarea();
                        categoriaTemporal.añadirTareaACategoria(new Tarea(nombreTarea, fecha, descripcion));
                    }
                    break;
                case Vista.CONSULTAR_TAREAS:
                    vista.mostrarTareasPendientes();
                    System.out.println(gestorTareas.listaTareasDeTodasLasCategoriasToString());
                    break;
                case Vista.COMPLETAR_TAREA:
                    String nombreTarea = vista.pedirNombreTareaACompletar();
                    gestorTareas.completarTarea(nombreTarea);
                    break;
                case Vista.CONSULTAR_TAREAS_CATEGORIA:
                    String nombreCategoriaAMostrar = vista.pedirNombreCategoriaAMostrar();
                    System.out.println(gestorTareas.buscarCategoriaPorNombre(nombreCategoriaAMostrar).toString());
                    break;
                case Vista.CONSULTAR_TAREAS_FECHA:
                    LocalDate fecha = vista.pedirFechaTarea();
                    vista.mostrarTareasEnUnaFecha();
                    System.out.println(gestorTareas.tareasEnUnaFecha(fecha).toString());
                    break;
                case Vista.CONSULTAR_TAREAS_EN_PLAZO:
                    System.out.println(gestorTareas.tareasEnTiempo().toString());
                    break;
                case Vista.CONSULTAR_TAREAS_RETRASADAS:
                    System.out.println(gestorTareas.tareasRetrasadas().toString());
                    break;
            }
            opcion = vista.mostrarMenu();
        }
    }
}
