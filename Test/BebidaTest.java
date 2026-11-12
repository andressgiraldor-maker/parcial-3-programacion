import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de Bebida
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class BebidaTest {
    Producto bebida = new Bebida(123, "jugo", "rico", 4000, 5,500,5,"frio", true);
    Bebida bebida2 = new Bebida(5, "Jugo", "Tibio", 3000, 5,
            500, 15, "fria", false);

    @org.junit.jupiter.api.Test
    void calcularPrecioVenta() {
        assertEquals(7400,bebida.calcularPrecioVenta());
    }

    @org.junit.jupiter.api.Test
    void cumpleCondicionesCalidad() {
        assertFalse(bebida.cumpleCondicionesCalidad());
    }
}