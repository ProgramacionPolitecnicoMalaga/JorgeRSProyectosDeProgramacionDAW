package com.politecnico.dataviewer;

public class GeneradorDataViewer {

    public static Dataviewer generarDataViewer(int opcion){
        Dataviewer dataviewer=null;
        switch (opcion){
            case Dataviewer.HTML_DATAVIEWER: dataviewer=new HTMLDataViewer();
            break;
            case Dataviewer.TEXT_DATAVIEWER: dataviewer=new TextDataViewer();
            break;
        }
        return dataviewer;
    }
}
