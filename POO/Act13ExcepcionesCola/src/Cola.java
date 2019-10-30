public class Cola {
    private int tail, head;
    private int[] elementos;
    private int elementosAlmacenados = 0;

    public Cola(int tamanoCola){
        head = -1;
        tail = -1;
        elementos = new int[tamanoCola];
    }

    public int sacar() throws SacarElementoDeColaVaciaException {
        int elemento;
        if (!estaVacia()) {
            elemento = elementos[head];
            head++;
            if (head == elementos.length)
                head = 0;
            elementosAlmacenados--;
            if (elementosAlmacenados == 0){
                tail = -1;
                head = -1;
            }
<<<<<<< HEAD:POO/Act13ExcepcionesCola/src/Cola.java
        } else {
            tail = -1;
            head = -1;
            throw new SacarElementoDeColaVaciaException("No hay elementos", head);
        }
=======

        } else
            throw new ExcepcionColaVacia("La cola ya esta vacia", head);
>>>>>>> origin/master:Act13ExcepcionesCola/src/Cola.java
        return elemento;
    }

    public void meter(int nuevoElemento){
        if (estaVacia()){
<<<<<<< HEAD:POO/Act13ExcepcionesCola/src/Cola.java
            tail = 0;
            head=0;
=======
            head = 0;
            tail = 0;
>>>>>>> origin/master:Act13ExcepcionesCola/src/Cola.java
        }else if (!estaLlena()){
            tail++;
            if (tail == elementos.length)
                tail = 0;
            elementosAlmacenados++;
            elementos[tail]=nuevoElemento;
        } else {
            // La cola está llena. No se pueden meter elementos. Se debe lanzar una excepción.
        }
    }

    public boolean estaVacia(){
        return (elementosAlmacenados == 0);
    }

    public boolean estaLlena(){
        return elementosAlmacenados == elementos.length;
    }

    private int numeroElementos(){
        /*int temp = (tail - head) % elementos.length;
        if (temp < 0)
            temp = (elementos.length + temp) + 1;
        else
            temp++;*/
        return elementosAlmacenados;
    }

    public String toString() {
        String contenidoCola = "HEAD (" + head + ")";
        int totalElementosRecorridos = 0;
        for (int i=head; totalElementosRecorridos < numeroElementos(); i++){
            i = i%elementos.length;
            contenidoCola += "|" + elementos[i] + "|";
            totalElementosRecorridos++;
        }

        contenidoCola += "TAIL(" + tail + ")";
        return contenidoCola;
    }
}
