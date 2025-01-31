/**
     * Emily Góngora, Camila Sandoval, Ale Sierra
     * Prueba unitaria para métodos de la clase Calculadora Postfix
     * prueba si  puede sumar, multiplicar, leer expresiones con más de un operador
     *  e identificar cuando una expresión no es válida
     */
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CalculadoraPostfixTest {

    private CalculadoraPostfix calculadora;

    @Before
    public void setUp() {
        calculadora = new CalculadoraPostfix(new PilaVector());
    }

    @Test
    public void testEvaluarSuma() {
        String expresion = "3 4 +";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(7, resultado);
    }

    @Test
    public void testEvaluarResta() {
        String expresion = "2 5 -";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(-3, resultado);
    }

    @Test
    public void testEvaluarMultiplicacion() {
        String expresion = "2 5 *";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(10, resultado);
    }

    @Test
    public void testEvaluarDvision() {
        String expresion = "10 2 /";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(5, resultado);
    }

    @Test
    public void testEvaluarResiduo() {
        String expresion = "10 2 /";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(5, resultado);
    }

    @Test
    public void testEvaluarExpresionCompleja() {
        String expresion = "3 4 + 2 *";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(14, resultado);
    }

    @Test(expected = IllegalStateException.class)
    public void testEvaluarExpresionInvalida() {
        String expresion = "3 4 + +";
        calculadora.evaluar(expresion); 
    }
}
