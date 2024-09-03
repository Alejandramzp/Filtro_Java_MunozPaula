
package Dao;

import Model.HabilidadModel;

import Connection.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HabilidadDao {
    
    public boolean addHabilidad(HabilidadModel habi){
        String sql = "INSERT INTO habilidad (ID_ninja,nombre, descripcion) VALUES (?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
    
        try {
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(2, habi.getId_ninja());
            stmt.setString(1, habi.getNombre());
            stmt.setString(3, habi.getDescripcion());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al añadir la habilidad: " + e.getMessage());
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
    
    public boolean isNinjaExists(int id) {
        String sql = "SELECT COUNT(*) FROM ninja WHERE ID = ?";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el ID del ninja existe: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return exists;
    }  
}

