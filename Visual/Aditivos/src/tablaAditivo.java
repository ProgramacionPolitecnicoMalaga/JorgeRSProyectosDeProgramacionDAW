import com.google.gson.Gson;

import javax.swing.table.AbstractTableModel;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;


public class tablaAditivo extends AbstractTableModel {
    String [] nombreColumnas= {"Peligrosidad", "Nombre", "Comentarios"};
    Aditivo [] datos_originales;
    ArrayList<Aditivo> datos_filtrados=new ArrayList<Aditivo>();

    @Override
    public int getRowCount() {
        return datos_filtrados.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aditivo aditivo =  datos_filtrados.get(rowIndex);
        if (columnIndex == 0) {
            return aditivo.getPeligrosidad();
        }else if (columnIndex == 1) {
            return aditivo.getName();
        } else return aditivo.getComentario();
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public void leerJson (String archivo) {
        try {
            Gson gson = new Gson();
            datos_originales = gson.fromJson(new FileReader(archivo), Aditivo[].class);
        } catch (Throwable t) {
        }
    }

    public void busqueda(String txtBuscar){
        datos_filtrados.clear();
        if (txtBuscar.compareTo("") == 0) {
            for (int i=0; i< datos_originales.length; i++){
                datos_filtrados.add(datos_originales[i]);
            }
        }else {
            for (int i = 0; i < datos_originales.length; i++) {
                if ((cleanString(datos_originales[i].getPeligrosidad()).contains(cleanString(txtBuscar)))
                        || (cleanString(datos_originales[i].getName()).contains(cleanString(txtBuscar)))
                        || (cleanString(datos_originales[i].getComentario()).contains(cleanString(txtBuscar)))) {
                    datos_filtrados.add(datos_originales[i]);
                }
            }
        }
        super.fireTableDataChanged();
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}
