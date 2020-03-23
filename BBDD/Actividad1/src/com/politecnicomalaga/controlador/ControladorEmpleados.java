package com.politecnicomalaga.controlador;

import com.politecnicomalaga.DAO.EmpleadoDAO;
import com.politecnicomalaga.modelo.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEmpleados {

    EmpleadoDAO empleadoDAO;

    public ControladorEmpleados() throws SQLException {
        empleadoDAO = new EmpleadoDAO();
    }

    public void eliminar(String[] idEmpleados) throws SQLException {
        for (String id : idEmpleados) {
            empleadoDAO.eliminarEmpleado(id);
        }
    }

    public void modificarEmpleado(String id, String nombre, String edad) throws SQLException {
        empleadoDAO.editarDatosEmpleado(id, nombre, edad);
    }

    public void crearEmpleado(String nombre, String edad) throws SQLException {
        empleadoDAO.registrarEmpleado(nombre, edad);
    }

    public ArrayList<Empleado> buscarEmpleado (String cadenaABuscar) throws SQLException {
        ArrayList<Empleado> listadoEmpleadoFiltrado;
        if (cadenaABuscar.equals("")){
            listadoEmpleadoFiltrado=empleadoDAO.obtenerListadoCompletoEmpleados();
        } else {
            listadoEmpleadoFiltrado=empleadoDAO.obtenerEmpleadosPorPatron(cadenaABuscar);
        }
        return listadoEmpleadoFiltrado;
    }
}
