package com.politecnicomalaga.controlador;

import com.politecnicomalaga.configuracion.Propiedades;
import com.politecnicomalaga.dao.MensajesDAO;
import com.politecnicomalaga.modelo.Mensaje;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControladorMensajes {

    private MensajesDAO mensajesDAO;
    private Propiedades propiedades;

    public ControladorMensajes(Propiedades propiedades) throws SQLException, IOException {
        mensajesDAO = new MensajesDAO();
        this.propiedades = propiedades;
    }

    public ArrayList generarListaMensajesDeUsuarioLogueado() throws SQLException {
        ResultSet resultSetMensajes=mensajesDAO.obtenerResultSetMensajesBD(propiedades.getPropiedad("Usuario"));
        ArrayList<Mensaje> listadoMensajesDeUsuarioLogueado=new ArrayList<>();
        while (resultSetMensajes.next()) {
            Mensaje mensaje = new Mensaje(resultSetMensajes.getString("titulo"), resultSetMensajes.getString("texto"),
                    resultSetMensajes.getString("id_destinatario"), resultSetMensajes.getString("nombre_remitente"),
                    resultSetMensajes.getString("fecha_envio_mensaje"));
            String textoFormateado = "<html>" + mensaje.getTexto().replaceAll("\n", "<br />") + "</html>";
            mensaje.setTexto(textoFormateado);
            listadoMensajesDeUsuarioLogueado.add(mensaje);
        }
        resultSetMensajes.beforeFirst();
        return listadoMensajesDeUsuarioLogueado;
    }

    public void enviarMensaje(String tituloDelMensaje, String textoDelMensaje, String idDestinatario) throws SQLException {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fechaMensaje = dia + "/" + mes + "/" + año;
        mensajesDAO.insertarMensaje(new Mensaje(tituloDelMensaje, textoDelMensaje, idDestinatario, propiedades.getPropiedad("Usuario"), fechaMensaje));
    }
}
