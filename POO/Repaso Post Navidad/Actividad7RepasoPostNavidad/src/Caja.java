import java.util.ArrayList;

public class Caja {

    private ArrayList<Cuenta> cuentasCobradas;

    public Caja(){
        cuentasCobradas=new ArrayList<Cuenta>();
    }

    public void addCuentaCobrada(Cuenta cuenta){
        cuentasCobradas.add(cuenta);
    }

    public ArrayList<Cuenta> getCuentasCobradas(){
        return cuentasCobradas;
    }

    @Override
    public String toString() {
        return "Cuentas en Caja: " + cuentasCobradas;
    }
}
