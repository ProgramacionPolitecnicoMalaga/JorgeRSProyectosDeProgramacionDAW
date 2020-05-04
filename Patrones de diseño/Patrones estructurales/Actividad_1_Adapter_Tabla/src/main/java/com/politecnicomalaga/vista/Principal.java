package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Principal {
    private JPanel pnlPrincipal;
    private JTable tblPersona;
    private JButton btnBorrar;
    private JButton btnPrintTablaPantalla;
    private JButton btnInsertar;
    private List<Persona> listaPersonas;
    private PersonaTableModel personaTableModel;

    public Principal(List<Persona> listaPersonas){
        this.listaPersonas=listaPersonas;
        personaTableModel=new PersonaTableModel(listaPersonas);
        tblPersona.setModel(personaTableModel);

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personaTableModel.addRow();
            }
        });
        btnPrintTablaPantalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(listaPersonas);
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personaTableModel.removeRow(tblPersona.getSelectedRow());
            }
        });
    }

    public JPanel getPanel(){
        return pnlPrincipal;
    }
}
