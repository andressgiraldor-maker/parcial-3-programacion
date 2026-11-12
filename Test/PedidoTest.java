import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de Pedido
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class PedidoTest {

    Cliente cliente = new Cliente(109, "raul", 300123,
                        "raul@correo.com", "Calle 10 #5-20");
    Producto bebida = new Bebida(124, "Jugo tibio", "Tibio", 4000, 5,
                       500, 15, "fria", false);
    Pedido pedido1 = new Pedido(1, LocalDate.now(), cliente, 0, false, 0, ModalidaEntrega.DOMICILIO, EstadoPedido.PENDIENTE);
    EmpresaDomicilio empresa = new EntregaSegura();


    @Test
    void agregarDetalle() {

        assertTrue(pedido1.agregarDetalle(bebida, 2));
        assertEquals(1, pedido1.getListPedidoDetallePedidos().size());

    }

    @Test
    void solicitarDomicilio() {

        Pedido pedido = new Pedido(23, LocalDate.now(), cliente,
                0, false, 0, ModalidaEntrega.DOMICILIO, EstadoPedido.PENDIENTE);

        boolean resultado = pedido.solicitarDomicilio(empresa, 5);

        System.out.println("resultado: " + resultado);
        System.out.println("estado: " + pedido.getEstado());
        System.out.println("costo: " + pedido.getCostoDomicilio());

        assertTrue(resultado);
        assertEquals(12000, pedido.getCostoDomicilio());
    }
    @Test
    void calcularValorProductos() {
        pedido1.agregarDetalle(bebida, 2);
        pedido1.solicitarDomicilio(new RapidoExpress(), 5);

        assertEquals(8800, pedido1.calcularValorProductos());
    }

    @Test
    void todosCumplenCalidad() {
        Pedido pedido2 = new Pedido(234,LocalDate.now(),cliente,
                5,true,1000,ModalidaEntrega.EN_RESTAURANTE,EstadoPedido.PENDIENTE);
        Bebida valida = new Bebida(125, "Jugo", "Frio", 4000, 5,
                500, 5, "fria", false);      // 5 °C: válida
        Bebida invalida = new Bebida(126, "Jugo tibio", "Tibio", 4000, 5,
                500, 15, "fria", false);     // 15 °C: inválida
        pedido2.agregarDetalle(valida, 1);
        assertTrue(pedido2.todosCumplenCalidad());

        pedido2.agregarDetalle(invalida, 1);
        assertFalse(pedido2.todosCumplenCalidad());
    }


    @Test
    void cantidadesValidas() {

        Bebida valida = new Bebida(127, "Jugo", "Frio", 4000, 5,
                500, 5, "fria", false);

        Pedido pedido3 = new Pedido(345, LocalDate.now(), cliente,
                0, false, 0, ModalidaEntrega.EN_RESTAURANTE, EstadoPedido.PENDIENTE);

        // pedido no válido
        assertFalse(pedido3.cantidadesValidas());

        // Con una cantidad positiva: válido
        pedido3.agregarDetalle(valida, 2);
        assertTrue(pedido3.cantidadesValidas());

        // Con una cantidad cero: deja de ser válido
        pedido3.agregarDetalle(valida, 0);
        assertFalse(pedido3.cantidadesValidas());
    }
}