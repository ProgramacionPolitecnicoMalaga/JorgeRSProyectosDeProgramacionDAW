<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado de la suma</title>
</head>
<body>
<%
    PrintWriter printer = response.getWriter();
    printer.print("El resutado de la suma de los números " + request.getParameter("numeroA") + " y " + request.getParameter("numeroB") + " es :");
    printer.print("<br>" + request.getAttribute("resultadoSuma"));
    Logger.getLogger(this.getServletInfo()).info("Esta aplicación es de Jorge Ríos Sánchez");
%>
</body>
</html>