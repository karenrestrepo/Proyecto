package huevitos.huevitos.Model;

import java.time.LocalDate;

public class Egreso {
    private String tipo;
    private String articulo;
    private int cantidad;
    private double valor;
    private LocalDate fecha;

    public Egreso() {
    }

    public Egreso(String tipo, String articulo, int cantidad, double valor, LocalDate fecha) {
        this.tipo = tipo;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
