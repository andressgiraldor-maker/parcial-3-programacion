public class PlatoFuerte  extends Producto{

    //Atributos de la clase
    private double peso;
    private String coccionAprobada;
    TipoPreparacion preparacion;

    //Relaicones de la clase Plato fuerte

    /**
     * metodo constructor de la clase Plato fuerte
     * @param codigo del plato
     * @param nombre del plato
     * @param descripcion del plato
     * @param precio del plato
     * @param tiempoPreparacion del plato
     * @param peso del plato
     * @param coccionAprobada del plato
     */
    public PlatoFuerte(int codigo, String nombre, String descripcion, double precio, int tiempoPreparacion, double peso, String coccionAprobada) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.peso = peso;
        this.coccionAprobada = coccionAprobada;
        this.preparacion = preparacion;
    }

    /**
     * metodo para calcular el precio de venta de un plato fuerte
     * @return
     */

    public double calcularPrecioVenta(){

        return getPrecio() * 1.20;

    }

    /**
     * metodo para verificar si cumple las condiciones de calidad desde la clase PlatoFuerte
     * @return
     */

    public boolean cumpleCondicionesCalidad(){

        return peso>=200 && peso<=900 && getTiempoPreparacion() >=10 && getTiempoPreparacion() <=60 && coccionAprobada.equals("si");

        }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCoccionAprobada() {
        return coccionAprobada;
    }

    public void setCoccionAprobada(String coccionAprobada) {
        this.coccionAprobada = coccionAprobada;
    }

    public TipoPreparacion getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(TipoPreparacion preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public String toString() {
        return "PlatoFuerte{" +
                "peso=" + peso + "\n" +
                ", coccionAprobada='" + coccionAprobada + "\n" +
                ", preparacion=" + preparacion + "\n" +
                '}';
    }
}

