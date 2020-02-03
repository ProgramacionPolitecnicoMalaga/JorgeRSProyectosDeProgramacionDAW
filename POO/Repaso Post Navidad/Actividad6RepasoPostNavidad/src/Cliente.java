public class Cliente {

    private String nombre;
    private String apellidos;
    private String dni;
    private String cuentaBancaria;

    public Cliente(String nombre, String apellidos, String dni, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
}
