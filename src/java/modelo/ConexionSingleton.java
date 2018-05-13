package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSingleton {

    private static Connection _connection;

    private ConexionSingleton() {
        String driver = "com.mysql.jdbc.Driver";
        String name_db = "sakila";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + name_db, user, password);
        } catch (Exception e) {
            System.out.println("Error Duplicado el objeto _connection" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static Connection getConexion() {

        if (_connection == null) {
            new ConexionSingleton();
        }
        return _connection;
    }
}
