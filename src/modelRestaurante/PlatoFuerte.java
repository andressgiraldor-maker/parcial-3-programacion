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
    public PlatoFuerte(int codigo, String nombre, String descripcion, double precio, String tiempoPreparacion, double peso, String coccionAprobada) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.peso = peso;
        this.coccionAprobada = coccionAprobada;
        this.preparacion = preparacion;
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
