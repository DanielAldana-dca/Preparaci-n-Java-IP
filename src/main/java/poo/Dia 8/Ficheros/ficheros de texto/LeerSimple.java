import java.io.*;

public class LeerSimple {
    public static void main(String[] args) {
        try {
            // 1. Abrir el archivo para lectura
            FileReader fr = new FileReader("datos.txt");
            
            // 2. Leerlo con un BufferedReader
            BufferedReader br = new BufferedReader(fr);
            
            // 3. Leer línea por línea
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("- " + linea);
            }
            
            // 4. Cerrar
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("❌ El archivo no existe");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}