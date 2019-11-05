import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarritoCompra {
    private JPanel panelMain;
    private JTextField textUnidadesCompra;
    private JComboBox comboBoxProductos;
    private JButton butComprar;
    private JLabel lblUnidades;
    private JLabel lblProducto;
    private JLabel lblTitulo;
    private JLabel lblTotal;
    private JLabel lblMostrarTotal;
    private JList listProductosCompra;
    private JScrollPane scrollListaCompra;
    private JButton butCancelar;
    private ListadoProductos productos;
    private double total=0;

    public CarritoCompra() {

        butComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<LineaPedido> productos = (DefaultListModel<LineaPedido>) listProductosCompra.getModel();
                String textoUnidades=textUnidadesCompra.getText();
                if (textoUnidades.matches("[0-9]+")) {
                    Producto producto = (Producto) comboBoxProductos.getSelectedItem();
                    LineaPedido linea = new LineaPedido(Integer.parseInt(textUnidadesCompra.getText()), producto);
                    productos.addElement(linea);
                    textUnidadesCompra.setText("");
                    textUnidadesCompra.grabFocus();
                    comboBoxProductos.setSelectedIndex(0);
                    total=total + linea.CalcularTotal();
                }else {
                    textUnidadesCompra.setText("");
                    textUnidadesCompra.grabFocus();
                }
                lblMostrarTotal.setText(Double.toString(total));
            }
        });
        butCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel<LineaPedido>) listProductosCompra.getModel()).removeAllElements();
                textUnidadesCompra.setText("");
                textUnidadesCompra.grabFocus();
                comboBoxProductos.setSelectedIndex(0);
                lblMostrarTotal.setText("0");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CarritoCompra");
        frame.setContentPane(new CarritoCompra().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void createUIComponents() {
        productos = new ListadoProductos();
        productos.importarDeArchivo("csv/productos.csv");
        DefaultComboBoxModel<Producto> cbProductos = new DefaultComboBoxModel<Producto>();
        for (int i=0; i < productos.getTamañoListado();i++) {
            cbProductos.addElement(productos.getProducto(i));
        }
        comboBoxProductos = new JComboBox(cbProductos);

        DefaultListModel<LineaPedido> pedidos = new DefaultListModel<LineaPedido>();
        listProductosCompra = new JList(pedidos);
    }
}
