package com.politecnicomalaga.controlador;

import com.politecnicomalaga.DAO.CredencialesDAO;
import com.politecnicomalaga.algoritmos.GeneradorAlgoritmos;
import com.politecnicomalaga.algoritmos.IAlgoritmo;
import com.politecnicomalaga.modelo.Credencial;
import com.politecnicomalaga.modelo.ListaCredenciales;
import com.politecnicomalaga.vista.DataTransfer;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ControladorCredenciales {

    CredencialesDAO credencialesDAO;
    IAlgoritmo algoritmo;
    ListaCredenciales listaCredenciales;

    public ControladorCredenciales() throws SQLException {
        credencialesDAO = new CredencialesDAO();
        listaCredenciales = new ListaCredenciales();
    }

    public void cargarListadoCompletoCredenciales() throws SQLException {
        ResultSet rs = credencialesDAO.obtenerResultSetCredencialesBD();
        while (rs.next()){
            Credencial credencial = new Credencial(rs.getString("nombre"), Integer.parseInt(rs.getString("algoritmo")), rs.getString("hash"), rs.getString("salt"));
            listaCredenciales.addCredencial(credencial);
        }
    }

    public void registrarCredencial (Credencial credencialSinHash) throws NoSuchAlgorithmException, SQLException {
        algoritmo = GeneradorAlgoritmos.generarAlgoritmo(credencialSinHash.getAlgoritmo());
        String salt = algoritmo.getSalt();
        String hash = algoritmo.getPasswordHash(credencialSinHash.getHash(), salt);
        Credencial credencial = new Credencial(credencialSinHash.getNombre(), credencialSinHash.getAlgoritmo(), hash, salt);
        listaCredenciales.addCredencial(credencial);
        credencialesDAO.registrarCredencial(credencial);
    }

    public void borrarCredencial (ArrayList<String> listaNombresABorrar) throws SQLException {
        Credencial credencial;
        for (String nombre: listaNombresABorrar){
            credencial=getCredencialPorNombre(nombre);
            if (credencial!=null &&credencial.getNombre().equals(nombre)){
                credencialesDAO.eliminarCredencial(credencial);
                borrarCredencialDeListaPorNombre(credencial.getNombre());
            }
        }
    }

    public boolean existeNombreUsuario(String nombre) {
        boolean existe=false;
        for (Credencial credencial: listaCredenciales.getListadoCredenciales()){
            if (listaCredenciales.getListadoCredenciales().size()==0){
                existe=false;
            } else if (listaCredenciales.getListadoCredenciales().size()>0 && !(credencial.getNombre().equals(nombre))) {
                existe=false;
            } else
                existe=true;
        }
        return existe;
    }

    public Credencial getCredencialPorNombre (String nombre){
        Credencial credencial;
        Iterator<Credencial> iterator = listaCredenciales.getListadoCredenciales().iterator();
        while (iterator.hasNext()){
            credencial = iterator.next();
            if (credencial.getNombre().equals(nombre)){
                return credencial;
            }
        }
        return null;
    }

    public void borrarCredencialDeListaPorNombre (String nombre){
        ArrayList<Credencial> listaTemporal = listaCredenciales.getListadoCredenciales();
        for (int i=0; i<listaTemporal.size(); i++){
            Credencial credencial=listaTemporal.get(i);
            if(credencial.getNombre()==nombre){
                listaCredenciales.getListadoCredenciales().remove(i);
            }
        }
    }

    public ArrayList<String> getListadoNombres (){
        ArrayList<String> listaNombres = new ArrayList<>();
        for (Credencial credencial:listaCredenciales.getListadoCredenciales()){
            listaNombres.add(credencial.getNombre());
        }
        return listaNombres;
    }
    
    public DataTransfer crearDataTransferConValidacion (String nombreAComprobar, int tipoAlgoritmo, String passwordPlana, String passwordHashed, boolean validado){
        DataTransfer dataTransfer = new DataTransfer();
        dataTransfer.put("nombre", nombreAComprobar);
        dataTransfer.put("algoritmo", tipoAlgoritmo);
        dataTransfer.put("passwordPlana", passwordPlana);
        dataTransfer.put("passwordHashed", passwordHashed);
        dataTransfer.put("validado", validado);
        return dataTransfer;
    }

    public boolean verificarCredencial (Credencial credencial, String passwordPlana) throws NoSuchAlgorithmException {
        IAlgoritmo algoritmo = GeneradorAlgoritmos.generarAlgoritmo(credencial.getAlgoritmo());
        return algoritmo.verifyPassword(passwordPlana, credencial.getHash(), credencial.getSalt());
    }
}
