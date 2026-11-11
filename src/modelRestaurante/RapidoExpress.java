public class RapidoExpress implements EmpresaDomicilio {

    // Atributos de la clase
    private double tarifa = 5000;
    private double tarifaKilometro = 1500;
    private double maxKilometros = 12;


    public String getNombre() {
        return "RapidoExpress";
    }

    /**
     * metodo para calcular el costo desde la clase
     * @param km del recorrido
     * @return
     */
    public double calcularCosto(double km) {
        return tarifa + (tarifaKilometro * km);
    }

    /**
     * metodo para aceptar el recorrido desde la clase RapidoExpress
     * @param km del recorrido
     * @return
     */
    public boolean aceptarRecorrido(double km) {
        return km > 0 && km <= maxKilometros;
    }

    /**
     * metodo para solicitar el servicio desde la clase RapidoExpress
     * @param km del recorrido
     * @return
     */
    public boolean solicitarServicio(double km) {
        return aceptarRecorrido(km);
    }
}
