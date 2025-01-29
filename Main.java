import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            IStack pila = new PilaVector(); 
            CalculadoraPostfix calculadora = new CalculadoraPostfix(pila);

            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    int resultado = calculadora.evaluar(linea);
                    System.out.println("Expresión: " + linea + " Resultado: " + resultado);
                } catch (Exception e) {
                    System.err.println("Error evaluando la expresión: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
