package modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {

    private Connection _connection;

    public AccesoDatos() {
        _connection = ConexionSingleton.getConexion();
    }

    public List<String> pedirPaises() {
        List<String> lista = new ArrayList<>();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = _connection.createStatement();
            String sql = "SELECT COUNTRY FROM COUNTRY";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                lista.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String> pedirData(String pais) {
        List<String> lista = new ArrayList<>();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = _connection.createStatement();
            String sql = "SELECT c.first_name, c.last_name, a.address, y.city "
                    + "FROM  customer c "
                    + "JOIN  address a ON c.address_id = a.address_id "
                    + "JOIN city y ON a.city_id = y.city_id "
                    + "JOIN country o ON y.country_id = o.country_id "
                    + "WHERE o.country = '" + pais + "'";

            resultSet = statement.executeQuery(sql);
            String datito = "";
            while (resultSet.next()) {
                datito = resultSet.getString(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3) + " - " + resultSet.getString(4);
                lista.add(datito);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
