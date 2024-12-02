import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;

public class MandoDistanciaTest {

    private MandoDistancia mando;

    @BeforeEach
    public void setUp() {
        mando = new MandoDistancia();
    }

    @Test
    public void testSubirVolumen() {
        mando.subirVolumen(20);
        assertEquals(20, mando.getVolumen());
    }

    @Test
    public void testSubirVolumenExcederMaximo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            mando.subirVolumen(35); // Supera el volumen máximo
        );
        assertEquals("El máximo volumen es 30", exception.getMessage());
    }

    @Test
    public void testBajarVolumen() {
        mando.bajarVolumen(5);
        assertEquals(5, mando.getVolumen());
    }

    @Test
    public void testBajarVolumenExcederMinimo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            mando.bajarVolumen(-5); // Menor al volumen mínimo
        );
        assertEquals("El mínimo volumen es 0", exception.getMessage());
    }

    @Test
    public void testCanalSiguiente() {
        mando.canalSig();
        assertEquals(1, mando.getCanal());
    }

    @Test
    public void testApagar() {
        mando.apagar();
        assertFalse(mando.isEncendido());
    }

    @Test
    public void testMostrar() {
        mando.mostrar();
    // Aquí puedes agregar un verificador si logras capturar los logs o algún otro tipo de validación si aplicable.
    }

    @Test
    public void testSubirVolumenCuandoApagado() {
        mando.apagar();
        mando.subirVolumen(5);
        assertEquals(10, mando.getVolumen()); // El volumen no debería cambiar si está apagado.
    }

    @Test
    public void testApagarYComprobarEstado() {
        mando.apagar();
        assertFalse(mando.isEncendido());
        mando.mostrar(); // También prueba la funcionalidad de mostrar cuando está apagado.
    }

    @Test
    public void testCanalAnt() {
        mando.canalSig(); // Primero avanzamos al canal 1
        mando.canalAnt(); // Volvemos al canal anterior
        assertEquals(0, mando.getCanal()); // Debería ser el canal 0
    }

    @Test
    public void testSeleccionarCanal() {
        mando.canal0();
        assertEquals(0, mando.getCanal());

        mando.canal5();
        assertEquals(5, mando.getCanal());

        mando.canal9();
        assertEquals(9, mando.getCanal());
    }

     @Test
    public void testSeleccionarCanal0() {
        mando.canal0();
        assertEquals(0, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal1() {
        mando.canal1();
        assertEquals(1, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal2() {
        mando.canal2();
        assertEquals(2, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal3() {
        mando.canal3();
        assertEquals(3, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal4() {
        mando.canal4();
        assertEquals(4, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal5() {
        mando.canal5();
        assertEquals(5, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal6() {
        mando.canal6();
        assertEquals(6, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal7() {
        mando.canal7();
        assertEquals(7, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal8() {
        mando.canal8();
        assertEquals(8, mando.getCanal());
    }

    @Test
    public void testSeleccionarCanal9() {
        mando.canal9();
        assertEquals(9, mando.getCanal());
    }

     @Test
    public void testSeleccionarCanalCuandoApagado() {
        mando.apagar();
        mando.canal0();
        assertNotEquals(0, mando.getCanal());  // El canal no debería cambiar si el mando está apagado
    }

}