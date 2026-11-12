import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de RapidoExpress
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class RapidoExpressTest {

    RapidoExpress express = new RapidoExpress();

    @Test
    void calcularCosto_cuatroKm() {
        assertEquals(11000, express.calcularCosto(4));
    }

    @Test
    void calcularCosto_diezKm() {
        assertEquals(20000, express.calcularCosto(10));
    }

    @Test
    void aceptarRecorrido_aceptaHastaDoceKm() {
        assertTrue(express.aceptarRecorrido(5));
        assertTrue(express.aceptarRecorrido(12));
    }

    @Test
    void aceptarRecorrido_rechazaMasDeDoceKm() {
        assertFalse(express.aceptarRecorrido(12.5));
        assertFalse(express.aceptarRecorrido(20));
    }

    @Test
    void solicitarServicio_segunDistancia() {
        assertTrue(express.solicitarServicio(8));
        assertFalse(express.solicitarServicio(15));
    }
}