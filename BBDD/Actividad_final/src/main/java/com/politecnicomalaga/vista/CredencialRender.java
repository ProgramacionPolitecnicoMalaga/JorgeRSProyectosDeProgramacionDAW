package com.politecnicomalaga.vista;

import com.politecnicomalaga.algoritmos.GeneradorAlgoritmos;
import javax.swing.*;
import java.awt.*;
//public class CredencialRender implements ListCellRenderer<Credencial> {
public class CredencialRender implements ListCellRenderer<DataTransfer> {
    private JPanel panelCredencial;
    private JLabel lblNombre;
    private JLabel lblIcono;
    private JLabel lblPassword;
    private JLabel lblHash;
    private JLabel lblAlgoritmo;
    private ImageIcon iconoValido = new ImageIcon("src/main/resources/valido.png");
    private ImageIcon iconoErroneo = new ImageIcon("src/main/resources/erroneo.png");

    @Override
    public Component getListCellRendererComponent(JList<? extends DataTransfer> list, DataTransfer dataTransfer, int index, boolean isSelected, boolean cellHasFocus) {
    //public Component getListCellRendererComponent(JList<? extends Credencial> list, Credencial credencial, int index, boolean isSelected, boolean cellHasFocus) {
        lblAlgoritmo.setOpaque(true);
        lblNombre.setFont(new Font("SansSerif",Font.BOLD,14));
        lblPassword.setFont(new Font("SansSerif",Font.BOLD,14));
        lblHash.setFont(new Font("SansSerif",Font.BOLD,12));
        lblAlgoritmo.setFont(new Font("SansSerif",Font.BOLD,12));

        lblNombre.setText((String)dataTransfer.get("nombre"));
        lblHash.setText((String)dataTransfer.get("passwordHashed"));
        lblAlgoritmo.setText(GeneradorAlgoritmos.getNombreAlgoritmo((int)dataTransfer.get("algoritmo")));
        lblPassword.setText((String)dataTransfer.get("passwordPlana"));
        if ((boolean)dataTransfer.get("validado")){
            lblIcono.setIcon(iconoValido);
        } else
            lblIcono.setIcon(iconoErroneo);
        //setLblIcono();
        //lblNombre.setText(credencial.getNombre());
        //lblHash.setText(credencial.getHash());
        //lblAlgoritmo.setText(GeneradorAlgoritmos.getNombreAlgoritmo(credencial.getAlgoritmo()));
        switch ((int)dataTransfer.get("algoritmo")){
        //switch (credencial.getAlgoritmo()){
            case GeneradorAlgoritmos.ALGORITMOBCRYPT: lblAlgoritmo.setBackground( Color.orange );
                break;
            case GeneradorAlgoritmos.ALGORITMOSHA3_512: lblAlgoritmo.setBackground( Color.yellow );
                break;
        }
        return panelCredencial;
    }
    /*
    public void setLblIcono (){
        if (verificacion){
            lblIcono.setIcon(iconoValido);
        } else
            lblIcono.setIcon(iconoErroneo);
    }

    public void setLblPassword (String password){
        lblPassword.setText(password);
    }


    public void setVerificacion (boolean verificacion){
        this.verificacion=verificacion;
    }

     */
}
