package huevitos.huevitos.Model;

import java.time.LocalDate;
import java.util.Date;

public class LoteGallinas {
    private int id;
    private int loteId;
    private int cantidadGallinas;
    private int semanas;
    private LocalDate fechaIngreso;
    private String raza;
    public boolean activo;
    private int negocioId;

    public LoteGallinas() {
    }

    public LoteGallinas(int loteId, int cantidadGallinas, int semanas,
                        LocalDate fechaIngreso, String raza, boolean activo, int negocioId) {
        this.loteId = loteId;
        this.cantidadGallinas = cantidadGallinas;
        this.semanas = semanas;
        this.fechaIngreso = fechaIngreso;
        this.raza = raza;
        this.activo = activo;
        this.negocioId = negocioId;
    }

    public double calcularPorcentajeProduccion(int huevosProducidos) {
        if (cantidadGallinas == 0) return 0;
        return (double) huevosProducidos / cantidadGallinas * 100;
    }

    public int calcularSemanasActuales() {
        if (fechaIngreso == null) return semanas;
        return semanas + (int) java.time.temporal.ChronoUnit.WEEKS.between(fechaIngreso, LocalDate.now());
    }

    public int getCantidadGallinas() {
        return cantidadGallinas;
    }

    public void setCantidadGallinas(int cantidadGallinas) {
        this.cantidadGallinas = cantidadGallinas;
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

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(int negocioId) {
        this.negocioId = negocioId;
    }
}
