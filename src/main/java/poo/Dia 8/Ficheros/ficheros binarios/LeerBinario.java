
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerBinario {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("numeros.bin");
            DataInputStream dis = new DataInputStream(fis);
             int entero = dis.readInt();
            double decimal = dis.readDouble();
            String texto = dis.readUTF();
            
            System.out.println("Entero: " + entero);
            System.out.println("Decimal: " + decimal);
            System.out.println("Texto: " + texto);
            
            dis.close();
        } catch (IOException e) {
             System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
