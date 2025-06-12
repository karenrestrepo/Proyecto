package huevitos.huevitos.Model;

import java.time.LocalDate;

public class Perdida {
    private LocalDate fecha;
    private String tipo;
    private String articulo;
    private int cantidad;
    private String Descripcion;

    public Perdida(){}

    public Perdida(LocalDate fecha, String tipo, String articulo, int cantidad, String descripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.articulo = articulo;
        this.cantidad = cantidad;
        Descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
