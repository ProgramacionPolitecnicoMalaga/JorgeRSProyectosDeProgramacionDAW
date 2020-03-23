package com.politecnicomalaga.Controlador;

import com.politecnicomalaga.DAO.ItemDAO;
import com.politecnicomalaga.Modelo.Item;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorItem {

    ItemDAO itemDAO;

    public ControladorItem() throws SQLException {
        itemDAO = new ItemDAO();
    }

    public void eliminar(String autor, LocalDate fecha, String comentario, int tipo) throws SQLException {
        itemDAO.eliminarItem(autor, fecha, comentario, tipo);
    }

    public void crearItem(String autor, LocalDate fecha, String comentario, int tipo) throws SQLException {
        itemDAO.registrarItem(autor, fecha, comentario, tipo);
    }

    public ArrayList<Item> buscarItem (String cadenaABuscar) throws SQLException {
        ArrayList<Item> listadoEmpleadoFiltrado;
        if (cadenaABuscar.equals("")){
            listadoEmpleadoFiltrado=itemDAO.obtenerListadoCompletoItems();
        } else {
            listadoEmpleadoFiltrado=itemDAO.obtenerItemsPorPatron(cadenaABuscar);
        }
        return listadoEmpleadoFiltrado;
    }
}
