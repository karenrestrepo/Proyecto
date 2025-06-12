package huevitos.huevitos.Model;

import huevitos.huevitos.Enum.TipoHuevo;

public class Huevo {
    private TipoHuevo tipoHuevo;
    private int cantidad;
    private LoteGallinas loteGallinas;

    public Huevo() {
    }

    public TipoHuevo getTipoHuevo() {
        return tipoHuevo;
    }

    public void setTipoHuevo(TipoHuevo tipoHuevo) {
        this.tipoHuevo = tipoHuevo;
    }
}
