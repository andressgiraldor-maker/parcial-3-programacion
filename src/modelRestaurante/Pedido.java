import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    //Atributos de la clase Pedido
    private int codigo;
    private LocalDate fecha;
    Cliente cliente;
    ModalidaEntrega entrega;
    EstadoPedido estado;

    //Relaciones de la clase Pedido
    private List<DetallePedido> listPedidoDetallePedidos;

    /**
     * metodo constructor de la clase Pedido
     * @param codigo del pedido
     * @param fecha del pedido
     * @param cliente que solicito el pedido
     */
    public Pedido(int codigo, LocalDate fecha, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.entrega = entrega;
        this.estado = estado;
        this.listPedidoDetallePedidos = new ArrayList<>();
    }

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
