public interface IStack {
    void push(int value);                      // Add valor a la pila
    int pop();                                // Eliminar y devolver el valor desde arriba
    int operation(char operator, int value1, int value2); 
}

