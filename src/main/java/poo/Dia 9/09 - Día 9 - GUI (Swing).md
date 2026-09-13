# 📘 Día 9 - Interfaces Gráficas (GUI) con Swing

Tags: #POO #Java #GUI #Swing #JFrame #Eventos

## 🎯 Objetivos del Día

- Entender **qué es una GUI** y por qué es útil.
- Conocer las **clases principales** de Swing (`JFrame`, `JPanel`, componentes).
- Aprender a **crear ventanas** y agregar componentes.
- Comprender los **Layout Managers** (`FlowLayout`, `BorderLayout`, `GridLayout`).
- Saber manejar **eventos** con `ActionListener`.
- Conocer las **buenas prácticas** y **errores comunes**.
- Tener una **plantilla reutilizable** para exámenes.

---

## 🧩 ¿Qué es una GUI? (Analogía)

Hasta ahora tus programas funcionan en **consola** (escribes texto, ves texto). Una **GUI** (Graphical User Interface) es una **ventana** con botones, campos de texto, etc. Es lo que usas todos los días en Windows, navegadores, etc.

**Sin GUI (consola):**
```
Ingrese su nombre: Juan
Ingrese su edad: 20
Hola Juan, tienes 20 años
```

**Con GUI (ventana):**
- Una ventana con un campo de texto, un botón "Saludar" y un mensaje.

---

## 🏗️ Las 3 Clases Principales

| Clase | ¿Qué es? | Analogía |
|:---|:---|:---|
| **`JFrame`** | La **ventana** principal | El marco de una casa |
| **`JPanel`** | Un **panel** dentro de la ventana | Una habitación dentro de la casa |
| **Componentes** | Botones, textos, etiquetas | Los muebles dentro de la habitación |

### Componentes Básicos

| Componente | Clase Java | ¿Para qué? |
|:---|:---|:---|
| Etiqueta | `JLabel` | Mostrar texto fijo |
| Campo de texto | `JTextField` | Escribir texto corto |
| Botón | `JButton` | Hacer clic |
| Área de texto | `JTextArea` | Texto largo |
| Lista desplegable | `JComboBox` | Elegir opción |
| Casilla de verificación | `JCheckBox` | Marcar/desmarcar |
| Botón de radio | `JRadioButton` | Elegir una opción |

---

## 🚀 Tu Primera Ventana (Paso a Paso)

### Código mínimo para crear una ventana

```java
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
```

**Explicación línea por línea:**

| Línea | Código | Explicación |
|:---|:---|:---|
| 1 | `import javax.swing.*;` | Importa todas las clases de Swing |
| 5 | `new JFrame("...")` | Crea la ventana con un título |
| 8 | `setSize(400, 300)` | Ancho 400, alto 300 píxeles |
| 11 | `setDefaultCloseOperation(...)` | Cerrar la ventana termina el programa |
| 14 | `setLocationRelativeTo(null)` | Centra la ventana en la pantalla |
| 17 | `setVisible(true)` | **Sin esto, la ventana no se ve** |

**Resultado:** Una ventana vacía de 400x300 píxeles.

---

## 🧱 Agregar Componentes

Para agregar botones, etiquetas, etc., puedes hacerlo directamente en la ventana o en un panel.

### Ejemplo: Una etiqueta en la ventana

```java
import javax.swing.*;
import java.awt.*;

public class VentanaConEtiqueta {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Con etiqueta");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear la etiqueta
        JLabel etiqueta = new JLabel("¡Hola, mundo!");
        
        // Agregar la etiqueta a la ventana
        ventana.add(etiqueta);
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
```

**Resultado:** Una ventana con el texto "¡Hola, mundo!" arriba.

---

## 📐 Layouts (Cómo se Acomodan los Componentes)

Java usa **Layout Managers** para organizar los componentes. Los 3 más comunes:

| Layout | ¿Cómo organiza? | Cuándo usarlo |
|:---|:---|:---|
| **`FlowLayout`** | En fila, uno tras otro (por defecto) | Pocos componentes |
| **`BorderLayout`** | En 5 zonas: NORTE, SUR, ESTE, OESTE, CENTRO | Ventanas principales |
| **`GridLayout`** | En cuadrícula (filas x columnas) | Formularios |

### Ejemplo con `BorderLayout`

```java
import javax.swing.*;
import java.awt.*;

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
```

**Resultado:** 5 botones en las 5 zonas de la ventana.

### Ejemplo con `GridLayout`

```java
ventana.setLayout(new GridLayout(3, 2, 10, 10));
// 3 filas, 2 columnas, 10px de espacio horizontal y vertical
```

---

## 🎯 El Corazón de la GUI: Eventos (Botones)

Un **evento** es algo que ocurre cuando el usuario interactúa: hace clic en un botón, escribe en un campo, etc. Para que el botón "haga algo" al hacer clic, usamos un **ActionListener**.

