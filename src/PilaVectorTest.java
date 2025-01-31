/**
     * Emily Góngora, Camila Sandoval, Ale Sierra
     * Prueba unitaria para métodos de la clase PilaVector
     * prueba si ejecuta correctamente los métodos push, pop, 
     */
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PilaVectorTest {

    private PilaVector pila;

    @Before
    public void setUp() {
        pila = new PilaVector();
    }

    @Test
    public void testPushAndPop() {
        pila.push(5);
        pila.push(10);
        assertEquals(10, pila.pop());
        assertEquals(5, pila.pop());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmptyPila() {
        pila.pop(); 
    }

    @Test
    public void testOperationSuma() {
        int resultado = pila.operation('+', 3, 4);
        assertEquals(7, resultado);
    }

    @Test
    public void testOperationResta() {
        int resultado = pila.operation('-', 7, 4);
        assertEquals(3, resultado);
    }

    @Test
    public void testOperationMultiplicacion() {
        int resultado = pila.operation('*', 3, 4);
        assertEquals(12, resultado);
    }

    @Test
    public void testOperationDivision() {
        int resultado = pila.operation('/', 10,2);
        assertEquals(5, resultado);
    }

    @Test
    public void testOperationResiduo() {
        int resultado = pila.operation('%', 8,3);
        assertEquals(2,resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOperationInvalida() {
        pila.operation('?', 3, 4); // Debe lanzar IllegalArgumentException
    }
}
