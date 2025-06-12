package huevitos.huevitos.Model;

import java.time.LocalDate;

public class Venta {
    private Cliente cliente;
    private CubetaHuevo cubetaHuevo;
    private int cantidad;
    private LocalDate fecha;
    private boolean pago;
    private LocalDate fechaPago;

    public Venta() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CubetaHuevo getCubetaHuevo() {
        return cubetaHuevo;
    }

    public void setCubetaHuevo(CubetaHuevo cubetaHuevo) {
        this.cubetaHuevo = cubetaHuevo;
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

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
