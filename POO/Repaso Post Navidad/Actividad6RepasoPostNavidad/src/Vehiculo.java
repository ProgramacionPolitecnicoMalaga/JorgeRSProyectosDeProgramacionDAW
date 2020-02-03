public class Vehiculo {

    private String modelo;
    private String marca;
    private String color;
    private int añoFabricacion;
    private String tipoCombustion;
    private String estado;
    private double precio;
    private String bastidor;

    public Vehiculo(String marca, String modelo, String color, int añoFabricacion, String tipoCombustion, String estado, double precio, String bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.tipoCombustion = tipoCombustion;
        this.estado = estado;
        this.precio = precio;
        this.bastidor=bastidor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public String getTipoCombustion() {
        return tipoCombustion;
    }

    public void setTipoCombustion(String tipoCombustion) {
        this.tipoCombustion = tipoCombustion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }
}
