public class Main {
    public static void main(String[] args) {
        Comerciales  comerciales = new Comerciales();
        Vistas vistas = new Vistas();
        Controlador ctrl = new Controlador(comerciales, vistas);
        ctrl.procesar();
    }
}
