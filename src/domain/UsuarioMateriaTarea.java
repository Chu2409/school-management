package domain;

public class UsuarioMateriaTarea {
    private int id;
    private int tareaId;
    private double nota;
    private String envio;
    private int usuarioMateriaId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTareaId() {
        return this.tareaId;
    }

    public void setTareaId(int tareaId) {
        this.tareaId = tareaId;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getEnvio() {
        return this.envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public int getUsuarioMateriaId() {
        return this.usuarioMateriaId;
    }

    public void setUsuarioMateriaId(int usuarioMateriaId) {
        this.usuarioMateriaId = usuarioMateriaId;
    }

    @Override
    public String toString() {
        return "UsuarioMateriaTarea{" + "id=" + this.getId() + ", tareaId=" + this.getTareaId() + ", nota=" + this.getNota() + ", envio=" +
                this.getEnvio() + ", usuarioMateriaId=" + this.getUsuarioMateriaId() + '}';
    }

    
    
}
