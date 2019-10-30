public class ConsumidorCola {
    private static Cola cola;
    private static final int TAM_COLA = 5;

    public static void main(String[] args) {
        try {
        cola = new Cola(TAM_COLA);
        cola.meter(10);
        System.out.println(cola);
        cola.sacar();
        System.out.println(cola);
        cola.sacar();
        System.out.println(cola);

        }catch (ExcepcionColaVacia e){
            System.out.println(e.advertenciaExcepcion());
        }

    }
}
