package huevitos.huevitos.Model;

import huevitos.huevitos.Enum.TipoHuevo;

import java.time.LocalDate;

public class Produccion {
    private int id;
    private LocalDate fecha;
    private TipoHuevo tipoHuevo;
    private int cantidad;
    private int loteId; // Referencia al lote
    private double porcentajeProduccion;
    private int negocioId;

    public Produccion(){

    }

    public Produccion(LocalDate fecha, TipoHuevo tipoHuevo, int cantidad,
                      int loteId, int negocioId) {
        this.fecha = fecha;
        this.tipoHuevo = tipoHuevo;
        this.cantidad = cantidad;
        this.loteId = loteId;
        this.negocioId = negocioId;
    }

    public void calcularPorcentajeProduccion(LoteGallinas lote) {
        if (lote != null && lote.getCantidadGallinas() > 0) {
            this.porcentajeProduccion = (double) this.cantidad / lote.getCantidadGallinas() * 100;
        }
    }

    public TipoHuevo getTipoHuevo() {
        return tipoHuevo;
    }

    public void setTipoHuevo(TipoHuevo tipoHuevo) {
        this.tipoHuevo = tipoHuevo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public double getPorcentajeProduccion() {
        return porcentajeProduccion;
    }

    public void setPorcentajeProduccion(double porcentajeProduccion) {
        this.porcentajeProduccion = porcentajeProduccion;
    }

    public int getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(int negocioId) {
        this.negocioId = negocioId;
    }
}
