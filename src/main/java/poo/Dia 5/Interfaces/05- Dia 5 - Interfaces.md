# 📘 Día 5 - Interfaces

Tags: #POO #Java #Interfaces #Contratos #HerenciaMultiple

## 🎯 Objetivos del Día

- Entender **qué es una interfaz** y por qué existe.
- Comprender la diferencia entre **clase abstracta** e **interfaz**.
- Aprender la **sintaxis** (`interface`, `implements`).
- Resolver el problema de la **herencia múltiple** (el "diamante").
- Saber **cuándo usar** una interfaz y cuándo una clase abstracta.
- Conocer las **reglas** y **restricciones** de las interfaces en Java.

---

## 📚 ¿Qué es una Interfaz? (Explicación Profunda)

Una **interfaz** es un **contrato** que una clase firma con el resto del programa. Ese contrato dice: *"Yo me comprometo a implementar estos métodos"*. La interfaz **no dice cómo** hacerlo, solo **qué** debe hacerse.

### Analogía: El Enchufe Eléctrico

Imagina un enchufe de pared. Cualquier dispositivo que tenga el conector adecuado puede enchufarse: una lámpara, un cargador, un televisor. El **enchufe** es el contrato; los dispositivos son las clases que lo implementan.

- El enchufe dice: *"Si quieres conectarte a mí, debes tener estas patillas y este voltaje"*.
- El dispositivo decide **cómo** usa la energía (una lámpara ilumina, un cargador carga).
- El enchufe **no le importa** de qué tipo de dispositivo se trate.

### Analogía: El Contrato Laboral

Cuando firmas un contrato de trabajo, te comprometes a cumplir ciertas funciones (programar, diseñar, etc.). El contrato dice **qué** harás, pero no **cómo** lo harás. Cada empleado lo hace a su manera.

> **En Java**: La interfaz es ese contrato. La clase que la implementa se compromete a proporcionar los métodos declarados.

---

## 🔍 ¿Por qué existen las Interfaces?

Java tiene una limitación: **no permite herencia múltiple de clases**. Es decir, una clase no puede heredar de dos clases a la vez. Esto es así para evitar el famoso **"problema del diamante"**.

### El Problema del Diamante

Imagina esta situación:

```
        A
       / \
      B   C
       \ /
        D
```

- `B` hereda de `A`.
- `C` hereda de `A`.
- `D` hereda de `B` y `C`.

**¿Qué problema hay?** Si `A` tiene un método `saludar()`, y `B` y `C` lo modifican de maneras diferentes, ¿cuál debería heredar `D`? Java no sabe resolver ese conflicto, por eso **prohíbe la herencia múltiple de clases**.

### La Solución: Interfaces

Las interfaces **no tienen implementación** (hasta Java 8, que introdujo `default`), por lo que **no hay conflicto**. Si una clase implementa dos interfaces con el mismo método, la clase simplemente proporciona una implementación única que satisface a ambas.

---

## 📐 Sintaxis y Reglas

### Declaración de una interfaz

```java
public interface NombreInterfaz {
    // Métodos (implícitamente public abstract)
    void metodo1();
    int metodo2(String param);
    
    // Constantes (implícitamente public static final)
    int VALOR_MAXIMO = 100;
}
```

### Implementación en una clase

```java
public class MiClase implements NombreInterfaz {
    @Override
    public void metodo1() {
        // implementación obligatoria
    }
    
    @Override
    public int metodo2(String param) {
        // implementación obligatoria
        return 0;
    }
}
```

### Implementación de múltiples interfaces

```java
public class MiClase implements Interfaz1, Interfaz2, Interfaz3 {
    // Debe implementar TODOS los métodos de TODAS las interfaces
}
```

### Herencia de una clase e implementación de interfaces

```java
public class MiClase extends ClasePadre implements Interfaz1, Interfaz2 {
    // Primero extends, luego implements
}
```

---

## 📊 Reglas Detalladas de las Interfaces

| Regla | Explicación |
|:---|:---|
| **No se pueden instanciar** | `new MiInterfaz()` ❌. Solo se usan como tipo de referencia. |
| **Todos los métodos son públicos y abstractos** | No necesitas escribir `public abstract`; es implícito. |
| **Todos los atributos son constantes** | Son `public static final` por defecto. Deben inicializarse al declararse. |
| **No tienen constructores** | No se pueden crear objetos de una interfaz. |
| **Una clase puede implementar varias** | Resuelve la herencia múltiple. |
| **Una interfaz puede heredar de otra** | `interface A extends B { }`. Puede heredar de varias. |
| **Una interfaz no puede heredar de una clase** | Solo de otras interfaces. |
| **`default` (Java 8+)** | Métodos con implementación por defecto. |
| **`static` (Java 8+)** | Métodos estáticos que pertenecen a la interfaz. |

