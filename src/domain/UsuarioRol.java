package domain;

public class UsuarioRol {
    
    private int id;
    private int usuarioId;
    private int rolId;
  
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getRolId() {
        return this.rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public String toString() {
        return "PersonaRol{" + "id=" + this.getId() + ", usuarioId=" + this.getUsuarioId() + ", rolId=" + this.getRolId() + '}';
    }
    
    
    
}
