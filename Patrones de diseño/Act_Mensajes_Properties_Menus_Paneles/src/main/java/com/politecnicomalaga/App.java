package com.politecnicomalaga;

import com.politecnicomalaga.vista.PanelPrincipal;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        JFrame frame = new JFrame("Verificacion de usuarios");
        frame.setResizable(false);
        frame.setContentPane(new PanelPrincipal().getPanel());
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
