package com.politecnicomalaga.vista;

public interface Multipanel {

    public final static int PANEL_LOGIN = 1;
    public final static int PANEL_LECTURA = 2;
    public final static int PANEL_ESCRITURA = 3;

    public void notificarCambioPanel (int cambio);
}
