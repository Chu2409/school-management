package datos;

import domain.Usuario;
import java.util.*;
import java.sql.*;

public class UsuarioDAO {

    public List<Usuario> seleccionar(String usuarioNombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        String query = usuarioNombre.isEmpty() ? "SELECT * FROM usuarios" : "SELECT * FROM usuarios WHERE usuario LIKE '%" + usuarioNombre + "%'";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public void insertar(Usuario usuario) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO usuarios(usuario, clave, cedula, nombre, apellido, email, direccion, fotografia) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getClave());
            pst.setString(3, usuario.getCedula());
            pst.setString(4, usuario.getNombre());
            pst.setString(5, usuario.getApellido());
            pst.setString(6, usuario.getEmail());
            pst.setString(7, usuario.getDireccion());
            pst.setString(8, usuario.getFotografia());          
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public void actualizar(Usuario usuario) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("UPDATE usuarios SET usuario = ?, clave = ?, cedula = ?, nombre = ?, apellido = ?, email = ?, direccion = ?, fotografia = ?, estado = ? WHERE id = ?");
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getClave());
            pst.setString(3, usuario.getCedula());
            pst.setString(4, usuario.getNombre());
            pst.setString(5, usuario.getApellido());
            pst.setString(6, usuario.getEmail());
            pst.setString(7, usuario.getDireccion());
            pst.setString(8, usuario.getFotografia());
            pst.setInt(9, usuario.getEstado());
            pst.setInt(10, usuario.getId());
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
            pst = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public Usuario obtenerPersona(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuario;
    }
    
    public int obtenerUltimo() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;

        try {
            pst = conn.prepareStatement("SELECT MAX(id) AS id_aux FROM usuarios");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_aux");
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
   
    public List<Usuario> listarEstuProf() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 1 OR rol_id = 2)");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public List<Usuario> listarEstudiantes() { //no usado
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 1)");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
     public List<Usuario> listarProfesores() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 2)");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    
    public List<Usuario> seleccionarByNameRol(int rolId, String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = ?) AND usuario LIKE '%" + nombre + "%'");
            pst.setInt(1, rolId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public List<Usuario> estudiantesByMateria(String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 1 OR rol_id = 2) AND usuario LIKE '%" + nombre + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public List<Usuario> estudiantesEnMateria(int materiaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 1 AND id IN (SELECT usuario_rol_id FROM usuario_materia WHERE materia_id = ?))");
            pst.setInt(1, materiaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public List<Usuario> estudiantesEnMateriaByName(int materiaId, String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE rol_id = 1 AND id IN (SELECT usuario_rol_id FROM usuario_materia WHERE materia_id = ?))"
                    + " AND (nombre LIKE '%" + nombre + "%' OR apellido LIKE '%" + nombre + "%')");
            pst.setInt(1, materiaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    public Usuario usuarioByUsuarioId(int usuarioId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM usuario_rol WHERE id = ?)");
            pst.setInt(1, usuarioId);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFotografia(rs.getString("fotografia"));
                usuario.setEstado(rs.getInt("estado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuario;
    }
}
