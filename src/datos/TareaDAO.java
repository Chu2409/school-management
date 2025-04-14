package datos;

import domain.Tarea;
import java.sql.*;
import java.util.*;

public class TareaDAO {
    
    public List<Tarea> seleccionar() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;       
        List<Tarea> tareas = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM tareas");
            rs = pst.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(rs.getInt("id"));
                tarea.setTarea(rs.getString("tarea"));
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setUbicacion(rs.getString("ubicacion"));              
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return tareas;
    }
    
    public void insertar(Tarea tarea) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO tareas(tarea, descripcion, ubicacion) VALUES(?, ?, ?)");
            pst.setString(1, tarea.getTarea());
            pst.setString(2, tarea.getDescripcion());
            pst.setString(3, tarea.getUbicacion());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }
    
    public int obtenerUltimo() {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;

        try {
            pst = conn.prepareStatement("SELECT MAX(id) AS id_aux FROM tareas");
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

    public Tarea tareaBytareaId(int tareaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tarea t = new Tarea();

        try {
            pst = conn.prepareStatement("SELECT * FROM tareas WHERE id IN (SELECT tarea_id FROM usuario_materia_tarea WHERE tarea_id = ?)");
            pst.setInt(1, tareaId);
            rs = pst.executeQuery();
            while (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setTarea(rs.getString("tarea"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setUbicacion(rs.getString("ubicacion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return t;
    }

    public Tarea tareaByName(String tareaNombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tarea t = new Tarea();

        try {
            pst = conn.prepareStatement("SELECT * FROM tareas WHERE tarea = ?");
            pst.setString(1, tareaNombre);
            rs = pst.executeQuery();
            while (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setTarea(rs.getString("tarea"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setUbicacion(rs.getString("ubicacion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return t;
    }

    public List<Tarea> tareasByProfesor(int profesorId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;       
        List<Tarea> tareas = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM tareas WHERE id IN (SELECT tarea_id FROM usuario_materia_tarea WHERE usuario_materia_id = ?)");
            pst.setInt(1, profesorId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(rs.getInt("id"));
                tarea.setTarea(rs.getString("tarea"));
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setUbicacion(rs.getString("ubicacion"));              
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return tareas;
    }  
}
