package cl.praxis.model.dao;

import cl.praxis.model.Proveedor;
import cl.praxis.model.conexion.BDConexion;
import cl.praxis.model.dto.ProveedorDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOImpl implements ProveedorDAO {

    @Override
    public boolean addProveedor(Proveedor proveedor) {
        String query = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = BDConexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            // Convierte todo el nombre a mayúsculas
            String nombreEnMayusculas = proveedor.getNombre().toUpperCase().trim();
            pstmt.setString(1, nombreEnMayusculas);
            pstmt.setString(2, proveedor.getRut());
            pstmt.setString(3, proveedor.getDireccion());
            pstmt.setString(4, proveedor.getCorreo());
            pstmt.setString(5, proveedor.getTelefono());
            pstmt.setString(6, proveedor.getContacto());
            pstmt.setString(7, proveedor.getTelefonoContacto());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas afectadas al insertar proveedor: " + rowsAffected);
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProveedorDTO> getAllProveedoresDTO() {
        List<ProveedorDTO> proveedores = new ArrayList<>();
        String query = "SELECT nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores ORDER BY nombre ASC";
        try (Connection conn = BDConexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRut(rs.getString("rut"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setCorreo(rs.getString("correo"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setTelefonoContacto(rs.getString("telefono_contacto"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar proveedores: " + e.getMessage());
        }
        return proveedores;
    }
}