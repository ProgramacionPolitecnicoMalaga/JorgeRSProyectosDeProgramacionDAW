package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajes;
import com.politecnicomalaga.modelo.Mensaje;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class PanelLecturaMensajes {
    private JPanel pnlLectura;
    private JList listMensajes;
    private JTable tblRemitentes;
    private Multipanel panelPrincipal;
    private ControladorMensajes controladorMensajes;
    private MensajeRender mensajeRender;
    private DefaultListModel<Mensaje> modeloListaDeMensajes;
    private DefaultTableModel modeloTablaMensajes;
    private final String [] nombresColumnas = {"Nombre", "Fecha"};
    private ArrayList<Mensaje> listaMensajesDeUsuarioLogueado;


    public PanelLecturaMensajes(Multipanel panelPrincipal, ControladorMensajes controladorMensajes) throws SQLException {
        this.panelPrincipal=panelPrincipal;
        this.controladorMensajes=controladorMensajes;
        pnlLectura.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                modeloListaDeMensajes.clear();
                modeloTablaMensajes.setRowCount(0);
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });

        pnlLectura.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                modeloTablaMensajes=new DefaultTableModel();
                modeloTablaMensajes.setColumnIdentifiers(nombresColumnas);
                tblRemitentes.setModel(modeloTablaMensajes);
                try {
                    listaMensajesDeUsuarioLogueado = controladorMensajes.generarListaMensajesDeUsuarioLogueado();
                    for(int i=0; i<listaMensajesDeUsuarioLogueado.size();i++){
                        Mensaje mensaje = listaMensajesDeUsuarioLogueado.get(i);
                        String [] mensajeEnFormatoParaTabla={mensaje.getNombreRemitente(), mensaje.getFechaEnvioMensaje()};
                        modeloTablaMensajes.addRow(mensajeEnFormatoParaTabla);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        tblRemitentes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int posicionMensaje = tblRemitentes.getSelectedRow();
                modeloListaDeMensajes.clear();
                modeloListaDeMensajes.addElement(listaMensajesDeUsuarioLogueado.get(posicionMensaje));
            }
        });
    }

    public JPanel getPanel(){
        return pnlLectura;
    }

    private void createUIComponents() {
        mensajeRender = new MensajeRender();
        listMensajes = new JList();
        modeloListaDeMensajes = new DefaultListModel<>();
        listMensajes.setModel(modeloListaDeMensajes);
        listMensajes.setCellRenderer(mensajeRender);
        listMensajes.setBackground(UIManager.getColor("Panel.background"));
        listMensajes.setBorder(BorderFactory.createLineBorder(UIManager.getColor("ScrollPane.border")));
    }
}
