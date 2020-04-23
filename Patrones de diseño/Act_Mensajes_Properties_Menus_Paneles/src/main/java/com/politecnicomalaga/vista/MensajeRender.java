package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Mensaje;

import javax.swing.*;
import java.awt.*;

public class MensajeRender implements ListCellRenderer<Mensaje>{
    private JPanel pnlMensaje;
    private JLabel lblTextoMensaje;
    private JLabel lblTitulo;
    private JLabel lblRemitente;

    @Override
    public Component getListCellRendererComponent(JList<? extends Mensaje> list, Mensaje mensaje, int index, boolean isSelected, boolean cellHasFocus) {
        pnlMensaje.setBorder(BorderFactory.createLineBorder(Color.black));
        lblTitulo.setFont(new Font("SansSerif",Font.BOLD,14));
        lblRemitente.setFont(new Font("SansSerif",Font.BOLD,14));
        lblTextoMensaje.setFont(new Font("SansSerif",Font.BOLD,12));
        lblTitulo.setText(mensaje.getTitulo());
        lblRemitente.setText(mensaje.getNombreRemitente());
        lblTextoMensaje.setText(mensaje.getTexto());
        return pnlMensaje;
    }
}
