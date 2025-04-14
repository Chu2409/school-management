package datos;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMateriaTareaDAO {

    public void insertar(UsuarioMateriaTarea usuarioTarea) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO usuario_materia_tarea(tarea_id, nota, envio, usuario_materia_id) VALUES(?, ?, ?, ?)");
            pst.setInt(1, usuarioTarea.getTareaId());
            pst.setDouble(2, usuarioTarea.getNota());
            pst.setString(3, usuarioTarea.getEnvio());
            pst.setInt(4, usuarioTarea.getUsuarioMateriaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public void actualizar(UsuarioMateriaTarea usuarioTarea) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("UPDATE usuario_materia_tarea SET tarea_id = ?, nota = ?, envio = ?, usuario_materia_id = ? WHERE id = ?");
            pst.setInt(1, usuarioTarea.getTareaId());
            pst.setDouble(2, usuarioTarea.getNota());
            pst.setString(3, usuarioTarea.getEnvio());
            pst.setInt(4, usuarioTarea.getUsuarioMateriaId());
            pst.setInt(5, usuarioTarea.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }
    
    public List<UsuarioMateriaTarea> tareasByMatUsuId(int materiaId, int usuarioId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<UsuarioMateriaTarea> usuariosTareas = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia_tarea WHERE usuario_materia_id IN (SELECT id FROM usuario_materia WHERE materia_id = ? AND usuario_rol_id IN (SELECT id FROM usuario_rol WHERE usuario_id IN (SELECT id FROM usuarios WHERE id = ?)));");
            pst.setInt(1, materiaId);
            pst.setInt(2, usuarioId);
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioMateriaTarea usuarioTarea = new UsuarioMateriaTarea();
                usuarioTarea.setId(rs.getInt("id"));
                usuarioTarea.setTareaId(rs.getInt("tarea_id"));
                usuarioTarea.setNota(rs.getDouble("nota"));
                usuarioTarea.setEnvio(rs.getString("envio"));
                usuarioTarea.setUsuarioMateriaId(rs.getInt("usuario_materia_id"));
                usuariosTareas.add(usuarioTarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuariosTareas;
    }
    
    public UsuarioMateriaTarea tareaByTareaUsuario(int tareaId, int usuarioMateriaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioMateriaTarea umt = new UsuarioMateriaTarea();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia_tarea WHERE tarea_id = ? AND usuario_materia_id = ?");
            pst.setInt(1, tareaId);
            pst.setInt(2, usuarioMateriaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                umt.setId(rs.getInt("id"));
                umt.setTareaId(rs.getInt("tarea_id"));
                umt.setNota(rs.getDouble("nota"));
                umt.setEnvio(rs.getString("envio"));
                umt.setUsuarioMateriaId(rs.getInt("usuario_materia_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return umt;
    }    
    
    public List<UsuarioMateriaTarea> tareasByEstudianteId(int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<UsuarioMateriaTarea> usuariosTareas = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia_tarea WHERE usuario_materia_id IN (SELECT id FROM usuario_materia WHERE usuario_rol_id = ?)");
            pst.setInt(1, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioMateriaTarea usuarioTarea = new UsuarioMateriaTarea();
                usuarioTarea.setId(rs.getInt("id"));
                usuarioTarea.setTareaId(rs.getInt("tarea_id"));
                usuarioTarea.setNota(rs.getDouble("nota"));
                usuarioTarea.setEnvio(rs.getString("envio"));
                usuarioTarea.setUsuarioMateriaId(rs.getInt("usuario_materia_id"));
                usuariosTareas.add(usuarioTarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuariosTareas;
    }
    
    public List<UsuarioMateriaTarea> tareasByEstudianteIdNombre(String tareaBuscar, int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<UsuarioMateriaTarea> usuariosTareas = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM usuario_materia_tarea WHERE usuario_materia_id IN (SELECT id FROM usuario_materia WHERE usuario_rol_id = ?) AND tarea_id IN (SELECT id FROM tareas WHERE tarea LIKE '%" + tareaBuscar + "%' )");
            pst.setInt(1, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioMateriaTarea usuarioTarea = new UsuarioMateriaTarea();
                usuarioTarea.setId(rs.getInt("id"));
                usuarioTarea.setTareaId(rs.getInt("tarea_id"));
                usuarioTarea.setNota(rs.getDouble("nota"));
                usuarioTarea.setEnvio(rs.getString("envio"));
                usuarioTarea.setUsuarioMateriaId(rs.getInt("usuario_materia_id"));
                usuariosTareas.add(usuarioTarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return usuariosTareas;
    }   
}