---

## 🔄 Interfaz vs Clase Abstracta (Comparación Profunda)

Esta es una de las preguntas más comunes. Aquí va una comparación detallada:

| Aspecto | Clase Abstracta | Interfaz |
|:---|:---|:---|
| **Palabra clave** | `abstract class` | `interface` |
| **Relación que modela** | "es-un" | "puede-hacer" / "tiene la capacidad de" |
| **Herencia** | Una clase solo puede heredar de **una** clase abstracta | Una clase puede implementar **múltiples** interfaces |
| **Atributos** | Puede tener atributos de instancia (`private`, `protected`) | Solo constantes (`public static final`) |
| **Métodos** | Puede tener métodos concretos (con código) y abstractos | Solo abstractos (hasta Java 8, que añadió `default` y `static`) |
| **Constructores** | Sí, puede tener | No, no puede tener |
| **Cuándo usarla** | Cuando quieres compartir código común entre clases relacionadas | Cuando quieres definir un comportamiento común a clases no relacionadas |
| **Velocidad de cambio** | Más difícil de modificar sin romper subclases | Más flexible; añadir métodos `default` no rompe las clases existentes |
| **Ejemplo** | `Animal` (todos los animales comparten atributos) | `Volador` (cualquier cosa que vuele: pájaro, avión, superhéroe) |

### ¿Cuándo usar cada una?

**Usa una clase abstracta cuando:**
- Tienes clases que están **relacionadas jerárquicamente** ("es-un").
- Quieres **compartir código** entre las subclases (atributos y métodos concretos).
- Necesitas definir **atributos de instancia** que se compartan.
- Quieres que las subclases tengan un **estado común**.

**Usa una interfaz cuando:**
- Quieres definir **un comportamiento que varias clases no relacionadas pueden tener**.
- Necesitas **herencia múltiple** de tipo (una clase puede implementar varias).
- Quieres especificar **un contrato sin implementación** (o con implementación por defecto).
- Quieres que el código dependa de **abstracciones**, no de implementaciones concretas.

---

## 🧩 La Relación "Puede-Hacer" vs "Es-Un"

La diferencia conceptual es clave:

- **Herencia ("es-un")**: Un `Perro` **es un** `Animal`. Todos los perros comparten características de los animales.
- **Interfaz ("puede-hacer")**: Un `Avión` **puede volar**, un `Pájaro` **puede volar**, un `Superhéroe` **puede volar**. No comparten una jerarquía común, pero todos tienen la **capacidad de volar**.

Esta distinción es la razón por la que las interfaces son tan poderosas: permiten agrupar objetos **completamente dispares** bajo un mismo comportamiento.

---

## 🏗️ Herencia Múltiple con Interfaces

Java no permite que una clase herede de varias clases, pero **sí permite que implemente varias interfaces**. Esto es una forma de **herencia múltiple de tipo** (pero no de implementación).

```java
public interface Nadador {
    void nadar();
}

public interface Corredor {
    void correr();
}

public interface Ciclista {
    void pedalear();
}

// Una clase puede implementar todas las que quiera
public class Triatleta implements Nadador, Corredor, Ciclista {
    @Override
    public void nadar() { }
    
    @Override
    public void correr() { }
    
    @Override
    public void pedalear() { }
}
```

**¿Qué logramos con esto?** Un `Triatleta` puede ser tratado como `Nadador`, como `Corredor` o como `Ciclista` según el contexto. Esto es **polimorfismo a través de interfaces**.

---

## 🔗 Interfaz como Tipo de Referencia

Una interfaz se puede usar como **tipo de una variable** o como **tipo de un arreglo**. Esto es muy útil porque permite tratar a objetos de clases diferentes de manera uniforme.

```java
Volador[] voladores = new Volador[3];
voladores[0] = new Pajaro();
voladores[1] = new Avion();
voladores[2] = new Superheroe();

for (Volador v : voladores) {
    v.volar(); // Cada uno vuela a su manera
}
```

**Observación:** Aunque `Pajaro`, `Avion` y `Superheroe` no tienen nada en común jerárquicamente, todos pueden tratarse como `Volador` porque implementan esa interfaz.

---

## 🎯 Interfaces con Métodos `default` (Java 8+)

