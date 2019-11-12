public class Piloto {
    private int posicion;
    private String nombrePiloto;
    private String escuderia;

    public Piloto(int posicion, String nombrePiloto, String escuderia){
        this.posicion=posicion;
        this.nombrePiloto=nombrePiloto;
        this.escuderia=escuderia;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return posicion + " - " +
                nombrePiloto + " - " +
                escuderia + "\n";
    }
}
