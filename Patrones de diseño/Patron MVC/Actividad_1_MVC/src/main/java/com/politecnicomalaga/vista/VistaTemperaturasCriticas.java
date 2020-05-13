package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorTemperaturas;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.SensorTemperaturas;
import com.politecnicomalaga.modelo.Temperatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaTemperaturasCriticas implements ConsumidorDeTemperaturas {
    private JList listTemperaturasCriticas;
    private JPanel pnlTemperaturasCriticas;
    private JButton btnIrAListadoDeTemperaturas;
    private JButton btnIrAInsercionDeTemperaturas;
    private DefaultListModel<Temperatura> listModelTemperaturasCriticas;
    private ControladorTemperaturas controladorTemperaturas;

    public VistaTemperaturasCriticas(ControladorTemperaturas controladorTemperaturas) {
        this.controladorTemperaturas=controladorTemperaturas;
        btnIrAInsercionDeTemperaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaInsertarTemperaturas();
            }
        });
        btnIrAListadoDeTemperaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaListadoDeTemperaturas();
            }
        });
    }

    public JPanel getPanel(){
        return pnlTemperaturasCriticas;
    }

    @Override
    public void actualizarTemperatura(List<Temperatura> listaTemperaturas) {
        double temperaturaAComprobarSiCritica=listaTemperaturas.get(listaTemperaturas.size()-1).getTemperatura();
        if (temperaturaAComprobarSiCritica> SensorTemperaturas.LIMITE_TEMPERATURA_CRITICA)
        listModelTemperaturasCriticas.addElement(listaTemperaturas.get(listaTemperaturas.size()-1));
    }

    private void createUIComponents() {
        listTemperaturasCriticas=new JList();
        listModelTemperaturasCriticas =new DefaultListModel<>();
        listTemperaturasCriticas.setModel(listModelTemperaturasCriticas);
    }
}
