package huevitos.huevitos.Model;

import huevitos.huevitos.Enum.TipoHuevo;

import java.time.LocalDate;

public class Produccion {
    private TipoHuevo tipoHuevo;
    private int cantidad;
    private LoteGallinas loteGallinas;
    private LocalDate fecha;

    public Produccion(){

    }

    public Produccion(TipoHuevo tipoHuevo, int cantidad, LoteGallinas loteGallinas, LocalDate fecha) {
        this.tipoHuevo = tipoHuevo;
        this.cantidad = cantidad;
        this.loteGallinas = loteGallinas;
        this.fecha = fecha;
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

    public LoteGallinas getLoteGallinas() {
        return loteGallinas;
    }

    public void setLoteGallinas(LoteGallinas loteGallinas) {
        this.loteGallinas = loteGallinas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
