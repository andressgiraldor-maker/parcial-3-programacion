public class Bebida extends Producto{

    //Atributos de la clase
    private String volumen;
    private String temperatura;
    private String tipo;

    //Relaciones de la clase Bedida


    /**
     * metood constructor de la clase Bebida
     * @param codigo de la bebida
     * @param nombre de la bebida
     * @param descripcion de la bebida
     * @param precio de la bebida
     * @param tiempoPreparacion de la bebida
     * @param volumen de la bebida
     * @param temperatura de la bebida
     * @param tipo de la bebida
     */
    public Bebida(int codigo, String nombre, String descripcion, double precio, String tiempoPreparacion, String volumen, String temperatura, String tipo) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.volumen = volumen;
        this.temperatura = temperatura;
        this.tipo = tipo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "volumen='" + volumen + "\n" +
                ", temperatura='" + temperatura + "\n" +
                ", tipo='" + tipo + "\n" +
                '}';
    }
}
