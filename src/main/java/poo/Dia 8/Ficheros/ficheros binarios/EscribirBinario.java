import java.io.*;

public class EscribirBinario{
    public static void main(String[] args) {
        try {
            //1,Crear un archivo binario
            FileOutputStream fos = new FileOutputStream("numeros.bin");
            DataOutputStream dos = new DataOutputStream(fos);


            //Escribir los datos
            dos.writeInt(45);
            dos.writeDouble(12.4);
            dos.writeUTF("hola mundo");
            dos.close();
            System.out.println("archivo binario guardado");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}