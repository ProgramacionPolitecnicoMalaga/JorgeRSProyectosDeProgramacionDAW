package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorTemperaturas;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.CalcularPromedioDeTemperaturas;
import com.politecnicomalaga.modelo.Temperatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaPromedioTemperaturas implements ConsumidorDeTemperaturas {
    private JPanel pnlPromedioTemperaturas;
    private JTextField txtPromedioTemperaturas;
    private JButton btnIrAListadoDeTemperaturas;
    private JButton btnIrAInsercion;
    private ControladorTemperaturas controladorTemperaturas;

    public VistaPromedioTemperaturas(ControladorTemperaturas controladorTemperaturas) {
        this.controladorTemperaturas=controladorTemperaturas;
        txtPromedioTemperaturas.setEditable(false);
        btnIrAInsercion.addActionListener(new ActionListener() {
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
        return pnlPromedioTemperaturas;
    }

    @Override
    public void actualizarTemperatura(List<Temperatura> listaTemperaturas) {
        txtPromedioTemperaturas.setText(String.valueOf(CalcularPromedioDeTemperaturas.calcularPromedioDeTemperaturas(listaTemperaturas)));
    }
}
