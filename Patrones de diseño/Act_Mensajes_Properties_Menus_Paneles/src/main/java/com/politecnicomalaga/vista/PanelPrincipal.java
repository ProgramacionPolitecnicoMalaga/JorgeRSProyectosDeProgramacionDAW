package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajes;
import com.politecnicomalaga.controlador.ControladorUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PanelPrincipal implements Multipanel{
    private JPanel pnlPrincipal;
    private JPanel pnlIntercambio;
    private JMenu menuAcciones;
    private JMenuItem menuItLeer;
    private JMenuItem menuItEscribir;
    private JMenuItem menuItCerrar;
    private ControladorUsuarios controladorUsuarios;
    private ControladorMensajes controladorMensajes;

    public PanelPrincipal() throws SQLException, IOException {
        controladorUsuarios = new ControladorUsuarios();
        controladorMensajes = new ControladorMensajes(controladorUsuarios.getPropiedades());
        PanelLogin panelLogin = new PanelLogin(this, controladorUsuarios);
        PanelLecturaMensajes panelLecturaMensajes = new PanelLecturaMensajes(this, controladorMensajes);
        PanelEscrituraMensajes panelEscrituraMensajes = new PanelEscrituraMensajes(this, controladorUsuarios, controladorMensajes);
        pnlIntercambio.add(panelLogin.getPanel(), "login");
        pnlIntercambio.add(panelLecturaMensajes.getPanel(), "lectura");
        pnlIntercambio.add(panelEscrituraMensajes.getPanel(), "escritura");

        notificarCambioPanel(controlDeSesionAlIniciarPrograma());

        menuItLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambioPanel(Multipanel.PANEL_LECTURA);
            }
        });

        menuItEscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambioPanel(Multipanel.PANEL_ESCRITURA);
            }
        });

        menuItCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int respuestaCierreSesion = mensajeConfirmacionCierreSesion(e);
                    if (respuestaCierreSesion==JOptionPane.OK_OPTION){
                        controladorUsuarios.borrarSesionIniciada();
                        notificarCambioPanel(Multipanel.PANEL_LOGIN);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){
        return pnlPrincipal;
    }

    @Override
    public void notificarCambioPanel(int cambio) {
        CardLayout cardLayout = (CardLayout) pnlIntercambio.getLayout();
        switch (cambio){
            case Multipanel.PANEL_LOGIN:
                cardLayout.show(pnlIntercambio, "login");
                menuAcciones.setVisible(false);
                break;
            case Multipanel.PANEL_LECTURA:
                cardLayout.show(pnlIntercambio, "lectura");
                menuAcciones.setVisible(true);
                break;
            case Multipanel.PANEL_ESCRITURA:
                cardLayout.show(pnlIntercambio, "escritura");
                break;
        }
    }

    public int controlDeSesionAlIniciarPrograma(){
        if(controladorUsuarios.haySesionIniciada()){
            return Multipanel.PANEL_LECTURA;
        } else
            return Multipanel.PANEL_LOGIN;
    }

    public int mensajeConfirmacionCierreSesion (ActionEvent e){
        return JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Está seguro de que desea cerrar sesión?");
    }
}