### Ejemplo completo: Calculadora de edad

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraEdad extends JFrame {
    // 1. Declarar los componentes como atributos
    private JLabel etiquetaAno;
    private JTextField campoAno;
    private JButton botonCalcular;
    private JLabel etiquetaResultado;

    // 2. Constructor: inicializa todo
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

        // 3. Agregar el evento al botón
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

    // 4. Método que se ejecuta al hacer clic
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

    // 5. Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraEdad().setVisible(true);
            }
        });
    }
}
```

**Salida:** Una ventana con:
- Etiqueta "Año de nacimiento:"
- Campo de texto
- Botón "Calcular"
- Al hacer clic, muestra "Edad: X años"

---

### 🧠 Explicación del Evento (Lo Más Importante)

```java
botonCalcular.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        calcularEdad();  // Aquí va lo que quieres que haga el botón
    }
});
```

**¿Qué significa esto?**
- `addActionListener(...)`: "Oye botón, cuando te hagan clic, ejecuta esto".
- `new ActionListener() { ... }`: Creamos un objeto que escucha el clic.
- `actionPerformed(ActionEvent e)`: Método que se ejecuta **automáticamente** cuando el usuario hace clic.

**Piénsalo como:**
- El botón es un timbre.
- `ActionListener` es la persona que escucha el timbre.
- `actionPerformed` es lo que hace esa persona cuando suena el timbre.

---

## 🎨 Ejemplo 2: Formulario de Estudiante

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioEstudiante extends JFrame {
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JButton botonGuardar;
    private JTextArea areaResultado;

    public FormularioEstudiante() {
        setTitle("Formulario de Estudiante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Usamos GridLayout: 4 filas, 2 columnas
        setLayout(new GridLayout(4, 2, 10, 10));

        // Fila 1
        add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        add(campoNombre);

        // Fila 2
        add(new JLabel("Edad:"));
        campoEdad = new JTextField();
        add(campoEdad);

        // Fila 3
        botonGuardar = new JButton("Guardar");
        add(botonGuardar);
        add(new JLabel(""));

        // Fila 4: área de resultado
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado));

        // Evento del botón
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEstudiante();
            }
        });
    }

    private void guardarEstudiante() {
        String nombre = campoNombre.getText();
        String edadTexto = campoEdad.getText();
        
        if (nombre.isEmpty() || edadTexto.isEmpty()) {
            areaResultado.setText("⚠️ Complete todos los campos");
            return;
        }
        
        try {
            int edad = Integer.parseInt(edadTexto);
            areaResultado.setText("✅ Estudiante guardado:\n");
            areaResultado.append("Nombre: " + nombre + "\n");
            areaResultado.append("Edad: " + edad + " años\n");
            
            campoNombre.setText("");
            campoEdad.setText("");
        } catch (NumberFormatException e) {
            areaResultado.setText("❌ La edad debe ser un número");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioEstudiante().setVisible(true));
    }
}
```

---

## 📋 Resumen de Métodos Esenciales

### `JFrame` (ventana)

| Método | ¿Qué hace? |
|:---|:---|
| `setTitle("...")` | Pone el título |
| `setSize(ancho, alto)` | Define el tamaño |
| `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)` | Cierra el programa al cerrar |
| `setLocationRelativeTo(null)` | Centra la ventana |
| `setVisible(true)` | Muestra la ventana |
| `setLayout(new ...)` | Define el layout |
| `add(componente)` | Agrega un componente |

### `JLabel` (etiqueta)

| Método | ¿Qué hace? |
|:---|:---|
| `new JLabel("texto")` | Crea una etiqueta con texto |
| `setText("nuevo")` | Cambia el texto |
| `getText()` | Obtiene el texto |

### `JTextField` (campo de texto)

| Método | ¿Qué hace? |
|:---|:---|
| `new JTextField(10)` | Crea un campo de 10 columnas |
| `getText()` | Obtiene el texto escrito |
| `setText("...")` | Pone texto en el campo |

### `JButton` (botón)

| Método | ¿Qué hace? |
|:---|:---|
| `new JButton("texto")` | Crea un botón |
| `addActionListener(...)` | Asocia un evento al clic |

### `JTextArea` (área de texto)

| Método | ¿Qué hace? |
|:---|:---|
| `new JTextArea()` | Crea un área de texto |
| `append("...")` | Añade texto al final |
| `setEditable(false)` | Solo lectura |
| `setText("...")` | Reemplaza todo el texto |

### `JComboBox` (lista desplegable)

| Método | ¿Qué hace? |
|:---|:---|
| `new JComboBox<>(opciones)` | Crea una lista con opciones |
| `getSelectedItem()` | Obtiene el elemento seleccionado |

---

## ⚠️ Errores Comunes

### Error 1: Olvidar `setVisible(true)`
```java
ventana.setSize(400, 300);
// ❌ Falta setVisible(true); la ventana no se ve
```

