package com.politecnicomalaga.dao;

import com.politecnicomalaga.DAO.DBConn;
import com.politecnicomalaga.modelo.Credencial;
import com.politecnicomalaga.modelo.Mensaje;
import com.politecnicomalaga.modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    DBConn dbConn;

    public MensajesDAO() throws SQLException {
        dbConn = DBConn.getInstance();
    }

    public void insertarMensaje(Mensaje mensaje) throws SQLException {
        dbConn.update("INSERT INTO Mensajes (titulo, texto, id_destinatario, nombre_remitente, fecha_envio_mensaje) " +
                "VALUES('"+ mensaje.getTitulo() + "','" + mensaje.getTexto() + "','" + mensaje.getIdDestinatario() +
                "','" + mensaje.getNombreRemitente() + "','" + mensaje.getFechaEnvioMensaje() + "')");
    }

    public ResultSet obtenerResultSetMensajesBD(String nombreUsuarioLogueado) throws SQLException {
        ResultSet rs = dbConn.read("SELECT * FROM Mensajes m JOIN Credenciales c ON m.id_destinatario=c.id WHERE c.nombre = '" + nombreUsuarioLogueado + "'");
        return rs;
    }
}
