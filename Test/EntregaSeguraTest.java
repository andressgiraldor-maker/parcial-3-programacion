import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase para probar los metodos de EntregaSegura
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
class EntregaSeguraTest {

    EmpresaDomicilio empresa = new EntregaSegura();

    @Test
    void calcularCosto_sinRecargo() {
        assertEquals(10000, empresa.calcularCosto(3));
    }

    @Test
    void calcularCosto_exactamenteCincoKm() {
        assertEquals(12000, empresa.calcularCosto(5));
    }

    @Test
    void calcularCosto_conRecargo() {
        assertEquals(20000, empresa.calcularCosto(10));
    }

    @Test
    void aceptaRecorrido_limiteVeinteKm() {

        assertTrue(empresa.aceptarRecorrido(20));
        assertFalse(empresa.aceptarRecorrido(20.5));
    }

    @Test
    void solicitarServicio_segunDistancia() {

        assertTrue(empresa.solicitarServicio(15));
        assertFalse(empresa.solicitarServicio(25));
    }

}