### Error 2: No centrar la ventana
```java
// La ventana aparece en la esquina
ventana.setLocationRelativeTo(null);  // ✅ Centrar
```

### Error 3: No manejar excepciones al parsear
```java
int edad = Integer.parseInt(campoEdad.getText());
// ❌ Si el usuario escribe "abc", el programa falla
// ✅ Usar try-catch
```

### Error 4: No ejecutar en el EDT (Event Dispatch Thread)
```java
// ❌ No recomendado
public static void main(String[] args) {
    new MiVentana().setVisible(true);
}

// ✅ Recomendado
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MiVentana().setVisible(true));
}
```

### Error 5: Confundir `setText` con `getText`
```java
campoNombre.setText("Ana");   // ✅ Poner texto
String nombre = campoNombre.getText();  // ✅ Obtener texto
```

### Error 6: No usar `JScrollPane` con `JTextArea`
```java
add(areaResultado);  // ❌ No tiene scroll
add(new JScrollPane(areaResultado));  // ✅ Con scroll
```

---

## 💡 Buenas Prácticas

1. **Siempre usar `setVisible(true)` al final** del constructor.
2. **Centrar la ventana** con `setLocationRelativeTo(null)`.
3. **Ejecutar en el EDT** con `SwingUtilities.invokeLater`.
4. **Usar `try-catch`** al parsear datos de campos de texto.
5. **Separar la lógica** de la interfaz: los eventos llaman a métodos privados.
6. **Nombrar los componentes** de forma descriptiva (`campoNombre`, no `tf1`).
7. **Usar layouts apropiados** según el tipo de formulario.
8. **Validar datos** antes de procesarlos.

---

## 🎯 Plantilla para tus Exámenes

Usa esta plantilla cuando necesites crear una GUI en un examen:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiVentana extends JFrame {
    // 1. Declarar componentes
    private JTextField campo1;
    private JButton boton;
    private JLabel resultado;

    public MiVentana() {
        // 2. Configurar ventana
        setTitle("Título");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 3. Crear y agregar componentes
        campo1 = new JTextField(10);
        boton = new JButton("Aceptar");
        resultado = new JLabel(" ");

        add(new JLabel("Dato:"));
        add(campo1);
        add(boton);
        add(resultado);

        // 4. Asociar evento
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesar();
            }
        });
    }

    // 5. Método de lógica
    private void procesar() {
        try {
            String texto = campo1.getText();
            // ... lógica ...
            resultado.setText("Resultado: " + texto);
        } catch (Exception e) {
            resultado.setText("Error: " + e.getMessage());
        }
    }

    // 6. Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiVentana().setVisible(true));
    }
}
```

---

## 📌 Resumen del Día 9

| Concepto | Explicación |
|:---|:---|
| **JFrame** | La ventana principal |
| **JPanel** | Panel dentro de la ventana |
| **JLabel** | Etiqueta de texto fijo |
| **JTextField** | Campo para escribir |
| **JButton** | Botón para hacer clic |
| **JTextArea** | Área de texto largo |
| **JComboBox** | Lista desplegable |
| **ActionListener** | Maneja los clics de botones |
| **FlowLayout** | Organiza componentes en fila |
| **BorderLayout** | Organiza en 5 zonas |
| **GridLayout** | Organiza en cuadrícula |
| **EDT** | Hilo donde se ejecutan las GUIs |
| **JScrollPane** | Añade scroll a un componente |

---

## ✅ Checklist de Aprendizaje del Día 9

- [ ] Sé crear una ventana con `JFrame`
- [ ] Sé agregar etiquetas, botones y campos de texto
- [ ] Comprendo los layouts (`FlowLayout`, `BorderLayout`, `GridLayout`)
- [ ] Sé manejar eventos con `ActionListener`
- [ ] Sé obtener texto de un campo con `getText()`
- [ ] Sé mostrar resultados en una etiqueta con `setText()`
- [ ] Manejo excepciones al parsear números
- [ ] Sé usar `SwingUtilities.invokeLater` para lanzar la ventana
- [ ] Puedo crear un formulario con varios campos y un botón
- [ ] Sé usar `JTextArea` con `JScrollPane`
- [ ] Sé usar `JComboBox` para listas desplegables

---

## 🔗 Enlaces Relacionados

- Anterior: [[08 - Día 8 - Ficheros]]
- Ver también: [[98 - Tablas Resumen]]
- Ver también: [[99 - Cheatsheet]]

---

## 📚 Referencias

- Colectivo de autores. *Manual de Programación 1*. Capítulo 10.
- Horstmann, C. *Big Java*, 4ta Edición. Capítulo 13.
- Zukowski, J. *Programación Java 2, J2SE 1.4*. Capítulos 12, 13 y 14.
- Deitel, H. M. *Java How to Program*, 7ma Edición. Capítulo 11.