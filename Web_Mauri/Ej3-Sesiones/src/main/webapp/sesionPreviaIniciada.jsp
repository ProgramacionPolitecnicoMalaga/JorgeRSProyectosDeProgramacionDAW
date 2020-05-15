<%@ page import="java.util.ArrayList" %>
<%@ page import="com.politecnicomalaga.modelo.Persona" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%
    ArrayList<Persona> listaDePersonasEnSesion = (ArrayList<Persona>) request.getAttribute("listaDePersonasEnSesion");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    Iterator<Persona> personaIterator = listaDePersonasEnSesion.iterator();
    while (personaIterator.hasNext()){
        Persona personaAIterar = personaIterator.next();
        out.println("<p>" + personaAIterar.getNombre() + " " + personaAIterar.getApellidos() + ", " +
                    personaAIterar.getEdad() +  ", " + personaAIterar.getFechaActual().format(formatter) + "</p>");
    }
%>
