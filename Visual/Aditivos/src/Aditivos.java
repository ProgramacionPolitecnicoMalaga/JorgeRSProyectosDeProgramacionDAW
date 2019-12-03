import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Aditivos {
    private JLabel lblBusqueda;
    private JTable tableAditivos;
    private JTextField txtBuscar;
    private JButton butBuscar;
    private JPanel panelMain;
    private tablaAditivo modelo;
    private MarcadorRenderer marcador;

    public Aditivos() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcador.setTexto(txtBuscar.getText());
                modelo.busqueda(txtBuscar.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aditivos");
        frame.setContentPane(new Aditivos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        modelo = new tablaAditivo();
        modelo.leerJson("aditivos.json");
        marcador=new MarcadorRenderer("");
        tableAditivos = new JTable(modelo);
        tableAditivos.setDefaultRenderer(Object.class, marcador);
        tableAditivos.getColumnModel().getColumn(2).setPreferredWidth(800);
    }
}
