import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class ListadoPilotos {

    private ArrayList<Piloto>listaPilotos;

    public ListadoPilotos (){
        listaPilotos=new ArrayList<>();
    }

    public void desordenarListaPilotos (){
        ArrayList<Piloto> listaPilotosDesordenada = new ArrayList<>();
        int tamañoRestante=listaPilotos.size();
        Random r = new Random();
        while (tamañoRestante>0){
            int cogerDePosicion=r.nextInt(tamañoRestante);
            Piloto piloto = listaPilotos.get(cogerDePosicion);
            listaPilotos.remove(cogerDePosicion);
            listaPilotosDesordenada.add(piloto);
            tamañoRestante--;
        }
        listaPilotos = listaPilotosDesordenada;
    }

    public int numPilotosAMover (ArrayList<Piloto> listaPilotos){
        Random r = new Random();
        return r.nextInt((listaPilotos.size()/2));
    }

    public void moverPiloto (){
        int i=0;
        int numeroDePilotosAMover=numPilotosAMover(listaPilotos);
        while (i<numeroDePilotosAMover){
            int posPiloto = new Random().nextInt(listaPilotos.size());
            int movimiento = new Random().nextInt(5) - 2;
            if (movimiento == 0) {
                double probabilidadDescalificado=Math.random();
                if (probabilidadDescalificado>0.6)
                    listaPilotos.remove(posPiloto);
            } else {
                int nuevaPosPiloto = posPiloto - movimiento;
                if (nuevaPosPiloto < 0)
                    nuevaPosPiloto = 0;
                if (nuevaPosPiloto > listaPilotos.size() - 1)
                    nuevaPosPiloto = listaPilotos.size() - 1;
                Piloto piloto=listaPilotos.get(posPiloto);
                listaPilotos.remove(posPiloto);
                listaPilotos.add(nuevaPosPiloto, piloto);
            }
            i++;
        }
    }

    public int getTamañoListaPilotos (){
        return listaPilotos.size();
    }

    public Piloto getElementoListadoPiloto (int indice){
        return listaPilotos.get(indice);
    }

    public void leerDeArchivo (String csvFile){
        String linea;
        int numeroElemento = 0;

        try {
            BufferedReader br = new BufferedReader (new FileReader(csvFile));
            while ((linea = br.readLine()) != null) {
                String[] camposPilotos = linea.split(";");
                Piloto piloto = new Piloto(Integer.parseInt(camposPilotos[0]), camposPilotos[1], camposPilotos[2]);
                listaPilotos.add(piloto);
                numeroElemento++;
            }
            if (br != null) {
                br.close();
            }
        } catch (Throwable t) {}
    }

    public void escribirArchivo (String csvFile){

        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter(csvFile));
            for (int i = 0; i < listaPilotos.size();i++) {
                Piloto piloto = listaPilotos.get(i);
                bw.write(Integer.toString(piloto.getPosicion())+";"+ piloto.getNombrePiloto()+";"+piloto.getEscuderia());
                bw.newLine();
            }
            bw.close();
        } catch (Throwable t) {}
    }

}
