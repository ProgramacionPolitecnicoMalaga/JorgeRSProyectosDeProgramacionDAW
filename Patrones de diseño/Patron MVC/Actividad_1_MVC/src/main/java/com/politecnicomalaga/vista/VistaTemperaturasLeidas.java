package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorTemperaturas;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.Temperatura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaTemperaturasLeidas  implements ConsumidorDeTemperaturas {
    private JPanel pnlTemperaturasLeidas;
    private JList listTemperaturasLeidas;
    private JButton btnIrAInsercion;
    private DefaultListModel<Temperatura> listModelTemperaturasLeidas;
    private ControladorTemperaturas controladorTemperaturas;

    public VistaTemperaturasLeidas(ControladorTemperaturas controladorTemperaturas) {
        this.controladorTemperaturas=controladorTemperaturas;
        btnIrAInsercion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaInsertarTemperaturas();
            }
        });
    }

    public JPanel getPanel(){
        return pnlTemperaturasLeidas;
    }

    @Override
    public void actualizarTemperatura(List<Temperatura> listaTemperaturas) {
        listModelTemperaturasLeidas.addElement(listaTemperaturas.get(listaTemperaturas.size()-1));
    }

    private void createUIComponents() {
        listTemperaturasLeidas=new JList();
        listModelTemperaturasLeidas=new DefaultListModel();
        listTemperaturasLeidas.setModel(listModelTemperaturasLeidas);
    }
}
