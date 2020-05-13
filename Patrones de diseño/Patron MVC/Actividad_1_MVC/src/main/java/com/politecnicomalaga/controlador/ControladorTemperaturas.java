package com.politecnicomalaga.controlador;

import com.politecnicomalaga.modelo.SensorTemperaturas;
import com.politecnicomalaga.vista.VistaInsercionTemperaturas;
import com.politecnicomalaga.vista.VistaPromedioTemperaturas;
import com.politecnicomalaga.vista.VistaTemperaturasCriticas;
import com.politecnicomalaga.vista.VistaTemperaturasLeidas;

import javax.swing.*;
import java.awt.*;

public class ControladorTemperaturas {

    private SensorTemperaturas sensorTemperaturas;
    private JFrame frameInsertarTemperaturas;
    private JFrame framePromedioTemperaturas;
    private JFrame frameTemperaturasCriticas;
    private JFrame frameTemperaturasLeidas;

    public ControladorTemperaturas(SensorTemperaturas sensorTemperaturas){
        this.sensorTemperaturas=sensorTemperaturas;
        VistaInsercionTemperaturas vistaInsercionTemperaturas = new VistaInsercionTemperaturas(sensorTemperaturas, this);
        VistaPromedioTemperaturas vistaPromedioTemperaturas = new VistaPromedioTemperaturas(this);
        VistaTemperaturasCriticas vistaTemperaturasCriticas = new VistaTemperaturasCriticas(this);
        VistaTemperaturasLeidas vistaTemperaturasLeidas = new VistaTemperaturasLeidas(this);

        sensorTemperaturas.registrarConsumidor(vistaTemperaturasLeidas);
        sensorTemperaturas.registrarConsumidor(vistaPromedioTemperaturas);
        sensorTemperaturas.registrarConsumidor(vistaTemperaturasCriticas);

        frameInsertarTemperaturas = new JFrame("Insertar temperaturas");
        frameInsertarTemperaturas.setContentPane(vistaInsercionTemperaturas.getPanel());
        frameInsertarTemperaturas.setPreferredSize(new Dimension(500, 500));
        frameInsertarTemperaturas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInsertarTemperaturas.pack();
        frameInsertarTemperaturas.setLocationRelativeTo(null);//0,height/4);
        frameInsertarTemperaturas.setVisible(true);
        frameInsertarTemperaturas.setResizable(false);
        framePromedioTemperaturas = new JFrame("Promedio de temperaturas");
        framePromedioTemperaturas.setContentPane(vistaPromedioTemperaturas.getPanel());
        framePromedioTemperaturas.setPreferredSize(new Dimension(500, 500));
        framePromedioTemperaturas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePromedioTemperaturas.pack();
        framePromedioTemperaturas.setLocationRelativeTo(null);//0,height/4);
        framePromedioTemperaturas.setVisible(false);
        framePromedioTemperaturas.setResizable(false);
        frameTemperaturasCriticas = new JFrame("Listado de temperaturas críticas");
        frameTemperaturasCriticas.setContentPane(vistaTemperaturasCriticas.getPanel());
        frameTemperaturasCriticas.setPreferredSize(new Dimension(500, 500));
        frameTemperaturasCriticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTemperaturasCriticas.pack();
        frameTemperaturasCriticas.setLocationRelativeTo(null);//0,height/4);
        frameTemperaturasCriticas.setVisible(false);
        frameTemperaturasCriticas.setResizable(false);
        frameTemperaturasLeidas = new JFrame("Listado de temperaturas leídas");
        frameTemperaturasLeidas.setContentPane(vistaTemperaturasLeidas.getPanel());
        frameTemperaturasLeidas.setPreferredSize(new Dimension(500, 500));
        frameTemperaturasLeidas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTemperaturasLeidas.pack();
        frameTemperaturasLeidas.setLocationRelativeTo(null);//0,height/4);
        frameTemperaturasLeidas.setVisible(false);
        frameTemperaturasLeidas.setResizable(false);
    }

    public void insertarTemperatura(double temperatura, String hora){
        sensorTemperaturas.addTemperatura(temperatura, hora);
        frameInsertarTemperaturas.setVisible(false);
        frameTemperaturasLeidas.setVisible(true);
    }

    public void mostrarVistaListadoDeTemperaturas(){
        frameInsertarTemperaturas.setVisible(false);
        framePromedioTemperaturas.setVisible(false);
        frameTemperaturasCriticas.setVisible(false);
        frameTemperaturasLeidas.setVisible(true);
    }

    public void mostrarVistaTemperaturaPromedio(){
        frameInsertarTemperaturas.setVisible(false);
        framePromedioTemperaturas.setVisible(true);
        frameTemperaturasCriticas.setVisible(false);
        frameTemperaturasLeidas.setVisible(false);
    }

    public void mostrarVistaTemperaturasCriticas(){
        frameInsertarTemperaturas.setVisible(false);
        framePromedioTemperaturas.setVisible(false);
        frameTemperaturasCriticas.setVisible(true);
        frameTemperaturasLeidas.setVisible(false);
    }

    public void mostrarVistaInsertarTemperaturas(){
        frameInsertarTemperaturas.setVisible(true);
        framePromedioTemperaturas.setVisible(false);
        frameTemperaturasCriticas.setVisible(false);
        frameTemperaturasLeidas.setVisible(false);
    }
}
