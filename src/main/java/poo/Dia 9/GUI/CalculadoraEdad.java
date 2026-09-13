import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraEdad extends JFrame {
    // 📌 1. Declarar los componentes como atributos
    private JLabel etiquetaAno;
    private JTextField campoAno;
    private JButton botonCalcular;
    private JLabel etiquetaResultado;

    // 📌 2. Constructor: inicializa todo
    public CalculadoraEdad() {
        // Configurar la ventana
        setTitle("Calculadora de Edad");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear los componentes
        etiquetaAno = new JLabel("Año de nacimiento:");
        campoAno = new JTextField(10);  // 10 columnas de ancho
        botonCalcular = new JButton("Calcular");
        etiquetaResultado = new JLabel(" ");

        // 📌 3. Agregar el evento al botón
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEdad();
            }
        });

        // Agregar los componentes a la ventana
        add(etiquetaAno);
        add(campoAno);
        add(botonCalcular);
        add(etiquetaResultado);
    }

    // 📌 4. Método que se ejecuta al hacer clic
    private void calcularEdad() {
        try {
            int anoNacimiento = Integer.parseInt(campoAno.getText());
            int anoActual = 2026;
            int edad = anoActual - anoNacimiento;
            etiquetaResultado.setText("Edad: " + edad + " años");
        } catch (NumberFormatException e) {
            etiquetaResultado.setText("❌ Ingrese un año válido");
        }
    }

    // 📌 5. Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraEdad().setVisible(true);
            }
        });
    }
}