import java.io.BufferedReader;
import java.io.FileReader;

public class ListadoProductos {

    final static int TOTAL_PRODUCTOS=77;

    private Producto[] productos;

    public ListadoProductos (){
        productos=new Producto[TOTAL_PRODUCTOS];
    }

    public Producto getProducto(int i){
        return productos[i];
    }

    public int getTamañoListado(){
        return TOTAL_PRODUCTOS;
    }

    public void importarDeArchivo (String csvFile){
        String linea;
        int numeroElemento = 0;

        try {
            BufferedReader br = new BufferedReader (new FileReader(csvFile));
            while ((linea = br.readLine()) != null) {
                String[] camposProductos = linea.split(";");
                Producto producto = new Producto(Integer.parseInt(camposProductos[0]), camposProductos[1], camposProductos[2], camposProductos[3], Double.parseDouble(camposProductos[4].replace(",", ".")));
                productos[numeroElemento] = producto;
                numeroElemento++;
            }
            if (br != null) {
                br.close();
            }
        } catch (Throwable t) {}
    }
}
