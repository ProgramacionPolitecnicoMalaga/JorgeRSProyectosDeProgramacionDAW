package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class PanelLogin {
    private JButton btnAceptar;
    private JTextField txtNombre;
    private JPanel pnlLogin;
    private JPasswordField pswrdUsuario;
    private Multipanel panelPrincipal;
    private ControladorUsuarios controladorUsuarios;

    public PanelLogin(Multipanel panelPrincipal, ControladorUsuarios controladorUsuarios){
        this.panelPrincipal=panelPrincipal;
        this.controladorUsuarios = controladorUsuarios;

        pnlLogin.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                txtNombre.setText("");
                pswrdUsuario.setText("");
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String password = new String(pswrdUsuario.getPassword());
                try {
                    String usuarioLogueado = controladorUsuarios.login(nombre, password);
                    if(usuarioLogueado!=null){
                        controladorUsuarios.setSesionEnPropiedades(usuarioLogueado);
                        panelPrincipal.notificarCambioPanel(Multipanel.PANEL_LECTURA);
                    } else {
                        mensajeLoginIncorrecto(e);
                        txtNombre.setText("");
                        pswrdUsuario.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){
        return pnlLogin;
    }

    public void mensajeLoginIncorrecto (ActionEvent e){
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "El nombre o contraseña no es correcto. Por favor, vuelve a interntarlo.");
    }
}
