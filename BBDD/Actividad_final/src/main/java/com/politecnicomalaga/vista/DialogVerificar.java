package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DialogVerificar extends JDialog{
    private JTextField txtNombre;
    private JPanel DialogVerificar;
    private JPasswordField passwPassword;
    private JButton btnValidar;
    private JButton btnCancelar;
    private JLabel lblNombre;
    private JLabel lblPassword;
    private DataTransfer datos;

    public DialogVerificar(DataTransfer datos) throws SQLException {
        super.setLocationRelativeTo(null);
        this.datos=datos;
        setContentPane(DialogVerificar);
        setModal(true);
        getRootPane().setDefaultButton(btnValidar);
        txtNombre.setText("");
        passwPassword.setText("");

        btnValidar.addActionListener(new ActionListener() {
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
        DialogVerificar.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
        setVisible(true);  // Bloqueo la ventana
        dispose();
    }

    private void onOK(ActionEvent e) throws SQLException {
        if (!(txtNombre.getText().isEmpty() && passwPassword.getPassword().length==0)) {
            datos.put("nombre", txtNombre.getText());
            datos.put("password", new String(passwPassword.getPassword()));
            dispose();
        } else mensajeCamposVerificacionVacios(e);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void mensajeCamposVerificacionVacios (ActionEvent e){
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Para verificar, debe rellenar correctamente los campos indicados.");
    }
}
