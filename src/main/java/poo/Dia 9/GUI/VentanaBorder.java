import java.awt.*;
import javax.swing.*;

public class VentanaBorder {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("BorderLayout");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        
        // Agregar componentes en cada zona
        ventana.add(new JButton("Arriba"), BorderLayout.NORTH);
        ventana.add(new JButton("Abajo"), BorderLayout.SOUTH);
        ventana.add(new JButton("Izquierda"), BorderLayout.WEST);
        ventana.add(new JButton("Derecha"), BorderLayout.EAST);
        ventana.add(new JButton("Centro"), BorderLayout.CENTER);
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
