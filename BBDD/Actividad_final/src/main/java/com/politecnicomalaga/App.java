package com.politecnicomalaga;

import com.politecnicomalaga.algoritmos.*;
import com.politecnicomalaga.vista.PrincipalUI;

import javax.swing.*;
import java.awt.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        JFrame frame = new JFrame("Verificacion de usuarios");
        frame.setContentPane(new PrincipalUI().getPanel());
        frame.setPreferredSize(new Dimension(1300, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
