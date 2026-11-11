public class EntregaSegura implements EmpresaDomicilio {

    // Atributos de la clase
    private double tarifa = 7000;
    private double tarifaKilometro = 1000;
    private double recargo = 3000;
    private double maxKilometros = 20;


    public String getNombre() {
        return "EntregaSegura";
    }

    /**
     * metodo para calcular el costo desde la clase EntregaSegura
     * @param km distancia del recorrido
     * @return
     */
    public double calcularCosto(double km) {
        double costo = tarifa + (tarifaKilometro * km);
        if (km > 5) {
            costo += recargo;
        }
        return costo;
    }

    /**
     * metodo para verificar si se acepta el recorrido desde la clase EntregaSegura
     * @param km del recorrido
     * @return
     */
    public boolean aceptarRecorrido(double km) {
        return km > 0 && km <= maxKilometros;
    }

    /**
     * metodo para solicitar el servicio desde la clase EntregSegura
     * @param km del recorrido
     * @return
     */
    public boolean solicitarServicio(double km) {
        return aceptarRecorrido(km);
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifaKilometro() {
        return tarifaKilometro;
    }

    public void setTarifaKilometro(double tarifaKilometro) {
        this.tarifaKilometro = tarifaKilometro;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getMaxKilometros() {
        return maxKilometros;
    }

    public void setMaxKilometros(double maxKilometros) {
        this.maxKilometros = maxKilometros;
    }

    @Override
    public String toString() {
        return "EntregaSegura{" +
                "tarifa=" + tarifa + "\n" +
                ", tarifaKilometro=" + tarifaKilometro + "\n" +
                ", recargo=" + recargo + "\n" +
                ", maxKilometros=" + maxKilometros + "\n" +
                '}';
    }
}
