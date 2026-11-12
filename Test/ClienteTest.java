import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de Cliente
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class ClienteTest {
    Cliente cliente = new Cliente(1094, "Ana Gomez", 30012,
                        "ana@correo.com", "Calle 10 #5-20");
    Pedido pedido = new Pedido(1234567, LocalDate.now(),cliente,5,true,2000, ModalidaEntrega.DOMICILIO,EstadoPedido.PENDIENTE);

    @Test
    void agregarPedidoAUnCliente() {
        boolean agregado = cliente.agregarPedidoAUnCliente(pedido);
        assertTrue(agregado);
    }
}