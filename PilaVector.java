public class PilaVector implements IStack {
    private int[] elementos;
    private int capacidad;
    private int tamano;

    public PilaVector() {
        capacidad  = 0;
        elementos = new int[capacidad];
        tamano = 10;
    }

    @Override
    public void push(int value) {
        if (tamano == capacidad) {
            resize();
        } else {
            elementos [tamano++] = value;
        }
    }

    @Override
    public int pop() {
        if (tamano == 0){
            throw new IllegalStateException("Pila vacía");
        }
        return elementos[--tamano];
    }

    @Override
    public int operation(char operator, int value1, int value2) {
        return switch (operator) {
            case '+' -> value1 + value2;
            case '-' -> value1 - value2;
            case '*' -> value1 * value2;
            case '/' -> value1 / value2;
            case '%' -> value1 % value2;

        }
    }

}



