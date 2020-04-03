package com.politecnicomalaga.DAO;

import com.politecnicomalaga.modelo.Credencial;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CredencialesDAO {
    DBConn dbConn;

    public CredencialesDAO() throws SQLException {
        dbConn = DBConn.getInstance();
    }

    public void registrarCredencial(Credencial credencial) throws SQLException {
        dbConn.update("INSERT INTO Credenciales (nombre, algoritmo, hash, salt) " +
                                "VALUES('"+ credencial.getNombre() +"','" + credencial.getAlgoritmo() +"','" +
                                credencial.getHash() +"','" + credencial.getSalt() +"')");
    }

    public void eliminarCredencial(Credencial credencial) throws SQLException {
        dbConn.update("DELETE FROM Credenciales WHERE nombre = '" + credencial.getNombre() +"'");
    }

    public ResultSet obtenerResultSetCredencialesBD() throws SQLException {
        ResultSet rs = dbConn.read("SELECT * FROM Credenciales");
        return rs;
    }
}
