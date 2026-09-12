# 📘 Día 6 - Genericidad

Tags: #POO #Java #Genericos #Lista #Wrappers

## 🎯 Objetivos del Día

- Entender **qué son los genéricos** y por qué son importantes.
- Comprender la **seguridad de tipos** y la **reutilización** que ofrecen.
- Conocer la **sintaxis** básica (`<T>`, clases y métodos genéricos).
- Aprender sobre **tipos acotados** y **comodines**.
- Entender la relación entre **genéricos y herencia**.
- Conocer los **wrappers** (clases envolventes) y su necesidad.
- Saber **cuándo y cómo** usar genéricos en tus programas.

---

## 📚 ¿Qué son los Genéricos? (La Idea Central)

Un **genérico** es un **parámetro de tipo**. Así como un método puede recibir parámetros de valor (números, textos), una clase o un método pueden recibir **parámetros de tipo** (String, Integer, Estudiante, etc.).

En lugar de escribir una clase para `String`, otra para `Integer` y otra para `Estudiante`, escribes **una sola clase** que funciona con **cualquier tipo**, y el compilador se encarga de verificar que todo sea correcto.

**Analogía:** Imagina una caja de cartón. La caja no sabe qué va a contener; puede guardar libros, ropa o herramientas. El genérico es como decir: "Esta caja solo guardará libros" (`Caja<Libro>`). Así, el compilador te avisa si intentas meter una camiseta.

---

## 🔍 ¿Por qué existen los Genéricos?

Antes de los genéricos, en Java se usaba `Object` para todo. Podías guardar cualquier cosa en una lista, pero al recuperarla, tenías que hacer **casting** manual y podías equivocarte.

**Problemas sin genéricos:**
- **Falta de seguridad de tipos**: podías meter un `String` en una lista de números y no te enterabas hasta que fallaba en ejecución.
- **Casting constante**: cada vez que sacabas un elemento, tenías que convertirlo a su tipo real.
- **Código repetitivo**: tenías que crear una lista para cada tipo (ListaEnteros, ListaStrings, etc.).

**Con genéricos:**
- **Seguridad de tipos**: el compilador te avisa si intentas meter el tipo incorrecto.
- **Sin casting**: al obtener un elemento, ya sabes de qué tipo es.
- **Reutilización**: una sola clase sirve para muchos tipos.

---

## 📐 Sintaxis Básica

### Clase genérica
```java
public class Caja<T> {
    private T contenido;
    public void guardar(T obj) { this.contenido = obj; }
    public T obtener() { return contenido; }
}
```

### Uso
```java
Caja<String> cajaTexto = new Caja<>();
cajaTexto.guardar("Hola");
String s = cajaTexto.obtener(); // Sin casting
```

### Múltiples parámetros de tipo
```java
public class Par<K, V> {
    private K clave;
    private V valor;
    // ...
}
```

### Convenciones de nombres
- `T` – Tipo (Type)
- `E` – Elemento (Element)
- `K` – Clave (Key)
- `V` – Valor (Value)
- `N` – Número (Number)

---

## 🎯 Tipos Acotados (Bounded Type Parameters)

Puedes restringir el tipo que se puede usar como parámetro genérico. Por ejemplo, que solo acepte números:

```java
public class ListaNumeros<T extends Number> { ... }
```

Así, `ListaNumeros<Integer>` y `ListaNumeros<Double>` son válidos, pero `ListaNumeros<String>` no.

**Sintaxis:**
- `<T extends Clase>` – T debe ser subclase de Clase (o la misma).
- `<T extends Interfaz>` – T debe implementar Interfaz.
- `<T extends Clase & Interfaz>` – Múltiples restricciones.

---

## 🎭 Comodines (Wildcards)

Los comodines se usan para representar un tipo desconocido.

| Comodín | Significado |
|:---|:---|
| `<?>` | Tipo desconocido |
| `<? extends Number>` | Cualquier subtipo de Number |
| `<? super Integer>` | Cualquier supertipo de Integer |

**Ejemplo de uso:**
```java
public void imprimirLista(Lista<?> lista) {
    for (int i = 0; i < lista.size(); i++) {
        System.out.println(lista.obtener(i));
    }
}
```

---

## 🔧 Métodos Genéricos

Un método puede tener su propio parámetro de tipo, independientemente de la clase.

```java
public static <T> void imprimirArreglo(T[] arreglo) {
    for (T elem : arreglo) {
        System.out.print(elem + " ");
    }
    System.out.println();
}
```

**Invocación:**
```java
Integer[] nums = {1, 2, 3};
String[] palabras = {"Hola", "Mundo"};
imprimirArreglo(nums);      // T = Integer
imprimirArreglo(palabras);  // T = String
```

---

## 🧬 Genéricos y Herencia

### Herencia de clases genéricas
Puedes heredar de una clase genérica y:
- **Concretar el tipo**: `class ListaEnteros extends Lista<Integer>`
- **Mantener el parámetro**: `class ListaEspecial<T> extends Lista<T>`

