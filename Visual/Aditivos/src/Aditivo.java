public class Aditivo {
    String peligrosidad;
    String name;
    String comentario;

    public Aditivo(String peligrosidad, String nombre, String comentario) {
        this.peligrosidad = peligrosidad;
        this.name = nombre;
        this.comentario = comentario;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
