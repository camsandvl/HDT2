public class CalculadoraPostfix {
    private IStack pila; 
    public CalculadoraPostfix(IStack pila) {
        this.pila = pila; 
    }

    public int evaluar(String expresion) {
        String[] tokens = expresion.split(" "); 
        for (String token : tokens) {
            if (esOperando(token)) {
                pila.push(Integer.parseInt(token));
            } else {
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                int resultado = pila.operation(token.charAt(0), operandoA, operandoB);
                pila.push(resultado);
            }
        }
        return pila.pop(); 
    }

    private boolean esOperando(String token) {
        return token.matches("\\d+"); // Verifica si es un número
    }
}

