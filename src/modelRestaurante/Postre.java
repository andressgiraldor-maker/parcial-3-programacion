public class Postre extends Producto {

    //Atributos de la clase
    private String peso;
    private String temperaturaAlmacenamiento;
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
    public Postre(int codigo, String nombre, String descripcion, double precio, String tiempoPreparacion, String peso, String temperaturaAlmacenamiento, String requiereRefigeracion) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.peso = peso;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefigeracion = requiereRefigeracion;
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
