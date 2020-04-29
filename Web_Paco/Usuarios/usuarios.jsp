<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    String result = "";
    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        //Recepción de parámetros

        String nick = request.getParameter("nick");
        String email = request.getParameter("email");
        String nomap = request.getParameter("nomap");
        //String id = "";

        //Conexión a la base de datos
        Statement stmt = conexion.createStatement();
        stmt.execute("INSERT INTO USUARIOS (NICK, CORREO, NOMAPE) VALUES ('" + nick +
                "','" + email + "','" + nomap + "')");



        /*Statement stmt2 = conexion.createStatement();
        ResultSet rs =stmt2.executeQuery("SELECT ID FROM USUARIOS WHERE NICK = '" + nick +
                "'");

        while (rs.next()) {
            id += rs.getString("ID");
        }

         */
        result = "{\"status\":\"ok\",\"mensaje\" : \" El usuario ha sido insertado con éxito \"}";

    } catch (Exception ex) {
        result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
    }

    //Generación de la salida
    String json = new Gson().toJson(result);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>