A partir de Java 8, las interfaces pueden tener métodos con implementación por defecto, marcados con la palabra clave `default`. Esto permite **añadir nuevos métodos** a una interfaz sin romper las clases existentes que ya la implementan.

```java
public interface Volador {
    void volar();
    
    // Método con implementación por defecto
    default void aterrizar() {
        System.out.println("Aterrizando de forma estándar...");
    }
}

public class Pajaro implements Volador {
    @Override
    public void volar() {
        System.out.println("El pájaro vuela.");
    }
    // No necesita implementar aterrizar() porque tiene default
}
```

**Ventaja:** Las clases existentes siguen funcionando sin cambios. Solo las nuevas pueden sobrescribir el método `default` si lo desean.

---

## 🎯 Interfaces con Métodos `static` (Java 8+)

Una interfaz también puede tener métodos `static`. Estos pertenecen a la interfaz en sí, no a las clases que la implementan.

```java
public interface Utilidades {
    static int sumar(int a, int b) {
        return a + b;
    }
}

// Se llama así:
int resultado = Utilidades.sumar(3, 4); // 7
```

---

## 📌 Conceptos Clave del Día 5

| Concepto | Explicación |
|:---|:---|
| **Interfaz** | Contrato que define **qué** métodos debe implementar una clase, sin decir **cómo**. |
| **`interface`** | Palabra clave para declarar una interfaz. |
| **`implements`** | Palabra clave para que una clase implemente una interfaz. |
| **Herencia múltiple** | Java no permite heredar de varias clases, pero sí implementar varias interfaces. |
| **Relación "puede-hacer"** | Las interfaces modelan capacidades, no jerarquías. |
| **Métodos `default`** | Métodos con implementación en la interfaz (Java 8+). |
| **Métodos `static`** | Métodos estáticos en la interfaz (Java 8+). |
| **Constantes** | Los atributos de una interfaz son `public static final` por defecto. |

---

## 💡 Buenas Prácticas

1. **Nombra las interfaces con un adjetivo o capacidad**: `Volador`, `Nadador`, `Comparable`, `Serializable`. Esto refleja que son comportamientos.
2. **Usa interfaces para desacoplar**: el código que depende de una interfaz no necesita saber la implementación concreta.
3. **Programa para interfaces, no para implementaciones**: declara variables y parámetros con el tipo de la interfaz.
4. **Una interfaz debe tener una responsabilidad clara**: no mezcles muchos comportamientos no relacionados en una sola interfaz.
5. **Usa `default` con moderación**: puede hacer que las interfaces se parezcan demasiado a clases abstractas.
6. **No abuses de las constantes en interfaces**: si necesitas muchas constantes, considera una clase aparte.

---

## ⚠️ Errores Comunes

### Error 1: Intentar instanciar una interfaz
```java
Volador v = new Volador(); // ❌ Error de compilación
```

### Error 2: No implementar todos los métodos
```java
public class Pajaro implements Volador {
    // ❌ Si Volador tiene 3 métodos y solo implementas 2, error
}
```

### Error 3: Poner atributos no constantes en una interfaz
```java
public interface MiInterfaz {
    private int contador; // ❌ No se permite (debe ser public static final)
}
```

### Error 4: Confundir `extends` con `implements`
```java
public class Pajaro extends Volador { } // ❌ Volador es interfaz, va implements
public class Pajaro implements Volador { } // ✅
```

### Error 5: Intentar que una interfaz herede de una clase
```java
public interface MiInterfaz extends MiClase { } // ❌ Solo de otras interfaces
```

---

## ✅ Checklist de Aprendizaje del Día 5

- [ ] Entiendo **qué es una interfaz** y por qué existe.
- [ ] Sé declarar una interfaz con `interface`.
- [ ] Sé implementar una interfaz con `implements`.
- [ ] Comprendo que una clase puede **implementar varias interfaces**.
- [ ] Sé diferenciar **interfaz** de **clase abstracta**.
- [ ] Comprendo la relación **"puede-hacer"** vs **"es-un"**.
- [ ] Sé cuándo usar una interfaz y cuándo una clase abstracta.
- [ ] Conozco las **reglas** de las interfaces (métodos públicos, atributos constantes, sin constructores).
- [ ] Sé que las interfaces resuelven el problema de la **herencia múltiple**.
- [ ] Conozco los métodos **`default`** y **`static`** (Java 8+).
- [ ] Puedo usar una interfaz como **tipo de referencia** (variables, arreglos, parámetros).

---