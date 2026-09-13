# ⚡ Cheatsheet - Referencia Rápida

Tags: #Cheatsheet #Referencia #Sintaxis

> Sintaxis esencial de Java para consultar rápidamente.

---

## 🏗️ Estructura de una Clase

```java
public class MiClase {
    // 1. Atributos
    private String nombre;
    private int edad;
    
    // 2. Constructor
    public MiClase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // 3. Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    
    // 4. Métodos
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
    
    // 5. toString
    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
```

---

## 📦 Crear un Objeto

```java
MiClase obj = new MiClase("Ana", 20);
obj.saludar();
System.out.println(obj);
```

---

## 🔄 Herencia

```java
// Superclase
public class Animal {
    protected String nombre;
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public void hacerSonido() { }
}

// Subclase
public class Perro extends Animal {
    private String raza;
    
    public Perro(String nombre, String raza) {
        super(nombre);  // Llamar al padre primero
        this.raza = raza;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}
```

---

## 🔌 Interfaces

```java
// Interfaz
public interface Volador {
    void volar();
    default void aterrizar() { }
}

// Implementación
public class Pajaro implements Volador {
    @Override
    public void volar() { }
}

// Múltiples interfaces
public class Triatleta implements Nadador, Corredor, Ciclista { }
```

---

## 🎭 Clase Abstracta

```java
public abstract class Figura {
    protected String color;
    
    public abstract double calcularArea();
    
    public void mostrarColor() { }
}

public class Circulo extends Figura {
    private double radio;
    
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
```

---

## 🧬 Genéricos

```java
// Clase genérica
public class Lista<T> {
    private Object[] elementos;
    
    public void adicionar(T elem) { }
    
    @SuppressWarnings("unchecked")
    public T obtener(int pos) {
        return (T) elementos[pos];
    }
}

// Uso
Lista<String> lista = new Lista<>();
lista.adicionar("Hola");
String s = lista.obtener(0);

// Método genérico
public static <T> void imprimir(T[] arr) { }
```

---

## ⚠️ Excepciones

```java
// try-catch-finally
try {
    // código riesgoso
} catch (NumberFormatException e) {
    System.out.println("Error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Error general");
} finally {
    // siempre se ejecuta
}

// Lanzar excepción
throw new IllegalArgumentException("Mensaje");

// Declarar excepción
public void metodo() throws IOException { }

// Excepción propia
public class MiExcepcion extends Exception {
    public MiExcepcion(String msg) {
        super(msg);
    }
}
```

---

## 📂 Ficheros

### Texto (Escribir)
```java
try (BufferedWriter bw = new BufferedWriter(
        new FileWriter("datos.txt"))) {
    bw.write("Hola");
    bw.newLine();
    bw.write("Mundo");
} catch (IOException e) {
    e.printStackTrace();
}
```

