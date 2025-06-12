package huevitos.huevitos.Model;

import java.time.LocalDate;
import java.util.Date;

public class LoteGallinas {
    private int idLote;
    private int cantidadGallinas;
    private int promedioSemanas;
    private LocalDate fechaIngreso;
    public boolean activo;

    public LoteGallinas() {
    }

    public LoteGallinas(int idLote, int cantidadGallinas, int promedioSemanas, LocalDate fechaIngreso, boolean activo) {
        this.idLote = idLote;
        this.cantidadGallinas = cantidadGallinas;
        this.promedioSemanas = promedioSemanas;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getCantidadGallinas() {
        return cantidadGallinas;
    }

    public void setCantidadGallinas(int cantidadGallinas) {
        this.cantidadGallinas = cantidadGallinas;
    }

    public int getPromedioSemanas() {
        return promedioSemanas;
    }

    public void setPromedioSemanas(int promedioSemanas) {
        this.promedioSemanas = promedioSemanas;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
