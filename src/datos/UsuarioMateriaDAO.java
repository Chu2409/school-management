package datos;

import domain.UsuarioMateria;
import java.util.*;
import java.sql.*;

public class UsuarioMateriaDAO {

    public List<UsuarioMateria> seleccionar() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<UsuarioMateria> usuariosMaterias = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia");
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioMateria usuarioMateria = new UsuarioMateria();
                usuarioMateria.setId(rs.getInt("id"));
                usuarioMateria.setMateriaId(rs.getInt("materia_id"));
                usuarioMateria.setUsuarioRolId(rs.getInt("usuario_rol_id"));
                usuariosMaterias.add(usuarioMateria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuariosMaterias;
    }

    public void insertar(UsuarioMateria usuarioMateria) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO usuario_materia(materia_id, usuario_rol_id) VALUES(?, ?)");
            pst.setInt(1, usuarioMateria.getMateriaId());
            pst.setInt(2, usuarioMateria.getUsuarioRolId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public List<Integer> verificarAluAso(int usuarioRolId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Integer> estudiantesId = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT id FROM usuario_materia WHERE usuario_rol_id = ?");
            pst.setInt(1, usuarioRolId);
            rs = pst.executeQuery();
            while (rs.next()) {
                estudiantesId.add(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return estudiantesId;
    }

    public List<Integer> materiasByProfesor(int usuarioRolId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Integer> estudiantesId = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT materia_id FROM usuario_materia WHERE usuario_rol_id = ?");
            pst.setInt(1, usuarioRolId);
            rs = pst.executeQuery();
            while (rs.next()) {
                estudiantesId.add(rs.getInt("materia_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return estudiantesId;
    }
    
    public List<Integer> usuariosAsociados(int usuarioRolId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Integer> estudiantesId = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT id FROM usuario_materia WHERE materia_id = ?");
            pst.setInt(1, usuarioRolId);
            rs = pst.executeQuery();
            while (rs.next()) {
                estudiantesId.add(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return estudiantesId;
    }

    public List<Integer> estudiantesIdByMateria(int materiaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Integer> estudiantesId = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT id FROM usuario_materia WHERE materia_id = ? AND usuario_rol_id IN (SELECT id FROM usuario_rol WHERE rol_id = 1 OR rol_id = 2)");
            pst.setInt(1, materiaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                estudiantesId.add(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return estudiantesId;
    }

    public UsuarioMateria estudianteEnMateria (int materiaId, String correo) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioMateria um = new UsuarioMateria();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia WHERE materia_id = ? AND usuario_rol_id IN (SELECT id FROM usuario_rol WHERE rol_id = 1 AND usuario_id IN (SELECT id FROM usuarios WHERE email = ?))");
            pst.setInt(1, materiaId);
            pst.setString(2, correo);
            rs = pst.executeQuery();
            while (rs.next()) {
                um.setId(rs.getInt("id"));
                um.setMateriaId(rs.getInt("materia_id"));
                um.setUsuarioRolId(rs.getInt("usuario_rol_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return um;
    }

    public UsuarioMateria estudianteByMateriaEstudiante(int materiaId, int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioMateria um = new UsuarioMateria();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia WHERE materia_id = ? AND usuario_rol_id = ?");
            pst.setInt(1, materiaId);
            pst.setInt(2, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                um.setId(rs.getInt("id"));
                um.setMateriaId(rs.getInt("materia_id"));
                um.setUsuarioRolId(rs.getInt("usuario_rol_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return um;
    }
    
    public UsuarioMateria profesorByMateria(int materiaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioMateria um = new UsuarioMateria();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia WHERE materia_id = ? AND usuario_rol_id IN (SELECT id FROM usuario_rol WHERE rol_id = 2)");
            pst.setInt(1, materiaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                um.setId(rs.getInt("id"));
                um.setMateriaId(rs.getInt("materia_id"));
                um.setUsuarioRolId(rs.getInt("usuario_rol_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return um;
    }
    
    public int obtenerUltimo() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;

        try {
            pst = conn.prepareStatement("SELECT MAX(id) AS id_aux FROM usuario_materia");
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
}
