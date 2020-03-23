package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.modelo.Empleado;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Modal extends JDialog{
    private JPanel panelModal;
    private JTextField txtFieldID;
    private JTextField textFieldNombre;
    private JTextField textFieldEdad;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JButton btnCancelar;
    private JButton btnAceptar;
    private ControladorEmpleados cntrlEmpleados = new ControladorEmpleados();

    public Modal(Empleado empleado) throws SQLException {

        setContentPane(panelModal);
        setModal(true);
        getRootPane().setDefaultButton(btnAceptar);
        txtFieldID.isDisplayable();
        txtFieldID.setText(empleado.getId().toString());
        textFieldNombre.setText(empleado.getNombre());
        textFieldEdad.setText(empleado.getEdad().toString());

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOKModificar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelModal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public Modal() throws SQLException {

        setContentPane(panelModal);
        setModal(true);
        getRootPane().setDefaultButton(btnAceptar);
        txtFieldID.setEnabled(false);
        txtFieldID.setText("");
        textFieldNombre.setText("");
        textFieldEdad.setText("");

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOKInsertar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelModal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOKInsertar() throws SQLException {
        // add your code here
        cntrlEmpleados.crearEmpleado(textFieldNombre.getText(),textFieldEdad.getText());
        dispose();
    }

    private void onOKModificar() throws SQLException {
        cntrlEmpleados.modificarEmpleado(txtFieldID.getText(), textFieldNombre.getText(), textFieldEdad.getText());
        dispose();
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String getNombre(){
        pack();
        setVisible(true);  // Bloqueo la ventana
        dispose();
        return textFieldNombre.getText();
    }

}
