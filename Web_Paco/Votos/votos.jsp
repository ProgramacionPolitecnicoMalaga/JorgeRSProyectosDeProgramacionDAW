<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    //Recepción de parámetros
    String voto = request.getParameter("voto");
    String idVotado = request.getParameter("id");
    String idVotante = request.getParameter("idVotante");
    String result = "";
    int total = 0;
    //Conexión a la base de datos
    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();
        stmt.execute("INSERT INTO VOTOS (IDVOTANTE, IDVOTADO, VOTO) VALUES ('" + idVotante + "', '" + idVotado + "', '" + voto + "')");
        Statement stmt2 = conexion.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT SUM(VOTO) AS VOTOS_TOTALES_USUARIO FROM VOTOS WHERE IDVOTADO =" + idVotado + " GROUP BY IDVOTADO");
        while (rs.next()) {
            total = rs.getInt("VOTOS_TOTALES_USUARIO");
        }
        result = "{\"status\":\"ok\", \"total\":" + Integer.toString(total) + "}";
    } catch (Exception ex) {
        result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
    }
    //Generación de la salida
    String json = new Gson().toJson(result);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>