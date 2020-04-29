<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    String result = "";
    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/INMOLOSA?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        //Recepción de parámetros
        String accion = request.getParameter("accion");
        String html="";

        switch (accion) {
            case "delete":
                    Statement stmt = conexion.createStatement();
                    stmt.execute("DELETE FROM EMPLEADOS WHERE ID_EMPLEADO="+ request.getParameter("idRegistro"));
                break;
            case "update":
                    Statement stmt2 = conexion.createStatement();
                    String sql = "UPDATE EMPLEADOS SET NOMBRE='" + request.getParameter("nombre_empleado") + "',APELLIDOS='" + request.getParameter("apellidos_empleado") +
                                "',FECHA_NACIMIENTO='" + request.getParameter("fecha_nacimiento") + "' WHERE ID_EMPLEADO="+ request.getParameter("idRegistro");
                    stmt2.execute(sql);
                break;
            case "create":
                    Statement stmt3 = conexion.createStatement();
                    String sql2 = "INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, FECHA_NACIMIENTO) VALUES ('" + request.getParameter("nombre_empleado") +
                                "','" + request.getParameter("apellidos_empleado") + "','" + request.getParameter("fecha_nacimiento") + "')";
                    stmt3.execute(sql2);
            break;
        }
        String str = request.getParameter("str");
        Integer items = 0;
        html += "<table class='table'>" +
                "  <thead>" +
                "    <tr>" +
                "      <th scope='col'>&nbsp;</td>" +
                "      <th scope='col'>#</th>" +
                "      <th scope='col'>Nombre</th>" +
                "      <th scope='col'>Apellidos</th>" +
                "      <th scope='col'>Fecha nacimiento</th>" +
                "    </tr>" +
                "  </thead><tbody>";

       //Conexión a la base de datos
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID_EMPLEADO,NOMBRE,APELLIDOS,FECHA_NACIMIENTO FROM EMPLEADOS WHERE NOMBRE LIKE '%" + str + "%'");
        while (rs.next()) {
            items++;
            html += "<tr><td style='text-align:center'><a href='#' onclick='Eliminar(" + rs.getString("ID_EMPLEADO") + ")'><img src='img/delete.png' width='24'></a>" +
                            "<a href='#' data-toggle='modal' data-target='#modalUpdate' data-id='" +
                                rs.getString("ID_EMPLEADO") + "' data-nombre='" +
                                rs.getString("NOMBRE") + "' data-apellidos='" +
                                rs.getString("APELLIDOS") + "' data-fecha-nacimiento='" +
                                rs.getString("FECHA_NACIMIENTO") + "'><img src='img/update.png' width='24' onclick='MostrarModificar()'></a></td>";
            html += "<td>" + rs.getString("ID_EMPLEADO") + "</td>";
            html += "<td>" + rs.getString("NOMBRE") + "</td>";
            html += "<td>" + rs.getString("APELLIDOS") + "</td>";
            html += "<td>" + rs.getString("FECHA_NACIMIENTO") + "</td></tr>";
        }
        html += "</tbody></table>";
        result = "{\"status\":\"ok\",\"html\" : \"" + html + "\",\"items\":" + items + "}";

    } catch (Exception ex) {
        result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
    }

    //Generación de la salida
    String json = new Gson().toJson(result);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>