package com.politecnicomalaga.DAO;

import com.politecnicomalaga.DAO.DBConn;
import com.politecnicomalaga.Modelo.Item;
import com.politecnicomalaga.Modelo.Tipo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ItemDAO {

    DBConn dbConn;

    public ItemDAO() throws SQLException {
        dbConn = DBConn.getInstance();
    }

    public void registrarItem(String autor, LocalDate fecha, String comentario, int tipo) throws SQLException {
        dbConn.update("INSERT INTO Item(autor, fecha, comentario, tipo) VALUES('"+ autor +"','" + fecha +"','"+ comentario +"','"+ tipo +"')");
    }

    public void eliminarItem(String autor, LocalDate fecha, String comentario, int tipo) throws SQLException {
        dbConn.update("DELETE FROM Item WHERE autor = '" + autor +"' && fecha = '" + fecha +"' && comentario = '"+ comentario +"' && tipo = '"+ tipo +"'");
    }

    public ArrayList<Item> obtenerListadoCompletoItems() throws SQLException {
        ResultSet rs = dbConn.read("SELECT * FROM Item");
        return obtenerListado(rs);
    }

    public ArrayList<Item> obtenerItemsPorPatron(String patron) throws SQLException {
        ResultSet rs = dbConn.read("SELECT * FROM Item WHERE autor LIKE '%" + patron + "%'");
        return obtenerListado(rs);
    }

    public ArrayList<Item> obtenerListado (ResultSet rs) throws SQLException {
        ArrayList<Item> listaEmpleados = new ArrayList<>();
        while (rs.next()){
            Item item = new Item(new Tipo(rs.getInt("tipo")), rs.getString("autor"), LocalDate.parse(rs.getString("fecha")), rs.getString("comentario"));
            item.getTipo().setTipoPorId(rs.getInt("tipo"));
            listaEmpleados.add(item);
        }
        return listaEmpleados;
    }
}
