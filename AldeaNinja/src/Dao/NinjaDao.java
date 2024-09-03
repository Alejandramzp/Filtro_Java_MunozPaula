
package Dao;

import Model.NinjaModel;

import Connection.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NinjaDao {
    
    public boolean addNinja(NinjaModel ninja){
        String sql = "INSERT INTO ninja (nombre, rango, aldea) VALUES (?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
    
        try {
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, ninja.getNombre());
            stmt.setDouble(2, ninja.getRango());
            stmt.setString(3, ninja.getAldea());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al añadir la ninja: " + e.getMessage());
            return false;
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public List<NinjaModel> getAllNinja(){
        List<NinjaModel> ninjas = new ArrayList<>();
        
        String sql = "SELECT * FROM ninja";
        Conexion conexion = new Conexion();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = conexion.establecerConexion();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                NinjaModel ninja = new NinjaModel(
                        
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getDouble("rango"),
                        rs.getString("aldea")
    
                );
                ninjas.add(ninja);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Ninjas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return ninjas;   
    }    
}

