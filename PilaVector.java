public class PilaVector implements IStack {
    private int[] elementos;
    private int capacidad;
    private int tamano;

    public PilaVector() {
        capacidad = 10;
        elementos = new int[capacidad];
        tamano = 0;
    }

    @Override
    public void push(int value) {
        // Si la pila está llena, se redimensiona.
        if (tamano == capacidad) {
            resize();
        }
        elementos[tamano++] = value;
    }

    @Override
    public int pop() {
        if (tamano == 0) {
            throw new IllegalStateException("Error: La pila está vacía.");
        }
        return elementos[--tamano];
    }

    @Override
    public int operation(char operator, int value1, int value2) {
        int result = switch (operator) {
            case '+' -> value1 + value2;
            case '-' -> value1 - value2;
            case '*' -> value1 * value2;
            case '/' -> value1 / value2;
            case '%' -> value1 % value2;
            default -> throw new IllegalArgumentException("Operador no válido: " + operator);
        };

        System.out.println("Operando: " + value1 + " " + operator + " " + value2 + " = " + result);
        return result;
    }

    private void resize() {
        int nuevaCapacidad = capacidad * 2;
        int[] nuevaPila = new int[nuevaCapacidad];
        System.arraycopy(elementos, 0, nuevaPila, 0, capacidad);
        elementos = nuevaPila;
        capacidad = nuevaCapacidad;
        System.out.println("Pila redimensionada a capacidad: " + nuevaCapacidad);
    }
}