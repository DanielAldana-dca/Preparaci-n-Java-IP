# 📘 Día 4 - Polimorfismo

Tags: #POO #Java #Polimorfismo #Abstract #LigaduraDinamica

## 🎯 Objetivos del Día

- Entender qué es el **polimorfismo** y por qué es útil.
- Comprender la **ligadura dinámica** (cómo Java decide qué método ejecutar).
- Aprender a usar **clases abstractas** y **métodos abstractos**.
- Diferenciar entre **sobrescritura** (override) y **sobrecarga** (overload).
- Ver ejemplos prácticos completos.

---

## 📚 Teoría Fundamental

### 1. ¿Qué es el Polimorfismo?

La palabra viene del griego: **"poli"** (muchas) + **"morfos"** (formas). En programación significa que **un mismo nombre de método puede comportarse de manera diferente según el objeto que lo ejecute**.

**Ejemplo del mundo real:**
Tienes un control remoto con un botón "Play". Si apuntas a un **reproductor de música**, "Play" reproduce una canción. Si apuntas a un **reproductor de video**, "Play" reproduce una película. El mismo mensaje ("Play") provoca comportamientos distintos según el dispositivo. Eso es polimorfismo.

**En Java:**
```java
Empleado emp = new Gerente("Luis", 2000, 500);
System.out.println(emp.calcularPago());
// Aunque la variable es de tipo Empleado, el objeto real es Gerente.
// Java ejecuta el calcularPago() de Gerente.
```

### 2. Ligadura Dinámica (Dynamic Binding)

Es el mecanismo interno de Java que **en tiempo de ejecución** decide qué versión de un método ejecutar, basándose en el **tipo real del objeto** (no en el tipo de la variable que lo referencia).

**Regla clave:**
> El tipo de la variable determina **qué métodos puedes llamar**.  
> El tipo del objeto real determina **qué implementación se ejecuta**.

### 3. Sobrescritura vs Sobrecarga (Recordatorio)

| Concepto | Descripción | Ejemplo |
|:---|:---|:---|
| **Sobrescritura (Override)** | Redefinir un método heredado con la misma firma (nombre, parámetros, retorno). Ocurre en **clases hijas**. | `@Override public double calcularPago()` |
| **Sobrecarga (Overload)** | Definir varios métodos con el **mismo nombre** pero **diferentes parámetros** (tipo, cantidad u orden). Puede ocurrir en la **misma clase**. | `public void saludar()` y `public void saludar(String nombre)` |

El polimorfismo por herencia se logra mediante **sobrescritura**. La sobrecarga es otro tipo de polimorfismo (polimorfismo en tiempo de compilación).

---

## 🧪 Ejemplo Práctico 1: Empleados y Gerentes

Vamos a ver polimorfismo en acción con una jerarquía de empleados.

### 📁 Empleado.java (Superclase)

```java
public class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // Método que será sobrescrito por las subclases
    public double calcularPago() {
        return salarioBase;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " - Pago: $" + calcularPago();
    }
}
```

**Explicación línea por línea:**

| Línea | Código | Explicación |
|:---|:---|:---|
| 1 | `protected String nombre;` | Atributo `protected` para que las subclases lo vean |
| 2 | `protected double salarioBase;` | Salario base del empleado |
| 4 | `public Empleado(String nombre, double salarioBase)` | Constructor que inicializa los atributos |
| 9 | `public double calcularPago()` | Método que puede ser sobrescrito. Devuelve el salario base |
| 13 | `public String getNombre()` | Getter para el nombre |
| 16 | `@Override public String toString()` | Sobrescribe el método `toString` de Object |

### 📁 Gerente.java (Subclase)

```java
public class Gerente extends Empleado {
    private double bonus;

    public Gerente(String nombre, double salarioBase, double bonus) {
        super(nombre, salarioBase);  // Llama al constructor del padre
        this.bonus = bonus;
    }

    @Override
    public double calcularPago() {
        return salarioBase + bonus;  // Sobrescritura
    }
}
```

**Explicación línea por línea:**

| Línea | Código | Explicación |
|:---|:---|:---|
| 1 | `public class Gerente extends Empleado` | Hereda de Empleado (es-un) |
| 2 | `private double bonus;` | Atributo propio del Gerente |
| 4 | `public Gerente(...)` | Constructor que recibe 3 parámetros |
| 5 | `super(nombre, salarioBase);` | **OBLIGATORIO**: llama al constructor del padre |
| 6 | `this.bonus = bonus;` | Inicializa el atributo propio |
| 9 | `@Override` | Anotación que indica que sobrescribimos el método |
| 10 | `public double calcularPago()` | Misma firma que el padre |
| 11 | `return salarioBase + bonus;` | Implementación propia (suma el bonus) |

