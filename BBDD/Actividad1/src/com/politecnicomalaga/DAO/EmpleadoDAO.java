package com.politecnicomalaga.DAO;

import com.politecnicomalaga.modelo.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    DBConn dbConn;

    public EmpleadoDAO() throws SQLException {
        dbConn = DBConn.getInstance();
    }

    public void registrarEmpleado(String nombre, String edad) throws SQLException {
        dbConn.update("INSERT INTO Empleado(nombre, edad) VALUES('"+ nombre +"','" + edad +"')");
    }

    public void editarDatosEmpleado(String id, String nombre, String edad) throws SQLException {
        dbConn.update("UPDATE Empleado SET nombre ='" + nombre + "', edad = '" + edad + "' WHERE id =" + id);
    }

    public void eliminarEmpleado(String id) throws SQLException {
        dbConn.update("DELETE FROM Empleado WHERE ID = " + id);
    }

    public ArrayList<Empleado> obtenerListadoCompletoEmpleados() throws SQLException {
        ResultSet rs = dbConn.read("SELECT * FROM Empleado");
        return obtenerListado(rs);
    }

    public ArrayList<Empleado> obtenerEmpleadosPorPatron(String patron) throws SQLException {
        ResultSet rs = null;
        if (isNumeric(patron)){
            rs = dbConn.read("SELECT * FROM Empleado WHERE id LIKE '%" + patron + "%'");
        } else {
            rs = dbConn.read("SELECT * FROM Empleado WHERE nombre LIKE '%" + patron + "%'");
        }
        return obtenerListado(rs);
    }

    public ArrayList<Empleado> obtenerListado (ResultSet rs) throws SQLException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        while (rs.next()){
            Empleado empleado = new Empleado(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), Integer.parseInt(rs.getString("edad")));
            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }

    public boolean isNumeric (String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
