public class Postre extends Producto {

    //Atributos de la clase
    private double peso;
    private double temperaturaAlmacenamiento;
    private String requiereRefigeracion;


    //Relaciones de la clase Postre

    /**
     * metodo constructor de la clase Poostre
     * @param codigo del postre
     * @param nombre del postre
     * @param descripcion del postre
     * @param precio del postre
     * @param tiempoPreparacion del postre
     * @param peso del postre
     * @param temperaturaAlmacenamiento del postre
     * @param requiereRefigeracion del postre
     */
    public Postre(int codigo, String nombre, String descripcion, double precio, int tiempoPreparacion, double peso, double temperaturaAlmacenamiento, String requiereRefigeracion) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.peso = peso;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefigeracion = requiereRefigeracion;
    }

    /**
     * metodo para calcular el precio de la venta desde la clae Postre
     * @return
     */

    public double calcularPrecioVenta(){
        double precioVenta= getPrecio() * 1.15;

        if(requiereRefigeracion.equals("si")){
            precioVenta+= getPrecio() * 0.05;
        }
        return precioVenta;
    }

    /**
     * metodo para verificar que cumpla las condicones de calidad desde la clase Postre
     * @return
     */

    public boolean cumpleCondicionesCalidad() {
        boolean pesoValido = peso >= 80 && peso <= 500;
        boolean temperaturaValida;

        if (requiereRefigeracion.equals("si")) {
            temperaturaValida = temperaturaAlmacenamiento >= 0 && temperaturaAlmacenamiento <= 6;
        } else {
            temperaturaValida = temperaturaAlmacenamiento >= 15 && temperaturaAlmacenamiento <= 30;
        }

        return pesoValido && temperaturaValida;
    }

    public String getRequiereRefigeracion() {
        return requiereRefigeracion;
    }

    public void setRequiereRefigeracion(String requiereRefigeracion) {
        this.requiereRefigeracion = requiereRefigeracion;
    }

    @Override
    public String toString() {
        return "Postre{" +
                "peso='" + peso + "\n" +
                ", temperaturaAlmacenamiento='" + temperaturaAlmacenamiento + "\n" +
                ", requiereRefigeracion='" + requiereRefigeracion + "\n" +
                '}';
    }
}
