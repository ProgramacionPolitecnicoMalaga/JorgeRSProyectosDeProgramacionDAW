package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Principal {
    private JTextArea textAreaBusqueda;
    private JPanel panelMain;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnBorrar;
    private JButton btnInsertar;
    private JTextField txtFieldBusqueda;
    private JTable tableResult;
    private ControladorEmpleados cntrlEmpleados=new ControladorEmpleados();
    private Principal estaVentana;
    private DefaultTableModel modelo;

    public Principal() throws SQLException {

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Modal dialogo = new Modal();
                    String nombre = dialogo.getNombre();
                    actualizarTabla(nombre);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado= new Empleado(getID(), getNombre(), getEdad());
                    Modal dialogo = new Modal(empleado);
                    String nombre = dialogo.getNombre();
                    actualizarTabla(nombre);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizarTabla(txtFieldBusqueda.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] listaIds=new String[tableResult.getRowCount()];
                int[] indicesFilasSeleccionadas=tableResult.getSelectedRows();
                for(int i=0; i<indicesFilasSeleccionadas.length; i++){
                    listaIds[i]=tableResult.getValueAt(indicesFilasSeleccionadas[i], 0).toString();
                }
                try {
                    cntrlEmpleados.eliminar(listaIds);
                    actualizarTabla("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return panelMain;
    }

    private void createUIComponents() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"ID", "Nombre", "Edad"});
        tableResult = new JTable(modelo);
        tableResult.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    public void actualizarTabla(String nombre) throws SQLException {
        ArrayList<Empleado> listaBusquedaEmpleados;
        listaBusquedaEmpleados= cntrlEmpleados.buscarEmpleado(nombre);
        modelo.setRowCount(0);
        for(Empleado empleado: listaBusquedaEmpleados){
            modelo.addRow(new Object[]{empleado.getId(), empleado.getNombre(), empleado.getEdad()});
        }
    }

    public Integer getID(){
        return Integer.parseInt(tableResult.getValueAt(tableResult.getSelectedRow(), 0).toString());
    }

    public String getNombre(){
        return tableResult.getValueAt(tableResult.getSelectedRow(), 1).toString();
    }

    public Integer getEdad(){
        return Integer.parseInt(tableResult.getValueAt(tableResult.getSelectedRow(), 2).toString());
    }
}
