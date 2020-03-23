package com.politecnicomalaga.Vista;

import com.politecnicomalaga.Modelo.Item;
import com.politecnicomalaga.Modelo.Tipo;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class modalDialog extends JDialog{
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private JTextField txtFieldAutor;
    private JTextField txtFieldFecha;
    private JTextField txtFieldTexto;
    private JComboBox cmbBoxTIpo;
    private JPanel panelModal;
    private JLabel lblTipo;
    private JLabel lblTexto;
    private JLabel lblFecha;
    private JLabel lblAutor;
    private JButton btnCancelar;
    private JButton btnAceptar;
    private Item nuevoItem;

    public modalDialog() {
        setContentPane(panelModal);
        setModal(true);
        getRootPane().setDefaultButton(btnAceptar);
        Tipo it = new Tipo(Tipo.IT);
        it.setTipoPorId(Tipo.IT);
        Tipo desarrollo = new Tipo(Tipo.DESARROLLO);
        desarrollo.setTipoPorId(Tipo.DESARROLLO);
        Tipo mantenimiento = new Tipo(Tipo.MANTENIMIENTO);
        mantenimiento.setTipoPorId(Tipo.MANTENIMIENTO);
        Tipo general = new Tipo(Tipo.GENERAL);
        general.setTipoPorId(Tipo.GENERAL);
        cmbBoxTIpo.addItem(it);
        cmbBoxTIpo.addItem(desarrollo);
        cmbBoxTIpo.addItem(mantenimiento);
        cmbBoxTIpo.addItem(general);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
        // add your code here
        nuevoItem = new Item((Tipo)(cmbBoxTIpo.getSelectedItem()), txtFieldAutor.getText(), LocalDate.parse(txtFieldFecha.getText(), formatter), txtFieldTexto.getText());
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Item getNuevoItem(){
        pack();
        setVisible(true);  // Bloqueo la ventana
        dispose();
        return nuevoItem;
    }

}

