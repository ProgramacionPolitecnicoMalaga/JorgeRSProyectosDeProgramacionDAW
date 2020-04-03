package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DialogRegistrar extends JDialog{
    private JPanel DialogRegistrar;
    private JTextField txtNombre;
    private JPasswordField passwPassword;
    private JComboBox cbAlgoritmos;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JLabel lblPassword;
    private JLabel lblNombre;
    private JLabel lblAlgoritmos;
    private DataTransfer datos;

    public DialogRegistrar(DataTransfer datos) throws SQLException {
        super.setLocationRelativeTo(null);
        this.datos=datos;
        setContentPane(DialogRegistrar);
        setModal(true);
        getRootPane().setDefaultButton(btnRegistrar);
        txtNombre.setText("");
        passwPassword.setText("");

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK(e);
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
        DialogRegistrar.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
        setVisible(true);  // Bloqueo la ventana
        dispose();
    }

    private void onOK(ActionEvent e) throws SQLException {
        if (!(txtNombre.getText().isEmpty() &&passwPassword.getPassword().length==0)) {
            datos.put("nombre", txtNombre.getText());
            datos.put("algoritmo", cbAlgoritmos.getSelectedIndex());
            datos.put("password", new String(passwPassword.getPassword()));
            dispose();
        } else mensajeCamposRegistrarVacios(e);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        cbAlgoritmos = new JComboBox();
        cbAlgoritmos.addItem("BCrypt");
        cbAlgoritmos.addItem("SHA3-512");
    }

    public void mensajeCamposRegistrarVacios (ActionEvent e){
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Para registrar un nombre debe rellenar adecuadamente los campos indicados");
    }
}
