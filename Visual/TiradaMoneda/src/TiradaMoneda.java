import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiradaMoneda {
    private JLabel lblTitulo;
    private JPanel pnlMonedas;
    private JLabel lblTiradasARealizar;
    private JButton butTirar;
    private JButton butRepetir;
    private JButton butLimpiar;
    private JTextField textMeterTiradas;
    private JLabel lblTotalTiradas;
    private JLabel lblTotal;
    private JLabel lblTotalCara;
    private JLabel lblMostrarTotalCara;
    private JLabel lblMostrarTotalCruz;
    private JLabel lblTotalCruz;
    private JLabel lblPorcentajeCara;
    private JLabel lblMostrarPorCara;
    private JLabel lblMostrarPorCruz;
    private JLabel lblPorcentajeCruz;
    private JPanel panelMain;
    private JLabel lblPorcentaje2;
    private JLabel lblPorcentaje1;
    private JButton butTirarCantidadDeterminada;
    private JLabel lblCara;
    private JLabel lblCruz;
    private int totalCara;
    private int totalCruz;
    private int totalTiradas;
    private double totalCaraPorciento;
    private double totalCruzPorciento;
    private boolean resultadoTirada;

    public boolean Tirada (){
        double tirada=Math.random();
        return (tirada<0.5);
    }

    public void ActualizarResultados (){
        if (resultadoTirada){
            totalCara=totalCara+1;
        }else totalCruz=totalCruz+1;
        totalTiradas=totalCara+totalCruz;
        totalCaraPorciento=((double)totalCara/(double)totalTiradas)*100;
        totalCruzPorciento=((double)totalCruz/(double)totalTiradas)*100;
    }

    public void ActualizarInterface (){
        if (resultadoTirada){
            lblCara.setVisible(true);
            lblCruz.setVisible(false);
        } else {
            lblCruz.setVisible(true);
            lblCara.setVisible(false);
        }
        lblMostrarTotalCara.setText(Integer.toString(totalCara));
        lblMostrarTotalCruz.setText(Integer.toString(totalCruz));
        lblTotal.setText(Integer.toString(totalTiradas));
        lblMostrarPorCara.setText(String.format("%.2f" ,totalCaraPorciento));
        lblMostrarPorCruz.setText(String.format("%.2f" ,totalCruzPorciento));
    }


    public TiradaMoneda() {
        lblCruz.setVisible(false);
        totalCara=0;
        totalCruz=0;
        totalTiradas=0;
        totalCaraPorciento=0.0;
        totalCruzPorciento=0.0;
        resultadoTirada=false;

        butTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            resultadoTirada=Tirada();
            ActualizarResultados();
            ActualizarInterface();
            }
        });
        butTirarCantidadDeterminada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoTiradas = textMeterTiradas.getText();
                int i=0;
                if (textoTiradas.matches("[0-9]+")) {
                    int numeroDeTiradas = Integer.parseInt(textoTiradas);
                    while (i<numeroDeTiradas){
                        resultadoTirada=Tirada();
                        ActualizarResultados();
                        ActualizarInterface();
                        i++;
                    }
                }else {
                    textMeterTiradas.setText("0");
                }
            }
        });
        butRepetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                int totalTiradasActual = totalTiradas;
                while (i<totalTiradasActual){
                    resultadoTirada=Tirada();
                    ActualizarResultados();
                    ActualizarInterface();
                    i++;
                }
            }
        });
        butLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            lblMostrarTotalCara.setText("0");
            lblMostrarTotalCruz.setText("0");
            lblMostrarPorCara.setText("0");
            lblMostrarPorCruz.setText("0");
            lblTotal.setText("0");
            textMeterTiradas.setText("");
            lblCara.setVisible(true);
            lblCruz.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TiradaMoneda");
        frame.setContentPane(new TiradaMoneda().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        lblCara = new JLabel(new ImageIcon("resources/cara.png"));
        lblCruz = new JLabel(new ImageIcon("resources/cruz.png"));
    }
}
