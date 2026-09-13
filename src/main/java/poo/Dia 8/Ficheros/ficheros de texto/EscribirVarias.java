
import java.io.FileWriter;
import java.io.IOException;

public class EscribirVarias {
public static void main(String[] args) {
    try {
        FileWriter fw = new FileWriter("datos.txt");
        fw.write("primera linea");
        fw.write("\n");
         fw.write("primera linea"); 
          fw.write("\n");
         fw.write("primera linea");
         fw.close();
           System.out.println("✅ Guardado");
    } catch (IOException e) {
        System.out.println("error :" + e.getMessage());
    }
}
    
}