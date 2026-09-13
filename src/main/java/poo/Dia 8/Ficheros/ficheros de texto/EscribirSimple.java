import java.io.*;

public class EscribirSimple {
    public static void main(String[] args) {
        try {
            // 1. Crear el escritor (crea el archivo si no existe)
            FileWriter fw = new FileWriter("saludo.txt");
            
            // 2. Escribir el texto
            fw.write("Hola, mundo");
            
            // 3. Cerrar (¡OBLIGATORIO!)
            fw.close();
            
            System.out.println("✅ Archivo guardado");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}