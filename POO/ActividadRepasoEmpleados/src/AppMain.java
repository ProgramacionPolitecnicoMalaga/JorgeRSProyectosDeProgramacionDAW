public class AppMain {

    public static void main(String[] args) {
        ListaEmpleados empleados=new ListaEmpleados();
        ListaActividades actividades=new ListaActividades();
        ListaProyectos proyectos=new ListaProyectos();
        proyectos.crearLista(new LeerXML().leer("Proyectos.xml"));
        JefeDeProyecto empleado1=new JefeDeProyecto("77585514G", "Pepe Ramirez");
        Programador empleado2=new Programador("24558861C", "Pedro Perez");
        empleados.registrarEmpleado(empleado1);
        empleados.registrarEmpleado(empleado2);
        actividades.introducirActividad(new Actividad(30.0, "Realizado metodos de gestion de datos", empleado1, proyectos.getProyecto(2)));
        empleados.crearNomina(actividades.getListaActividades());
        empleados.crearListActEmpleado(actividades.getListaActividades(),empleado1);
        proyectos.crearListActProyecto(actividades.getListaActividades(), proyectos.getProyecto(2));
    }
}
