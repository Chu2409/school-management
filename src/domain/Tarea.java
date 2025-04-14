package domain;

public class Tarea {

    private int id;
    private String tarea;
    private String descripcion;
    private String ubicacion;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return this.tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + this.getId() + ", tarea=" + this.getTarea() + ", descripcion=" + this.getDescripcion() + ", ubicacion=" + this.getUbicacion() + '}';
    }

}
