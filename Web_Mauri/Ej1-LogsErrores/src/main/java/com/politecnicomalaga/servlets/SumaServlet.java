package com.politecnicomalaga.servlets;

import com.politecnicomalaga.operaciones.Suma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class SumaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.getLogger(this.getServletInfo()).info("Los operandos recibidos son " + req.getParameter("numeroA") + " y " + req.getParameter("numeroB"));
        Suma suma = new Suma();
        int resultadoSuma = suma.sumar(Integer.parseInt(req.getParameter("numeroA")), Integer.parseInt(req.getParameter("numeroB")));
        Logger.getLogger(this.getServletInfo()).info("El resultado es " + resultadoSuma);
        req.setAttribute("resultadoSuma",resultadoSuma);
        RequestDispatcher view = req.getRequestDispatcher("suma.jsp");
        view.forward(req,resp);
    }
}
