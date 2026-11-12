public class DetallePedido {
    //Atributos de la clase
    Producto producto;
    private double cantidad;

    //Relaciones de la clase Detalle pedido

    /**
     * metodo constuctor de la clase Detalle pedido
     * @param producto del detalle
     * @param cantidad del detalle
     */
    public DetallePedido(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * metodo para calcular el subtotal de un pedido solicitado
     * @return
     */
    public double calcularSubtotal() {
        return producto.calcularPrecioVenta() * cantidad;
    }

    /**
     * metodo para verificar que una cantidad se valida
     * @return
     */
    public boolean esCantidadValida() {
        return cantidad > 0;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto=" + producto + "\n" +
                ", cantidad=" + cantidad + "\n" +
                '}';
    }
}
