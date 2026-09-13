import javax.swing.*;

public class VentanaConEtiqueta {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Con etiqueta");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 📌 Crear la etiqueta
        JLabel etiqueta = new JLabel("¡Hola, mundo!");
        
        // 📌 Agregar la etiqueta a la ventana
        ventana.add(etiqueta);
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}