public class Bebida extends Producto {

    //Atributos de la clase
    private double volumen;
    private double temperatura;
    private String tipo;
    private boolean requierePreparacionEspecial;

    //Relaciones de la clase Bedida


    /**
     * metood constructor de la clase Bebida
     *
     * @param codigo            de la bebida
     * @param nombre            de la bebida
     * @param descripcion       de la bebida
     * @param precio            de la bebida
     * @param tiempoPreparacion de la bebida
     * @param volumen           de la bebida
     * @param temperatura       de la bebida
     * @param tipo              de la bebida
     */
    public Bebida(int codigo, String nombre, String descripcion, double precio, int tiempoPreparacion, double volumen, double temperatura, String tipo, boolean requierePreparacionEspecial) {
        super(codigo, nombre, descripcion, precio, tiempoPreparacion);
        this.volumen = volumen;
        this.temperatura = temperatura;
        this.tipo = tipo;
        this.requierePreparacionEspecial = requierePreparacionEspecial;

    }

    /**
     * metodo para clacular el precio de la venta desde la clase Bebida
     *
     * @return
     */

    public double calcularPrecioVenta() {
        double precioVenta = getPrecio() * 1.10;

        if (requierePreparacionEspecial) {
            precioVenta += 3000;

        }
        return precioVenta;

    }

    /**
     * metodo para verificar si cumple las conduciones de calidad desde la clase Bebida
     * @return
     */
    public boolean cumpleCondicionesCalidad() {
        boolean volumenValido = volumen >= 150 && volumen <= 1500;
        boolean temperaturaValida;

        if (tipo.equals("fria")) {
            temperaturaValida = temperatura >= 0 && temperatura <= 10;
        } else {
            temperaturaValida = temperatura >= 55 && temperatura <= 85;
        }

        return volumenValido && temperaturaValida;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isRequierePreparacionEspecial() {
        return requierePreparacionEspecial;
    }

    public void setRequierePreparacionEspecial(boolean requierePreparacionEspecial) {
        this.requierePreparacionEspecial = requierePreparacionEspecial;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "volumen=" + volumen + "\n" +
                ", temperatura=" + temperatura + "\n" +
                ", tipo='" + tipo + "\n" +
                ", requierePreparacionEspecial=" + requierePreparacionEspecial + "\n" +
                '}';
    }
}