### Relación entre tipos genéricos
**Importante:** `Lista<Integer>` **no es** subtipo de `Lista<Number>`, aunque `Integer` sea subtipo de `Number`. Los genéricos en Java son **invariantes** en cuanto a tipos.

Para permitir subtipos, se usan comodines: `Lista<? extends Number>` acepta `Lista<Integer>`.

---

## 📦 Wrappers (Clases Envolventes)

Los genéricos **no aceptan tipos primitivos** (`int`, `double`, `char`, etc.). Para usarlos, se emplean sus **clases envolventes**:

| Primitivo | Wrapper |
|:---:|:---:|
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |
| `float` | `Float` |
| `long` | `Long` |
| `short` | `Short` |
| `byte` | `Byte` |

**Autoboxing:** conversión automática de primitivo a wrapper (`int` → `Integer`).
**Unboxing:** conversión automática de wrapper a primitivo (`Integer` → `int`).

```java
Lista<Integer> lista = new Lista<>();
lista.adicionar(5);        // autoboxing
int valor = lista.obtener(0); // unboxing
```

---

## 📋 Implementación de una Lista Genérica

Una clase genérica típica es `Lista<T>`. Internamente, como no se pueden crear arreglos genéricos (`new T[10]` no compila), se usa un arreglo de `Object` y se hace casting al obtener elementos.

**Conceptos clave:**
- Atributo: `private Object[] elementos;`
- Añadir: `elementos[cantReal++] = elem;`
- Obtener: `return (T) elementos[pos];` (con `@SuppressWarnings("unchecked")`).
- Eliminar: desplazar elementos hacia la izquierda y reducir `cantReal`.
- Tamaño: `cantReal`.

Esta implementación permite que la lista funcione con cualquier tipo, manteniendo la seguridad de tipos en el exterior.

---

## 💡 Beneficios de los Genéricos

1. **Seguridad de tipos**: errores detectados en compilación, no en ejecución.
2. **Eliminación de casting**: el código es más limpio y legible.
3. **Reutilización**: una clase sirve para múltiples tipos.
4. **Legibilidad**: `Lista<String>` es más claro que `Lista` a secas.
5. **Rendimiento**: no hay sobrecarga en tiempo de ejecución (el compilador genera el código necesario).

---

## ⚠️ Errores Comunes

### Error 1: No usar wrappers
```java
Lista<int> lista = new Lista<>(); // ❌ Los genéricos no aceptan primitivos
Lista<Integer> lista = new Lista<>(); // ✅
```

### Error 2: Confundir tipos genéricos con herencia
```java
Lista<Integer> enteros = new Lista<>();
Lista<Number> numeros = enteros; // ❌ No compila, son tipos diferentes
```

### Error 3: Crear arreglos genéricos
```java
T[] arreglo = new T[10]; // ❌ No se puede
Object[] arreglo = new Object[10]; // ✅ y luego casting
```

### Error 4: Usar `instanceof` con genéricos
```java
if (obj instanceof Lista<String>) { } // ❌ No se puede (por type erasure)
```

### Error 5: Olvidar el `@SuppressWarnings("unchecked")` al hacer casting
```java
@SuppressWarnings("unchecked")
public T obtener(int pos) { return (T) elementos[pos]; }
```

---

## 📌 Resumen del Día 6

| Concepto | Explicación |
|:---|:---|
| **Genérico** | Parámetro de tipo que permite reutilizar clases con cualquier tipo. |
| **`<T>`** | Se usa en la declaración de la clase/método. |
| **`Lista<T>`** | Contenedor genérico típico. |
| **Wrappers** | Clases como `Integer`, `Double` para usar primitivos en genéricos. |
| **Tipos acotados** | `<T extends Number>` restringe el tipo. |
| **Comodines** | `<?>`, `<? extends X>`, `<? super X>`. |
| **Métodos genéricos** | `<T> T metodo(T param)`. |
| **Herencia genérica** | `class Hija<T> extends Padre<T>` o `class Hija extends Padre<Integer>`. |
| **Type erasure** | Los genéricos se borran en tiempo de ejecución. |

---

## ✅ Checklist de Aprendizaje del Día 6

- [ ] Entiendo qué es un genérico y por qué existe.
- [ ] Sé declarar una clase genérica (`class Caja<T>`).
- [ ] Sé usar una clase genérica (`Caja<String> c = new Caja<>()`).
- [ ] Comprendo la diferencia entre tipos primitivos y wrappers.
- [ ] Sé qué son los tipos acotados (`<T extends Number>`).
- [ ] Conozco los comodines (`<?>`, `<? extends X>`, `<? super X>`).
- [ ] Sé crear métodos genéricos.
- [ ] Comprendo la relación entre genéricos y herencia.
- [ ] Sé por qué `Lista<Integer>` no es subtipo de `Lista<Number>`.
- [ ] Conozco los beneficios de los genéricos.
- [ ] Identifico los errores comunes al usar genéricos.

---
