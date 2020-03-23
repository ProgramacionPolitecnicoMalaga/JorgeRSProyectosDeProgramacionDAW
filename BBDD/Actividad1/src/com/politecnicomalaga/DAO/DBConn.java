package com.politecnicomalaga.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

    private final static LectorCredenciales credenciales = new LectorCredenciales();
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://" + credenciales.getHost() + "/" + credenciales.getDatabase() + "?useUnicode=yes&characterEncoding=UTF-8";
    private final static String usuario = credenciales.getUser();
    private final static String password = credenciales.getPassword();
    private Connection conn = null;
    private static DBConn instance = null;

    public DBConn (){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }

    public static DBConn getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConn();
        } else if (instance.getConn().isClosed()) {
            instance = new DBConn();
        }

        return instance;
    }

    public ResultSet read(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int update(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }
}
