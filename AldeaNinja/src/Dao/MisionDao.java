
package Dao;

import Model.MisionModel;

import Connection.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MisionDao {
    
    public boolean addMision(MisionModel mision){
        String sql = "INSERT INTO mision (descripcion, rango, recompensa) VALUES (?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
    
        try {
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, mision.getDescripcion());
            stmt.setDouble(2, mision.getRango());
            stmt.setString(3, mision.getRecompensa());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al añadir la mision: " + e.getMessage());
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
    
    public List<MisionModel> getAllMision(){
        List<MisionModel> misiones = new ArrayList<>();
        
        String sql = "SELECT * FROM mision";
        Conexion conexion = new Conexion();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = conexion.establecerConexion();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MisionModel mision = new MisionModel(
                        
                        rs.getInt("ID"),
                        rs.getString("descripcion"),
                        rs.getDouble("rango"),
                        rs.getString("recompensa")
    
                );
                misiones.add(mision);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Misiones: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return misiones;   
    }
    
}
