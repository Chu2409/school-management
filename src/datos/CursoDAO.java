package datos;

import domain.Curso;
import java.util.*;
import java.sql.*;

public class CursoDAO {

    public List<Curso> seleccionar(String cursoNombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        String query = cursoNombre.isEmpty() ? "SELECT * FROM cursos" : "SELECT * FROM cursos WHERE curso LIKE '%" + cursoNombre + "%'";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setCurso(rs.getString("curso"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return cursos;
    }

    public void insertar(Curso curso) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO cursos(curso) VALUES(?)");
            pst.setString(1, curso.getCurso());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public void actualizar(Curso curso) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("UPDATE cursos SET curso = ? WHERE id = ?");
            pst.setString(1, curso.getCurso());
            pst.setInt(2, curso.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public int eliminar(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        int registros = 0;

        try {
            pst = conn.prepareStatement("DELETE FROM cursos WHERE id = ?");
            pst.setInt(1, id);
            registros = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return registros;
    }

    public String obtenerNombreCurso(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombreCurso = null;

        try {
            pst = conn.prepareStatement("SELECT curso FROM cursos WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                nombreCurso = rs.getString("curso");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return nombreCurso;
    }

    public Curso obtenerCurso(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Curso curso = new Curso();

        try {
            pst = conn.prepareStatement("SELECT * FROM cursos WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setCurso(rs.getString("curso"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return curso;
    }

    public List<Curso> cursosByEstudianteId(int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM cursos WHERE id IN (SELECT curso_id FROM materias WHERE id IN (SELECT materia_id FROM usuario_materia WHERE usuario_rol_id = ?))");
            pst.setInt(1, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setCurso(rs.getString("curso"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return cursos;
    }
}