### 📁 Vendedor.java (Otra subclase)

```java
public class Vendedor extends Empleado {
    private double comision;
    private int ventas;

    public Vendedor(String nombre, double salarioBase, double comision, int ventas) {
        super(nombre, salarioBase);
        this.comision = comision;
        this.ventas = ventas;
    }

    @Override
    public double calcularPago() {
        return salarioBase + (comision * ventas);
    }
}
```

### 📁 MainPolimorfismo.java

```java
public class MainPolimorfismo {
    public static void main(String[] args) {
        // 1. Creamos un arreglo de Empleados (polimórfico)
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Empleado("Ana", 1000);
        empleados[1] = new Gerente("Luis", 2000, 500);
        empleados[2] = new Vendedor("Carlos", 1500, 10, 5);

        // 2. Recorremos y mostramos el pago de cada uno
        for (Empleado e : empleados) {
            // Ligadura dinámica: cada objeto ejecuta su propia versión de calcularPago()
            System.out.println(e.getNombre() + " => " + e.calcularPago());
        }
    }
}
```

**Salida:**
```
Ana => 1000.0
Luis => 2500.0
Carlos => 1550.0
```

**Observación clave:**
La variable `e` es de tipo `Empleado`, pero el método `calcularPago()` que se ejecuta depende del objeto real (`Gerente`, `Vendedor`). Eso es polimorfismo.

---

## 📘 Clases y Métodos Abstractos

A veces queremos que una clase **sirva solo como plantilla** para que otras hereden, pero **no queremos que se puedan crear objetos de ella**. Para eso usamos `abstract`.

### Reglas:

- Una clase con al menos un método abstracto **debe** declararse `abstract`.
- Los métodos abstractos **no tienen cuerpo** (terminan con `;`).
- Las subclases **están obligadas** a implementar (sobrescribir) todos los métodos abstractos, a menos que ellas también sean abstractas.
- Una clase abstracta **NO se puede instanciar** (`new Figura()` ❌).

### Ejemplo: Figuras Geométricas

#### 📁 Figura.java (clase abstracta)

```java
public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    // Método abstracto: no tiene implementación
    public abstract double calcularArea();

    // Método concreto (sí tiene implementación)
    public void mostrarColor() {
        System.out.println("Color: " + color);
    }
}
```

**Explicación línea por línea:**

| Línea | Código | Explicación |
|:---|:---|:---|
| 1 | `public abstract class Figura` | Clase abstracta: no se puede instanciar |
| 2 | `protected String color;` | Atributo compartido por todas las figuras |
| 4 | `public Figura(String color)` | Constructor (sí se puede tener en clase abstracta) |
| 9 | `public abstract double calcularArea();` | Método abstracto: sin cuerpo, termina en `;` |
| 12 | `public void mostrarColor()` | Método concreto: tiene implementación |

#### 📁 Circulo.java (subclase concreta)

```java
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

#### 📁 Rectangulo.java (subclase concreta)

```java
public class Rectangulo extends Figura {
    private double ancho, alto;

