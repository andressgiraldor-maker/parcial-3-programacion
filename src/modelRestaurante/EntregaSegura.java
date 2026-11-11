public class EntregaSegura implements EmpresaDomicilio {

    //Atributos de la clase
    private double tarifa;
    private double tarifaKilometro;


    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public double calcularCosto() {
        return 0;
    }

    @Override
    public boolean aceptarRecorrido() {
        return false;
    }

    @Override
    public boolean solicitarServicio() {
        return false;
    }
}
