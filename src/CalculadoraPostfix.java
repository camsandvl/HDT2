/**
     * Emily Góngora, Camila Sandoval, Ale Sierra
     * Clase que contiene método para evaluar la expresión postfix contenida en el archivo
     */
public class CalculadoraPostfix {
    private IStack pila;

    public CalculadoraPostfix(IStack pila) {
        this.pila = pila;
    }

    /**
     * @param expresion
     * @return
     * evaluar identifica la expresión, los operadores y los operandos y llama a pop cuando hay un operando después de dos números
     * se usa una excepción cuando la expresión no da un resultado fijo o hay más de uno
     */
    public int evaluar(String expresion) {
        String[] tokens = expresion.split(" ");
        int operandos = 0;

        System.out.println("Evaluando: " + expresion);

        for (String token : tokens) {
            if (esOperando(token)) {
                pila.push(Integer.parseInt(token));
                operandos++;
            } else {
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                operandos--;

                int resultado = pila.operation(token.charAt(0), operandoA, operandoB);
                pila.push(resultado);
            }
        }

        if (operandos != 1) {
            throw new IllegalStateException("Error: La expresión es inválida. La pila tiene más de un resultado.");
        }

        return pila.pop();  
    }

    private boolean esOperando(String token) {
        return token.matches("\\d+"); 
    }
}