### Texto (Leer)
```java
try (BufferedReader br = new BufferedReader(
        new FileReader("datos.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Binario (Escribir)
```java
try (DataOutputStream dos = new DataOutputStream(
        new FileOutputStream("datos.bin"))) {
    dos.writeUTF("texto");
    dos.writeInt(42);
    dos.writeDouble(3.14);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Binario (Leer)
```java
try (DataInputStream dis = new DataInputStream(
        new FileInputStream("datos.bin"))) {
    String s = dis.readUTF();
    int n = dis.readInt();
    double d = dis.readDouble();
} catch (IOException e) {
    e.printStackTrace();
}
```

### Serialización (Guardar)
```java
public class MiClase implements Serializable {
    private static final long serialVersionUID = 1L;
    // atributos...
}

try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("datos.ser"))) {
    oos.writeObject(objeto);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Serialización (Leer)
```java
try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("datos.ser"))) {
    MiClase obj = (MiClase) ois.readObject();
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

---

## 📋 Arreglos y Listas

### Arreglo
```java
// Declarar y crear
double[] notas = new double[25];
int[] nums = {1, 2, 3, 4, 5};

// Recorrer
for (int i = 0; i < notas.length; i++) {
    notas[i] = 0.0;
}

// For-each
for (int n : nums) {
    System.out.println(n);
}
```

### Lista Genérica (implementación propia)
```java
Lista<Estudiante> lista = new Lista<>(100);
lista.adicionar(estudiante);
Estudiante e = lista.obtener(0);
lista.eliminar(0);
int tam = lista.size();
```

---

## 🔁 Estructuras de Control

### Condicional
```java
if (condicion) {
    // ...
} else if (otra) {
    // ...
} else {
    // ...
}

// Operador ternario
String msg = (edad >= 18) ? "Mayor" : "Menor";

// Switch
switch (opcion) {
    case 1: /* ... */ break;
    case 2: /* ... */ break;
    default: /* ... */
}
```

### Bucles
```java
// for
for (int i = 0; i < 10; i++) { }

// while
while (condicion) { }

// do-while
do { } while (condicion);

// for-each
for (Tipo elem : coleccion) { }
```

---

## 📥 Entrada por Consola (sin Scanner)

```java
// Método 1: System.console()
var cons = System.console();
String texto = cons.readLine();
int numero = Integer.parseInt(cons.readLine());
double decimal = Double.parseDouble(cons.readLine());

// Método 2: BufferedReader
BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in));
String texto = br.readLine();
int numero = Integer.parseInt(br.readLine());
```

---

## 📤 Salida por Consola

```java
System.out.println("Hola");            // Con salto de línea
System.out.print("Hola");              // Sin salto de línea
System.out.printf("%s tiene %d años%n", nombre, edad);
// %s = String, %d = int, %f = float/double, %.2f = 2 decimales
```

---

## 🧮 Operadores

| Operador | Significado |
|:---:|:---|
| `+` `-` `*` `/` `%` | Aritméticos |
| `==` `!=` `<` `>` `<=` `>=` | Comparación |
| `&&` `\|\|` `!` | Lógicos |
| `++` `--` | Incremento / Decremento |
| `+=` `-=` `*=` `/=` | Asignación compuesta |
| `?:` | Ternario |

---

## 🔍 `instanceof` y Casting

```java
// Verificar tipo
if (obj instanceof Perro) {
    Perro p = (Perro) obj;  // Downcasting
    p.correr();
}

// Upcasting (automático)
Perro perro = new Perro();
Animal animal = perro;
```

---

## 📝 Convenciones de Nombres

| Elemento | Convención | Ejemplo |
|:---|:---|:---|
| Clase | PascalCase | `Estudiante`, `CuentaBancaria` |
| Método | camelCase | `calcularPromedio`, `getNombre` |
| Variable | camelCase | `nombreCompleto`, `saldoActual` |
| Constante | MAYÚSCULAS | `MAX_ESTUDIANTES`, `PI` |
| Paquete | minúsculas | `com.uci.poo` |
| Interfaz | Adjetivo/Capacidad | `Volador`, `Serializable` |

---

## 🎯 Modificadores Esenciales

| Modificador | Uso |
|:---|:---|
| `private` | Solo accesible en la clase |
| `public` | Accesible desde cualquier lugar |
| `protected` | Accesible en la clase, paquete y subclases |
| `static` | Pertenece a la clase, no al objeto |
| `final` | Constante o no modificable |
| `abstract` | Sin implementación o sin instancias |

---

## 🧰 Atajos de VSCode

| Atajo | Acción |
|:---|:---|
| `Ctrl + Shift + P` | Paleta de comandos |
| `F5` | Ejecutar / Debug |
| `Ctrl + F5` | Ejecutar sin debug |
| `Ctrl + Shift + F` | Buscar en todo el proyecto |
| `Alt + Shift + F` | Formatear código |
| `Ctrl + /` | Comentar / Descomentar |
| `Ctrl + D` | Seleccionar siguiente ocurrencia |

---
