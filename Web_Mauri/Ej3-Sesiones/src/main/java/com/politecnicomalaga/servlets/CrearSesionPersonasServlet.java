package com.politecnicomalaga.servlets;

import com.politecnicomalaga.modelo.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet(
        name="sesion",
        urlPatterns = {"/sesion"}
)

public class CrearSesionPersonasServlet extends HttpServlet {

    private RequestDispatcher dispatcher = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        ArrayList<Persona> listaDePersonasEnSesion = (ArrayList<Persona>) sesion.getAttribute("listaDePersonasEnSesion");
        if (listaDePersonasEnSesion == null){
            dispatcher = req.getRequestDispatcher("sinSesionPrevia.jsp");
        } else {
            req.setAttribute("listaDePersonasEnSesion",listaDePersonasEnSesion);
            dispatcher = req.getRequestDispatcher("sesionPreviaIniciada.jsp");
        }
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        ArrayList<Persona> listaDePersonasEnSesion = (ArrayList<Persona>) sesion.getAttribute("listaDePersonasEnSesion");
        if (listaDePersonasEnSesion == null)
            listaDePersonasEnSesion = new ArrayList<>();
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonRecibido = (JSONObject) parser.parse(json);
            String nombre = (String) jsonRecibido.get("nombre");
            String apellidos = (String) jsonRecibido.get("apellidos");
            int edad = Integer.parseInt((String) jsonRecibido.get("edad"));
            listaDePersonasEnSesion.add(new Persona(nombre, apellidos, edad));
        } catch(Exception e){
            listaDePersonasEnSesion.add(new Persona("Nombre desconocido", "Sin apellidos", 0));
        }
        sesion.setAttribute("listaDePersonasEnSesion",listaDePersonasEnSesion);
        req.setAttribute("listaDePersonasEnSesion",listaDePersonasEnSesion);
        dispatcher = req.getRequestDispatcher("sesionPreviaIniciada.jsp");
        dispatcher.forward(req,resp);
    }
}
