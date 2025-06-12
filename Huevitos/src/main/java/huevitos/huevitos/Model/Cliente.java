package huevitos.huevitos.Model;

public class Cliente extends Persona {
    private String numeroCelular;

    public Cliente() {
    }

    public Cliente(String nombre, String numeroCelular) {
        super(nombre);
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
