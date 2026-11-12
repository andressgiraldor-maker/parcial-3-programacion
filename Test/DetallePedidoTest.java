import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de DetallePedido
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class DetallePedidoTest {

    Producto producto1 = new Bebida(123, "Jugo", "Rico", 4000, 5,
            500, 5, "fria", false);
    DetallePedido detalle = new DetallePedido(producto1, 2);

    @Test
    void calcularSubtotal() {
        assertEquals(8800, detalle.calcularSubtotal());
    }

    @Test
    void calcularSubtotal_variasUnidades() {
        DetallePedido detalle = new DetallePedido(producto1, 3);

        assertEquals(13200, detalle.calcularSubtotal());
    }

    @Test
    void esCantidadValida() {
        assertTrue(detalle.esCantidadValida());
    }

    @Test
    void esCantidadValida_cero() {
        DetallePedido detalle = new DetallePedido(producto1, 0);

        assertFalse(detalle.esCantidadValida());
    }

    @Test
    void esCantidadValida_negativa() {
        DetallePedido detalle = new DetallePedido(producto1, -1);

        assertFalse(detalle.esCantidadValida());
    }
}