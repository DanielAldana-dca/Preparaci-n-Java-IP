import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarEstudiante {
    public static void main(String[] args) {
          Estudiante e = new Estudiante("Ana", 20);
        
        try {
            FileOutputStream fos = new FileOutputStream("estudiante.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(e);  // Guarda el objeto completo
            
            oos.close();
            System.out.println("✅ Estudiante guardado");
        } catch (IOException ex) {
            System.out.println("❌ Error: " + ex.getMessage());
        }
    }
}
