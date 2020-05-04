package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Persona;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonaTableModel extends AbstractTableModel {

    private final int COLUMNA_NOMBRE=0;
    private final int COLUMNA_APELLIDO=1;
    private final int COLUMNA_EDAD=2;
    private List<Persona> listaPersonas;
    private String[] nombreColumnas={"Nombre", "Apellido", "Edad"};

    public PersonaTableModel(List<Persona> listaPersonas){
        this.listaPersonas=listaPersonas;
    }

    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ((rowIndex > -1) && (rowIndex < listaPersonas.size())){
            switch(columnIndex){
                case COLUMNA_NOMBRE: return listaPersonas.get(rowIndex).getNombre();
                case COLUMNA_APELLIDO: return listaPersonas.get(rowIndex).getApellido();
                case COLUMNA_EDAD: return listaPersonas.get(rowIndex).getEdad();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case COLUMNA_NOMBRE:
            case COLUMNA_APELLIDO: return String.class;
            case COLUMNA_EDAD: return Integer.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex >= 0) && (rowIndex < listaPersonas.size())){
            if (columnIndex == COLUMNA_NOMBRE) listaPersonas.get(rowIndex).setNombre((String) aValue);
            else if (columnIndex == COLUMNA_APELLIDO) listaPersonas.get(rowIndex).setApellido((String) aValue);
            else if (columnIndex == COLUMNA_EDAD) listaPersonas.get(rowIndex).setEdad((Integer) aValue);
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    public void removeRow(int row){
        if ((row > -1) && (row < listaPersonas.size())){
            int opcionLeidaDeBorrar = JOptionPane.showConfirmDialog(null,"¿Desea borrar la fila?","Borrado",JOptionPane.WARNING_MESSAGE);
            if (opcionLeidaDeBorrar == JOptionPane.OK_OPTION) {
                listaPersonas.remove(row);
                fireTableRowsDeleted(row,row);
            }
        }
    }

    public void addRow(){
        listaPersonas.add(new Persona("","",0));
        fireTableDataChanged();
    }
}
