package domain;

public class UsuarioMateria {
    
    private int id;
    private int materiaId;
    private int usuarioRolId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMateriaId() {
        return this.materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public int getUsuarioRolId() {
        return this.usuarioRolId;
    }

    public void setUsuarioRolId(int usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    @Override
    public String toString() {
        return "UsuarioMateria{" + "id=" + this.getId() + ", materiaId=" + this.getMateriaId() + ", usuarioRolId=" + this.getUsuarioRolId() + '}';
    }

    
    
}
