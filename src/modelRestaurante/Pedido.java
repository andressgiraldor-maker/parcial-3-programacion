import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    //Atributos de la clase Pedido
    private int codigo;
    private LocalDate fecha;
    Cliente cliente;
    EmpresaDomicilio empresa;
    ModalidaEntrega entrega;
    EstadoPedido estado;
    private double distanciaKm;
    private boolean servicioAceptado;
    private double costoDomicilio;

    //Relaciones de la clase Pedido
    private List<DetallePedido> listPedidoDetallePedidos;

    /**
     * metodo constructor de la clase Pedido
     * @param codigo del pedido
     * @param fecha del pedido
     * @param cliente del pedido
     * @param distanciaKm del pedido
     * @param servicioAceptado del pedido
     * @param costoDomicilio del pedido
     */
    public Pedido(int codigo, LocalDate fecha, Cliente cliente, double distanciaKm, boolean servicioAceptado, double costoDomicilio, ModalidaEntrega entrega, EstadoPedido estado) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.entrega = entrega;
        this.estado = estado;
        this.distanciaKm = distanciaKm;
        this.servicioAceptado = false;
        this.costoDomicilio = 0;
        this.listPedidoDetallePedidos = new ArrayList<>();
    }

    /**
     * metodo para agregar un detalle pedido (solo si esta pendiente)
     * @param producto del detalle
     * @param cantidad del detalle
     * @return
     */
    public boolean agregarDetalle(Producto producto, int cantidad) {
        if (estado != EstadoPedido.PENDIENTE || producto == null) {
            return false;
        }
        listPedidoDetallePedidos.add(new DetallePedido(producto, cantidad));
        return true;
    }

    /**
     * metodo para solicitar un domicilio a la empresa de domicilios
     * @param empresa empresaDomicilio
     * @param distanciaKm del pedido
     * @return
     */
    public boolean solicitarDomicilio(EmpresaDomicilio empresa, double distanciaKm) {
        if (entrega != ModalidaEntrega.DOMICILIO || empresa == null
                || estado != EstadoPedido.PENDIENTE) {
            return false;
        }
        if (empresa.solicitarServicio(distanciaKm)) {
            this.empresa = empresa;
            this.distanciaKm = distanciaKm;
            this.servicioAceptado = true;
            this.costoDomicilio = empresa.calcularCosto(distanciaKm);
            return true;
        }
        return false;
    }

    /**
     * metodo para calcular el valor total de los productos
     * @return
     */
    public double calcularValorProductos() {
        double total = 0;
        for (DetallePedido detalle : listPedidoDetallePedidos) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    /**
     * metodo para saber si los productos cumplen la calidad requerida
     * @return
     */
    public boolean todosCumplenCalidad() {
        for (DetallePedido detalle : listPedidoDetallePedidos) {
            if (!detalle.getProducto().cumpleCondicionesCalidad()) {
                return false;
            }
        }
        return true;
    }

    /**
     * metodo para validar que las cantidades de los pedido sean mayores que cero y que tengan al menos un detaller
     * @return
     */
    public boolean cantidadesValidas() {
        if (listPedidoDetallePedidos.size() == 0) {
            return false;
        }
        for (DetallePedido detalle : listPedidoDetallePedidos) {
            if (detalle.getCantidad() <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * metodo para confirmar un pedido
     * @return
     */
    public boolean confirmar() {
        if (estado != EstadoPedido.PENDIENTE || cliente == null) {
            return false;
        }
        if (!cantidadesValidas() || !todosCumplenCalidad()) {
            return false;
        }
        if (entrega == ModalidaEntrega.DOMICILIO && !servicioAceptado) {
            return false;
        }
        estado = EstadoPedido.CONFIRMADO;
        return true;
    }

    /**
     * metodo para marcar un pedido entregado
     * @return
     */
    public boolean marcarEntregado() {
        if (estado != EstadoPedido.CONFIRMADO) {
            return false;
        }
        estado = EstadoPedido.ENTREGADO;
        return true;
    }

    /**
     * metodo para cancelar un pedido
     * @return
     */
    public boolean cancelar() {
        if (estado == EstadoPedido.ENTREGADO || estado == EstadoPedido.CONFIRMADO || estado == EstadoPedido.PENDIENTE) {
            return false;
        }
        estado = EstadoPedido.CANCELADO;
        return true;
    }

    //-----------------------------------
    //GETTERS Y SETTERS
    //-----------------------------------
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ModalidaEntrega getEntrega() {
        return entrega;
    }

    public void setEntrega(ModalidaEntrega entrega) {
        this.entrega = entrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getListPedidoDetallePedidos() {
        return listPedidoDetallePedidos;
    }

    public void setListPedidoDetallePedidos(List<DetallePedido> listPedidoDetallePedidos) {
        this.listPedidoDetallePedidos = listPedidoDetallePedidos;
    }

    public EmpresaDomicilio getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDomicilio empresa) {
        this.empresa = empresa;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public boolean isServicioAceptado() {
        return servicioAceptado;
    }

    public void setServicioAceptado(boolean servicioAceptado) {
        this.servicioAceptado = servicioAceptado;
    }

    public double getCostoDomicilio() {
        return costoDomicilio;
    }

    public void setCostoDomicilio(double costoDomicilio) {
        this.costoDomicilio = costoDomicilio;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo + "\n" +
                ", fecha=" + fecha + "\n" +
                ", cliente=" + cliente + "\n" +
                ", entrega=" + entrega + "\n" +
                ", estado=" + estado + "\n" +
                ", listPedidoDetallePedidos=" + listPedidoDetallePedidos + "\n" +
                '}';
    }
}
