import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MarcadorRenderer extends DefaultTableCellRenderer {
    private String texto = "";

    MarcadorRenderer(String texto) {
        setTexto(texto);
    }

    public void setTexto(String texto) {
        if (texto==null) {
            this.texto = "";
        } else {
            this.texto = texto;
        }
    }

    public String getTexto() {
        return this.texto;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (texto.length() != 0) {
            String valor = value.toString();
            JLabel lbl = (JLabel)componente;
            if (valor.contains(texto)) {
                lbl.setText("<html>" + valor.replace(texto, "<span style=\"color:white;background-color:blue\">" + texto + "</span>") + "</html>");
            } else {
                lbl.setText(valor);
            }
        }
        return componente;
    }
}
