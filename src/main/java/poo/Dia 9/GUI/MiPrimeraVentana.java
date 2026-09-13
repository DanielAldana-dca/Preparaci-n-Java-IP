import javax.swing.*;

public class MiPrimeraVentana {
    public static void main(String[] args) {
        // 1. Crear la ventana
        JFrame ventana = new JFrame("Mi primera ventana");
        
        // 2. Configurar el tamaño
        ventana.setSize(400, 300);  // ancho x alto en píxeles
        
        // 3. Qué hacer al cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 4. Centrar en pantalla
        ventana.setLocationRelativeTo(null);
        
        // 5. Hacerla visible (SIEMPRE al final)
        ventana.setVisible(true);
    }
}