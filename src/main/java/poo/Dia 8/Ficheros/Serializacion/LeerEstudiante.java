import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerEstudiante {
     public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("estudiante.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            Estudiante e = (Estudiante) ois.readObject();  // Casting
            
            System.out.println("📄 " + e);  // Imprime: Ana (20 años)
            
            ois.close();
        } catch (IOException ex) {
            System.out.println("❌ Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("❌ Clase no encontrada");
        }
    }
}
