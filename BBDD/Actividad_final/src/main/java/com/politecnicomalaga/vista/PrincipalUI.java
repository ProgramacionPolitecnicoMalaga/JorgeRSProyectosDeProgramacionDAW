package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.modelo.Credencial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrincipalUI {
    private JList listIntentos;
    private JButton btnRegistrar;
    private JButton btnBorrar;
    private JButton btnComprobar;
    private JPanel PanelMain;
    private JList listUsuarios;
    private ControladorCredenciales controladorCredenciales;
    private DataTransfer datos;
    private DefaultListModel<DataTransfer> modeloCredencial;
    private CredencialRender credencialRender;

    public PrincipalUI() throws SQLException {
        listUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        controladorCredenciales = new ControladorCredenciales();
        controladorCredenciales.cargarListadoCompletoCredenciales();
        actualizarModeloInterfazNombres(controladorCredenciales.getListadoNombres());

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    datos=new DataTransfer();
                    DialogRegistrar dialogRegistrar = new DialogRegistrar(datos);
                    if(datos.getTreeMapDatos().size()>0) {
                        Credencial credencialSinHash = DataTransferACredencial.transformar(datos);
                        if (!controladorCredenciales.existeNombreUsuario(credencialSinHash.getNombre())) {
                            controladorCredenciales.registrarCredencial(credencialSinHash);
                            actualizarModeloInterfazNombres(controladorCredenciales.getListadoNombres());
                        } else mensajeNombreExistente(e);
                    }
                } catch (SQLException | NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    datos=new DataTransfer();
                    DialogVerificar dialogVerificar = new DialogVerificar(datos);
                    if(datos.getTreeMapDatos().size()>0) {
                        /*
                        Credencial credencialSinHash = DataTransferACredencial.transformar(datos);
                        Credencial credencialConHash = controladorCredenciales.getCredencialPorNombre(credencialSinHash.getNombre());
                        IAlgoritmo algoritmo=GeneradorAlgoritmos.generarAlgoritmo(credencialConHash.getAlgoritmo());
                        boolean verificacion = algoritmo.verifyPassword(credencialSinHash.getHash(), credencialConHash.getHash(), credencialConHash.getSalt());
                        credencialRender.setVerificacion(verificacion);
                        credencialRender.setLblPassword(credencialSinHash.getHash());
                        modeloCredencial.addElement(credencialConHash);

                         */
                        String nombreAComprobar = (String)datos.get("nombre");
                        String passPlana = (String)datos.get("password");
                        Credencial credencialGuardadaAComprobar = controladorCredenciales.getCredencialPorNombre(nombreAComprobar);
                        boolean validado = controladorCredenciales.verificarCredencial(credencialGuardadaAComprobar, passPlana);
                        DataTransfer datosAValidar = controladorCredenciales.crearDataTransferConValidacion(nombreAComprobar, credencialGuardadaAComprobar.getAlgoritmo(), passPlana, credencialGuardadaAComprobar.getHash(), validado);
                        modeloCredencial.addElement(datosAValidar);
                    }
                } catch (SQLException | NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> nombresSeleccionadosABorrar;
                if (!(listUsuarios.getSelectedValuesList().isEmpty())) {
                    int respuestaBorrado = mensajeConfirmacionBorrado(e);
                    if (respuestaBorrado==JOptionPane.OK_OPTION){
                        nombresSeleccionadosABorrar = (ArrayList<String>) listUsuarios.getSelectedValuesList();
                        try {
                            controladorCredenciales.borrarCredencial(nombresSeleccionadosABorrar);
                            actualizarModeloInterfazNombres(controladorCredenciales.getListadoNombres());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else mensajeBorrarSinSeleccion(e);
            }
        });
    }

    public JPanel getPanel(){
        return PanelMain;
    }

    public void actualizarModeloInterfazNombres(ArrayList<String> listaNombreCredenciales) {
        DefaultListModel<String> modeloUsuarios = new DefaultListModel<>();
        for (String nombre : listaNombreCredenciales) {
            modeloUsuarios.addElement(nombre);
        }
        listUsuarios.setModel(modeloUsuarios);
    }

    private void createUIComponents() {
        credencialRender = new CredencialRender();
        listIntentos = new JList();
        modeloCredencial = new DefaultListModel<>();
        listIntentos.setModel(modeloCredencial);
        listIntentos.setCellRenderer(credencialRender);
    }

    public void mensajeNombreExistente (ActionEvent e){
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Nombre ya existente, imposible registrar dicho nombre.");
    }

    public void mensajeBorrarSinSeleccion (ActionEvent e){
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Debe seleccionar un nombre de la lista para poder borrarlo.");
    }

    public int mensajeConfirmacionBorrado (ActionEvent e){
        return JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Está seguro de que desea borrar los usuarios seleccionados?");
    }
}
