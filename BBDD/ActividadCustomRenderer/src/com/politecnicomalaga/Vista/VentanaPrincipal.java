package com.politecnicomalaga.Vista;

import com.politecnicomalaga.Controlador.ControladorItem;
import com.politecnicomalaga.Modelo.Item;
import com.politecnicomalaga.Modelo.Tipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaPrincipal {
    private JPanel pnlMain;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JList lstItems;
    private JButton btnBuscar;
    private JTextField txtBusqueda;
    private ControladorItem controladorItem;
    private HashMap<Integer, Item> listaItems;
    static final Tipo tipoIT = new Tipo(Tipo.IT);
    static final Tipo tipoDesarrollo = new Tipo(Tipo.DESARROLLO);
    static final Tipo tipoMantenimiento = new Tipo(Tipo.MANTENIMIENTO);
    static final Tipo tipoGeneral = new Tipo(Tipo.GENERAL);


    public VentanaPrincipal() throws SQLException {
        controladorItem = new ControladorItem();
        listaItems = new HashMap<>();
        DefaultListModel<Item> lstModel = new DefaultListModel<>();
        lstItems.setModel(lstModel);
        lstItems.setCellRenderer(new ItemPanel());
        lstItems.setFixedCellWidth(pnlMain.getWidth());

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modalDialog dialogo = new modalDialog();
                Item item = dialogo.getNuevoItem();
                if (item!=null) {
                    try {
                        controladorItem.crearItem(item.getAutor(), item.getFecha(), item.getTexto(), item.getTipo().getId());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    lstModel.addElement(item);
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lstModel.removeAllElements();
                    ArrayList<Item> listaResultadoItems = controladorItem.buscarItem(txtBusqueda.getText());
                    for(Item item : listaResultadoItems){
                        lstModel.addElement(item);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item;
                try {
                    ArrayList<Item> listItemTemp = controladorItem.buscarItem("");
                    for (int i=0; i<listItemTemp.size(); i++){
                        listaItems.put(i, listItemTemp.get(i));
                    }
                    item = listaItems.get(lstItems.getSelectedIndex());
                    controladorItem.eliminar(item.getAutor(), item.getFecha(), item.getTexto(), item.getTipo().getId());
                    lstModel.removeElementAt(lstItems.getSelectedIndex());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        lstItems.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Estiramos la celda a 1000 px de altura
                lstItems.setFixedCellHeight(1000);
                // Asignamos el valor -1 para que se recalcule la altura
                lstItems.setFixedCellHeight(-1);
            }
        });
    }

    public JPanel getPanel() {
        return pnlMain;
    }

    //fuente:https://coderanch.com/t/335943/java/Changing-background-color-JList
    private static class TipoCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            switch (((Item)value).getTipo().getId()){
                case Tipo.IT: c.setBackground( Color.green );
                    break;
                case Tipo.DESARROLLO: c.setBackground( Color.blue );
                    break;
                case Tipo.MANTENIMIENTO: c.setBackground( Color.orange );
                    break;
                case Tipo.GENERAL: c.setBackground( Color.gray );
                    break;
            }
            return c;
        }
    }
}
