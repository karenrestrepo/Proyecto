package huevitos.huevitos.Model;

import huevitos.huevitos.Enum.TipoCubeta;
import huevitos.huevitos.Enum.TipoHuevo;

public class CubetaHuevo {
    private TipoCubeta tipoCubeta;
    private TipoHuevo tipoHuevo;
    private double precio;

    public CubetaHuevo() {
    }

    public TipoHuevo getTipoHuevo() {
        return tipoHuevo;
    }

    public void setTipoHuevo(TipoHuevo tipoHuevo) {
        this.tipoHuevo = tipoHuevo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoCubeta getTipoCubeta() {
        return tipoCubeta;
    }

    public void setTipoCubeta(TipoCubeta tipoCubeta) {
        this.tipoCubeta = tipoCubeta;
    }
}
