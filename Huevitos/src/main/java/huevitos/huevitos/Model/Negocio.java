package huevitos.huevitos.Model;

import java.util.List;

public class Negocio {
    private String nombreNegocio;
    private Usuario propietario;
    private List<Usuario> listaEmpleados;
    private List<Produccion> listaProducciones;
    private List<Egreso> listaEgresos;
    private List<Cliente> listaClientes;
    private List<Venta> listaVentas;
    private List<LoteGallinas> listaLotes;

    public Negocio() {
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public List<Usuario> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Usuario> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Produccion> getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(List<Produccion> listaProducciones) {
        this.listaProducciones = listaProducciones;
    }

    public List<Egreso> getListaGastos() {
        return listaEgresos;
    }

    public void setListaGastos(List<Egreso> listaEgresos) {
        this.listaEgresos = listaEgresos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<LoteGallinas> getListaLotes() {
        return listaLotes;
    }

    public void setListaLotes(List<LoteGallinas> listaLotes) {
        this.listaLotes = listaLotes;
    }
}
