package com.politecnicomalaga.controlador;

import com.politecnicomalaga.DAO.CredencialesDAO;
import com.politecnicomalaga.algoritmos.GeneradorAlgoritmos;
import com.politecnicomalaga.algoritmos.IAlgoritmo;
import com.politecnicomalaga.configuracion.Propiedades;
import com.politecnicomalaga.modelo.Usuario;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorUsuarios {

    CredencialesDAO credencialesDAO;
    ResultSet resultSet;
    Propiedades propiedades;

    public ControladorUsuarios(Propiedades propiedades) throws SQLException, IOException {
        credencialesDAO = new CredencialesDAO();
        resultSet = credencialesDAO.obtenerResultSetCredencialesBD();
        this.propiedades=propiedades;
    }

    public ArrayList generarListadoRemitentes() throws SQLException {
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        while (resultSet.next()){
            Usuario usuario=new Usuario(resultSet.getString("id"), resultSet.getString("nombre"));
            if (!usuario.getNombre().equals(propiedades.getPropiedad("Usuario")))
                listaUsuarios.add(usuario);
        }
        resultSet.beforeFirst();
        return listaUsuarios;
    }

    public String login (String nombreLeidoUsuario, String password) throws SQLException, NoSuchAlgorithmException {
        String nombreUsuarioCorrecto=null;
        while (resultSet.next()){
            if (resultSet.getString("nombre").equals(nombreLeidoUsuario)){
                IAlgoritmo algoritmo = GeneradorAlgoritmos.generarAlgoritmo(Integer.parseInt(resultSet.getString("algoritmo")));
                if(algoritmo.verifyPassword(password, resultSet.getString("hash"), resultSet.getString("salt"))){
                    nombreUsuarioCorrecto=resultSet.getString("nombre");
                }
            }
        }
        resultSet.beforeFirst();
        return nombreUsuarioCorrecto;
    }

    public void setSesionEnPropiedades(String nombreUsuarioLogueado) throws IOException {
        propiedades.setPropiedad("Usuario", nombreUsuarioLogueado);
        propiedades.guardar();
    }

    public boolean haySesionIniciada(){
        boolean sesionIniciada=false;
        if (propiedades.getPropiedad("Usuario") != null){
            sesionIniciada=true;
        }
        return sesionIniciada;
    }

    public void borrarSesionIniciada() throws IOException {
        propiedades.borrar("Usuario");
        propiedades.guardar();
    }

    public String getIdDeDestinatarioPorNombre(String nombreDestinatario) throws SQLException {
        String idDestinatario="";
        for (Usuario usuario:(ArrayList<Usuario>)generarListadoRemitentes()){
            if (usuario.getNombre().equals(nombreDestinatario)){
                idDestinatario=usuario.getId();
            }
        }
        return idDestinatario;
    }

    /*public Propiedades getPropiedades(){
        return propiedades;
    }

     */
}
