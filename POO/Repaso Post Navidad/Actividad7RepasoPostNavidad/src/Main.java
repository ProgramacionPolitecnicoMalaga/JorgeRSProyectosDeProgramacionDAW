import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    private JTabbedPane tabPanel;
    private JPanel panelMain;
    private JButton mesa1Button;
    private JButton mesa2Button;
    private JButton mesa9Button;
    private JButton mesa10Button;
    private JButton mesa5Button;
    private JButton mesa6Button;
    private JButton mesa7Button;
    private JButton mesa8Button;
    private JButton mesa3Button;
    private JButton mesa4Button;
    private JButton cobrarMesaButton;
    private JButton añadirProductoAMesaButton;
    private JTextArea textAreaMostrarMesa;
    private JComboBox comboBoxProductos;
    private JTextArea textAreaCarta;
    private JButton mostrarCartaButton;
    private JButton añadirProductoButton;
    private JButton eliminarProductoNombreNecesarioButton;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton mesasAbiertasButton;
    private JButton mesasCerradasButton;
    private JTextArea textAreaCaja;
    private JButton mostrarCajaButton;

    private Cafeteria cafeteria;
    private int numMesaSeleccionada = -1;

    public Main() {
        cafeteria = new Cafeteria();
        cafeteria.inicializar();
        actualizaComboProductos();
        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numMesa = Integer.parseInt(e.getActionCommand().replace("Mesa ", ""));
                numMesaSeleccionada = numMesa;
                actualizaTextAreaMesa();
            }
        };
        mesa1Button.addActionListener(btnListener);
        mesa2Button.addActionListener(btnListener);
        mesa3Button.addActionListener(btnListener);
        mesa4Button.addActionListener(btnListener);
        mesa5Button.addActionListener(btnListener);
        mesa6Button.addActionListener(btnListener);
        mesa7Button.addActionListener(btnListener);
        mesa8Button.addActionListener(btnListener);
        mesa9Button.addActionListener(btnListener);
        mesa10Button.addActionListener(btnListener);
        añadirProductoAMesaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numMesaSeleccionada != -1) {
                    String nombreProducto = comboBoxProductos.getSelectedItem().toString();
                    cafeteria.addProductoAMesa(numMesaSeleccionada, nombreProducto);
                    actualizaTextAreaMesa();
                }
            }
        });
        cobrarMesaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cafeteria.cobrarCuenta(cafeteria.cerrarMesa(numMesaSeleccionada));
                actualizaTextAreaMesa();
            }
        });
        mesasAbiertasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMostrarMesa.setText("");
                ArrayList<Mesa> mesasAbiertas=cafeteria.getMesasAbiertas();
                for(Mesa mesa:mesasAbiertas){
                    textAreaMostrarMesa.append("Mesa: " + mesa.getNumMesa());
                }
            }
        });
        mesasCerradasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMostrarMesa.setText("");
                ArrayList<Mesa> mesasCerradas=cafeteria.getMesasCerradas();
                for(Mesa mesa:mesasCerradas){
                    textAreaMostrarMesa.append("Mesa: " + mesa.getNumMesa() + "\n");
                }
            }
        });
        añadirProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCarta.setText("");
                String nombreProducto=txtNombre.getText();
                double precioProducto=Double.parseDouble(txtPrecio.getText());
                cafeteria.addProducto(nombreProducto, precioProducto);
                txtNombre.setText("");
                txtPrecio.setText("");
                actualizaComboProductos();
                textAreaCarta.append("Se añadio con exito el producto " + nombreProducto + "con precio " + precioProducto);
            }
        });
        eliminarProductoNombreNecesarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCarta.setText("");
                String nombreProducto=txtNombre.getText();
                cafeteria.borrarProductoPorNombre(nombreProducto);
                txtNombre.setText("");
                txtPrecio.setText("");
                actualizaComboProductos();
                textAreaCarta.append("Se elimino con exito el producto " + nombreProducto);
            }
        });
        mostrarCartaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCarta.setText("");
                textAreaCarta.append(cafeteria.cartaToString());
            }
        });
        mostrarCajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCaja.setText("");
                textAreaCaja.append(cafeteria.getCaja().toString());
                textAreaCaja.append("\n-------------------" + "\n Total del cierre de caja = " + cafeteria.contarTotalCaja());
            }
        });
    }

    private void actualizaTextAreaMesa() {
        Mesa mesa = cafeteria.getMesaPorNumero(numMesaSeleccionada);
        ArrayList<Producto> productos = mesa.getProductosConsumidos();
        textAreaMostrarMesa.setText("");
        textAreaMostrarMesa.append("Mesa " + mesa.getNumMesa() + "\n");
        for (Producto producto : productos) {
            textAreaMostrarMesa.append(producto.getNombre() + "\n");
        }
        textAreaMostrarMesa.append("Total: " + mesa.calcularTotalCuenta() + "\n");
    }

    private void actualizaComboProductos() {
        comboBoxProductos.removeAllItems();
        TreeMap<String, Producto> carta = cafeteria.getCarta();
        for (String p : carta.keySet()) {
            comboBoxProductos.addItem(p);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cafeteria");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
