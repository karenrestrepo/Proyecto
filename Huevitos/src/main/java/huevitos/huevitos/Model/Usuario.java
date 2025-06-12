package huevitos.huevitos.Model;

public class Usuario extends Persona {
    private String correo;
    private String contrasena;
    private Negocio negocio;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena, Negocio negocio) {
        super(nombre);
        this.correo = correo;
        this.contrasena = contrasena;
        this.negocio = negocio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Negocio getEmpresa() {
        return negocio;
    }

    public void setEmpresa(Negocio negocio) {
        this.negocio = negocio;
    }
}
