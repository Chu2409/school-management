package domain;

public class Usuario {
    private int id;
    private String usuario;
    private String clave;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String fotografia;
    private int estado;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFotografia() {
        return this.fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + this.getId() + ", usuario=" + this.getUsuario() + ", clave=" + this.getClave() + ", cedula=" + this.getCedula() +
                ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", email=" + this.getEmail() + ", direccion=" + 
                this.getDireccion() + ", fotografia=" + this.getFotografia() + ", estado=" + this.getEstado()+ '}';
    }
    
    
}
