/**
     * Emily Góngora, Camila Sandoval, Ale Sierra
     * Interface que añade un valor a la pila, y elimina y devuelve el valor desde arriba
     */
public interface IStack {
    void push(int value);                      
    int pop();                          
    int operation(char operator, int value1, int value2); 
}

