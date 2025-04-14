package domain;

public class Materia {
    
    private int id;
    private String materia;
    private int cursoId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCursoId() {
        return this.cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + this.getId() + ", materia=" + this.getMateria() + ", cursoId=" + this.getCursoId() + '}';
    }  
    
    
}
