package domain;

public class Rol {

    private int id;
    private String rol;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + this.getId() + ", rol=" + this.getRol() + '}';
    }

}
