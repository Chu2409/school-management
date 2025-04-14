package datos;

import domain.UsuarioRol;
import java.util.*;
import java.sql.*;

public class UsuarioRolDAO {

    public List<UsuarioRol> seleccionar() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<UsuarioRol> usuariosRoles = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_rol");
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioRol usuarioRol = new UsuarioRol();
                usuarioRol.setId(rs.getInt("id"));
                usuarioRol.setUsuarioId(rs.getInt("usuario_id"));
                usuarioRol.setRolId(rs.getInt("rol_id"));
                usuariosRoles.add(usuarioRol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuariosRoles;
    }
    
    public void insertar(UsuarioRol usuarioRol) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO usuario_rol(usuario_id, rol_id) VALUES(?, ?)");
            pst.setInt(1, usuarioRol.getUsuarioId());
            pst.setInt(2, usuarioRol.getRolId());       
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }
    
    public void actualizar(UsuarioRol usuarioRol) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("UPDATE usuario_rol SET usuario_id = ?, rol_id = ? WHERE id = ?");
            pst.setInt(1, usuarioRol.getUsuarioId());
            pst.setInt(2, usuarioRol.getRolId());
            pst.setInt(3, usuarioRol.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }
    
    
    public void eliminar(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("DELETE FROM usuario_rol WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }
    
    
    public int obtenerId(int usuarioId, int rolId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;

        try {
            pst = conn.prepareStatement("SELECT id FROM usuario_rol WHERE usuario_id = " + usuarioId + " AND rol_id = " + rolId);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return id;
    }       
}
