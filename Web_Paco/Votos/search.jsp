<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%

    String nomABuscar = request.getParameter("term");
    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID, NOMAPE FROM USUARIOS WHERE NOMAPE LIKE '%" + nomABuscar + "%'");
        String res = "[";
        while (rs.next()) {
            res += "{\"id\": \"" + rs.getString("ID") + "\", \"value\": \"" + rs.getString("NOMAPE") + "\"}";
            if (!rs.isLast()) {
                res += ",";
            }
        }
        res += "]";
        rs.close();
        conexion.close();
        //String json = new Gson().toJson(res);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(res);
    } catch (Exception ignored) {
    }


%>