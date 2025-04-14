package domain;

public class Curso {
    private int id;
    private String curso;
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + this.getId() + ", curso=" + this.getCurso() + '}';
    }
       
    
}
