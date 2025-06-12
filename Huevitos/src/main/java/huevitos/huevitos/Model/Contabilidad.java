package huevitos.huevitos.Model;

public class Contabilidad {
    private double totalIngresos;
    private double totalEgresos;
    private double saldo;
    private double cuentasPorCobrar;

    public Contabilidad(){

    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public double getTotalEgresos() {
        return totalEgresos;
    }

    public void setTotalEgresos(double totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCuentasPorCobrar() {
        return cuentasPorCobrar;
    }

    public void setCuentasPorCobrar(double cuentasPorCobrar) {
        this.cuentasPorCobrar = cuentasPorCobrar;
    }
}
