import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de Restaurante
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class RestauranteTest {
    Restaurante restaurante = new Restaurante("el sabroso", "123", "carrera 14 #12-14");
    Producto bebidaValida = new Bebida(123456, "Jugo", "Frio", 4000, 5,
            500, 5, "fria", false);
    Producto bebidaInvalida = new Bebida(876543, "Jugo tibio", "Tibio", 4000, 5,
            500, 15, "fria", false);
    Cliente cliente = new Cliente(109, "raul", 300123, "raul@correo.com", "Calle 10 #5-20");
    Pedido pedido = new Pedido(34567876, LocalDate.now(), cliente,
                0, false, 0, ModalidaEntrega.EN_RESTAURANTE, EstadoPedido.PENDIENTE);


    @Test
    void calcularTotalPedido(){
        restaurante.agregarClienteARestaurante(109, "raul", 300123, "raul@correo.com", "Calle 10 #5-20");
        restaurante.agregarProductoARestaurante(bebidaValida);
        pedido.agregarDetalle(bebidaValida, 2);
        restaurante.confirmarPedido(pedido);

        assertEquals(8800, restaurante.calcularTotalPedido(34567876));
        assertEquals(0, restaurante.calcularTotalPedido(99999));
    }


    @Test
    void confirmarPedido() {
        restaurante.agregarProductoARestaurante(bebidaValida);
        pedido.agregarDetalle(bebidaValida, 1);

        // cliente NO registrado
        assertFalse(restaurante.confirmarPedido(pedido));

        // cliente registrado
        restaurante.agregarClienteARestaurante(109, "raul", 300123, "raul@correo.com", "Calle 10 #5-20");
        assertTrue(restaurante.confirmarPedido(pedido));
        assertEquals(EstadoPedido.CONFIRMADO, pedido.getEstado());
    }

    @Test
    void consultarHistorialCliente() {
        restaurante.agregarClienteARestaurante(109, "raul", 300123, "raul@correo.com", "Calle 10 #5-20");
        restaurante.agregarProductoARestaurante(bebidaValida);
        pedido.agregarDetalle(bebidaValida, 1);
        restaurante.confirmarPedido(pedido);

        String historial = restaurante.consultarHistorialCliente(cliente.getDocumento());

        assertTrue(cliente.getListClientePedidos().size() == 1);
    }

    @Test
    void consultarProductosDisponibles() {
        restaurante.agregarProductoARestaurante(bebidaValida);
        restaurante.agregarProductoARestaurante(bebidaInvalida);

        assertEquals(1, restaurante.consultarProductosDisponibles().size());
    }

    @Test
    void calcularIngresos() {
        restaurante.agregarClienteARestaurante(109, "raul", 300123, "raul@correo.com", "Calle 10 #5-20");
        restaurante.agregarProductoARestaurante(bebidaValida);
        pedido.agregarDetalle(bebidaValida, 2);
        restaurante.confirmarPedido(pedido);

        assertEquals(8800, restaurante.calcularIngresos(), 0.001);
    }
}