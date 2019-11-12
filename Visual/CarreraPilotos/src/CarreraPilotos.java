import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarreraPilotos {
    private JTextArea textRankingPilotos;
    private JPanel panelMain;
    private JButton butCarrera;
    private JButton butOrdenDeSalidaButton;
    private static ListadoPilotos listaPilotos=new ListadoPilotos();

    public CarreraPilotos() {
        butOrdenDeSalidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                butOrdenDeSalidaButton.setEnabled(false);
                butCarrera.setEnabled(true);
                listaPilotos.desordenarListaPilotos();
                for(int i=0; i<listaPilotos.getTamañoListaPilotos(); i++){
                    textRankingPilotos.append(listaPilotos.getElementoListadoPiloto(i).toString());
                }
                listaPilotos.escribirArchivo("piloto2.csv");
            }
        });
        butCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textRankingPilotos.setText("");
                listaPilotos.moverPiloto();
                for(int i=0; i<listaPilotos.getTamañoListaPilotos(); i++){
                    textRankingPilotos.append(listaPilotos.getElementoListadoPiloto(i).toString());
                }
                listaPilotos.escribirArchivo("piloto2.csv");
            }
        });
    }

    public static void main(String[] args) {
        listaPilotos.leerDeArchivo("pilotos.csv");
        JFrame frame = new JFrame("CarreraPilotos");
        frame.setContentPane(new CarreraPilotos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
