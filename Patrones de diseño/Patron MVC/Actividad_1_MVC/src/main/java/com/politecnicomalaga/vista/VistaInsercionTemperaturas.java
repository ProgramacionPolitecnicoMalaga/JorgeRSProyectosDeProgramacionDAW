package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorTemperaturas;
import com.politecnicomalaga.modelo.SensorTemperaturas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaInsercionTemperaturas {
    private JPanel pnlInsercionTemperaturas;
    private JTextField txtTemperatura;
    private JButton btnInsertarTemperatura;
    private JButton btnIrAListadoDeTemperaturas;
    private JButton btnIrAListadoDeTemperaturasCriticas;
    private JButton btnIrAPromedio;
    private JTextField txtHora;
    private SensorTemperaturas sensorTemperaturas;
    private ControladorTemperaturas controladorTemperaturas;

    public VistaInsercionTemperaturas(SensorTemperaturas sensorTemperaturas, ControladorTemperaturas controladorTemperaturas){
        this.sensorTemperaturas=sensorTemperaturas;
        this.controladorTemperaturas=controladorTemperaturas;
        btnInsertarTemperatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNumeric(txtTemperatura.getText())) {
                    controladorTemperaturas.insertarTemperatura(Double.parseDouble(txtTemperatura.getText()), txtHora.getText());
                }
                txtTemperatura.grabFocus();
                txtTemperatura.setText("");
                txtHora.setText("");
            }
        });
        btnIrAListadoDeTemperaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaListadoDeTemperaturas();
            }
        });
        btnIrAListadoDeTemperaturasCriticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaTemperaturasCriticas();
            }
        });
        btnIrAPromedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorTemperaturas.mostrarVistaTemperaturaPromedio();
            }
        });
    }

    public JPanel getPanel(){
        return pnlInsercionTemperaturas;
    }

    private boolean isNumeric(String cadena){
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