    public Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }
}
```

#### 📁 MainFiguras.java

```java
public class MainFiguras {
    public static void main(String[] args) {
        // Figura f = new Figura("Rojo"); // ❌ ERROR: no se puede instanciar una clase abstracta

        Figura[] figuras = {
            new Circulo("Rojo", 5),
            new Rectangulo("Azul", 4, 6)
        };

        for (Figura f : figuras) {
            System.out.println("Área: " + f.calcularArea());
            f.mostrarColor();
        }
    }
}
```

**Salida:**
```
Área: 78.53981633974483
Color: Rojo
Área: 24.0
Color: Azul
```

**Ventajas de usar abstractos:**

- Obligas a las subclases a implementar ciertos métodos.
- Puedes tener código compartido (atributos y métodos concretos) en la clase padre.
- Permites el polimorfismo: puedes tener un arreglo de `Figura` y llamar a `calcularArea()` sin saber de qué tipo concreto se trata.

---

## 📊 Comparativa: Clase Abstracta vs Clase Concreta

| Característica | Clase Abstracta | Clase Concreta |
|:---|:---:|:---:|
| ¿Se puede instanciar? | ❌ No | ✅ Sí |
| ¿Puede tener métodos abstractos? | ✅ Sí | ❌ No |
| ¿Puede tener métodos concretos? | ✅ Sí | ✅ Sí |
| ¿Puede tener constructores? | ✅ Sí | ✅ Sí |
| ¿Puede tener atributos? | ✅ Sí | ✅ Sí |

---

## 📊 Comparativa: Sobrescritura vs Sobrecarga

| Aspecto | Sobrescritura (Override) | Sobrecarga (Overload) |
|:---|:---|:---|
| **Dónde ocurre** | Entre clases (padre e hija) | En la misma clase |
| **Firma del método** | Idéntica (nombre + parámetros + retorno) | Mismo nombre, diferentes parámetros |
| **Anotación** | `@Override` (recomendada) | No aplica |
| **Momento de decisión** | Tiempo de ejecución (ligadura dinámica) | Tiempo de compilación |
| **Ejemplo** | `calcularPago()` en Gerente | `saludar()` y `saludar(String)` |
| **Relación con polimorfismo** | Polimorfismo dinámico | Polimorfismo estático |

---

## 📊 Comparativa: Herencia vs Abstracto vs Interfaz

| Aspecto | Herencia (`extends`) | Clase Abstracta | Interfaz (`implements`) |
|:---|:---|:---|:---|
| **Propósito** | Reutilizar código | Plantilla base | Contrato de comportamiento |
| **Relación** | "es-un" | "es-un" (parcial) | "puede-hacer" |
| **Cantidad** | Una sola clase | Una sola clase | Múltiples interfaces |
| **Métodos** | Heredados | Abstractos + concretos | Solo abstractos (o `default`) |
| **Instanciable** | ✅ | ❌ | ❌ |

---

## 📌 Resumen del Día 4

| Concepto | Explicación |
|:---|:---|
| **Polimorfismo** | Un mismo nombre de método se comporta diferente según el objeto real. |
| **Ligadura Dinámica** | Java decide en tiempo de ejecución qué método ejecutar. |
| **Sobrescritura** | Redefinir un método heredado con la misma firma. |
| **Sobrecarga** | Mismo nombre, diferentes parámetros (en la misma clase). |
| **Clase Abstracta** | No se puede instanciar. Sirve como base para subclases. |
| **Método Abstracto** | Declarado sin cuerpo, obliga a las subclases a implementarlo. |

---

## 💡 Buenas Prácticas

1. **Usa `@Override`** siempre que sobrescribas un método. Evita errores de dedo.
2. **Programa para la superclase**, no para la subclase. Usa tipos abstractos o interfaces cuando sea posible.
3. **No abuses de la herencia**: úsala solo cuando haya una relación "es-un" real.
4. **Prefiere composición sobre herencia** cuando la relación no sea "es-un".
5. **En clases abstractas**, pon los métodos comunes como concretos y los específicos como abstractos.
6. **Documenta los métodos abstractos** para que las subclases sepan qué deben implementar.

---

## ⚠️ Errores Comunes

### Error 1: Intentar instanciar una clase abstracta
```java
Figura f = new Figura("Rojo"); // ❌ Error de compilación
```

### Error 2: Olvidar implementar métodos abstractos en subclases
```java
public class Triangulo extends Figura {
    // ❌ Si no implementa calcularArea(), esta clase debe ser abstracta
}
```

### Error 3: Poner `@Override` cuando no se está sobrescribiendo
```java
@Override
public void metodoQueNoExisteEnPadre() { } // ❌ Error de compilación
```

### Error 4: No llamar a `super()` en el constructor hijo
```java
public class Gerente extends Empleado {
    public Gerente(String nombre, double salario) {
        // ❌ Falta super(nombre, salario);
    }
}
```

### Error 5: Confundir sobrescritura con sobrecarga
```java
// Sobrecarga (misma clase)
public void saludar() { }
public void saludar(String n) { }

// Sobrescritura (clase hija)
@Override
public void saludar() { } // Misma firma que el padre
```

---

## ✅ Checklist de Aprendizaje del Día 4

- [ ] Entiendo qué es el **polimorfismo** y por qué es útil.
- [ ] Comprendo la **ligadura dinámica** (Java decide en tiempo de ejecución).
- [ ] Sé diferenciar **sobrescritura** de **sobrecarga**.
- [ ] Sé crear **clases abstractas** con `abstract`.
- [ ] Sé crear **métodos abstractos** (sin cuerpo).
- [ ] Comprendo que las subclases **deben** implementar los métodos abstractos.
- [ ] Sé que una clase abstracta **no se puede instanciar**.
- [ ] Puedo crear **arreglos polimórficos** (tipo padre, objetos hijos).
- [ ] Sé usar `@Override` correctamente.
- [ ] Sé cuándo usar `super.metodo()` para llamar al padre.

---