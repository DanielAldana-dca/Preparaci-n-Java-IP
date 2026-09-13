# 📊 Tablas Resumen

Tags: #Resumen #Tablas #Referencia

> Recopilación de todas las tablas comparativas y resúmenes clave del curso de POO en Java.

---

## 🎯 Tabla General de Conceptos

| Concepto | Definición | Palabra clave |
|:---|:---|:---|
| **Clase** | Plantilla para crear objetos | `class` |
| **Objeto** | Instancia concreta de una clase | `new` |
| **Atributo** | Característica o estado del objeto | `private tipo nombre` |
| **Método** | Comportamiento del objeto | `public tipo nombre()` |
| **Constructor** | Inicializa el objeto al crearlo | `public NombreClase()` |
| **Encapsulamiento** | Ocultar datos internos | `private` |
| **Herencia** | Relación "es-un" | `extends` |
| **Polimorfismo** | Muchas formas de un mismo método | `@Override` |
| **Abstracción** | Clase sin instancias | `abstract` |
| **Interfaz** | Contrato de comportamiento | `interface` / `implements` |
| **Genérico** | Tipo parametrizado | `<T>` |
| **Excepción** | Error manejable en ejecución | `try-catch` |
| **Fichero** | Persistencia de datos | `FileWriter` / `FileReader` |

---

## 🔄 Relaciones entre Clases

| Relación | Fuerza | Ejemplo | Implementación en Java |
|:---|:---:|:---|:---|
| **Asociación** | Interacción | Estudiante ↔ Curso | Referencias mutuas |
| **Agregación** | Débil | Escuela → Estudiante | Se pasa por parámetro |
| **Composición** | Fuerte | Auto → Motor | `new Motor()` dentro del constructor |
| **Herencia** | "es-un" | Perro → Animal | `extends` |
| **Implementación** | Contrato | Pájaro → Volador | `implements` |

---

## 📐 Multiplicidad UML

| Símbolo | Significado |
|:---:|:---|
| `1` | Exactamente uno |
| `*` | Cero o más (muchos) |
| `0..1` | Cero o uno (opcional) |
| `1..*` | Uno o más |
| `0..*` | Cero o más |

---

## 🎨 Modificadores de Acceso

| Modificador | Clase | Paquete | Subclase | Todos |
|:---|:---:|:---:|:---:|:---:|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

---

## 🆚 Abstracta vs Interfaz

| Aspecto | Clase Abstracta | Interfaz |
|:---|:---|:---|
| **Palabra clave** | `abstract class` | `interface` |
| **Relación** | "es-un" | "puede-hacer" |
| **Herencia** | Una sola | Múltiples |
| **Atributos** | Cualquiera | Solo constantes (`public static final`) |
| **Métodos** | Concretos y abstractos | Solo abstractos (+ `default` en Java 8+) |
| **Constructores** | Sí | No |
| **Instanciable** | ❌ No | ❌ No |
| **Cuándo usar** | Jerarquía + código compartido | Comportamiento común a clases dispares |

---

## 🔄 Sobrescritura vs Sobrecarga

| Aspecto | Sobrescritura (Override) | Sobrecarga (Overload) |
|:---|:---|:---|
| **Dónde ocurre** | Entre clases (padre e hija) | En la misma clase |
| **Firma** | Idéntica | Mismo nombre, diferentes parámetros |
| **Anotación** | `@Override` (recomendada) | No aplica |
| **Momento de decisión** | Tiempo de ejecución | Tiempo de compilación |
| **Ejemplo** | `calcularPago()` en Gerente | `saludar()` y `saludar(String)` |
| **Tipo de polimorfismo** | Dinámico | Estático |

---

## 🧬 ¿Qué se Hereda?

| Elemento | ¿Heredado? |
|:---|:---:|
| Atributos `public` / `protected` | ✅ Sí |
| Atributos `private` | ❌ No (accesibles solo por getters/setters del padre) |
| Métodos `public` / `protected` | ✅ Sí |
| Métodos `private` | ❌ No |
| Constructores | ❌ No (se llaman con `super()`) |

---

## 📦 Wrappers (Clases Envolventes)

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

---

## 🌳 Jerarquía de Excepciones

```
Throwable
├── Error (graves, no se capturan)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception (manejables)
    ├── RuntimeException (No verificadas)
    │   ├── ArithmeticException
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ClassCastException
    │   └── NumberFormatException
    │
    └── IOException (Verificadas)
        ├── FileNotFoundException
        └── ...
```

---

## ⚠️ Excepciones Verificadas vs No Verificadas

| Verificadas (Checked) | No Verificadas (Unchecked) |
|:---|:---|
| El compilador **obliga** a manejarlas | El compilador **no obliga** a manejarlas |
| Heredan de `Exception` (excepto `RuntimeException`) | Heredan de `RuntimeException` |
| `IOException`, `FileNotFoundException` | `ArithmeticException`, `NullPointerException` |
| Se deben capturar o declarar con `throws` | Se pueden capturar opcionalmente |

---

## 📂 Ficheros: Comparativa Completa

| Aspecto | Texto | Binario | Serialización |
|:---|:---|:---|:---|
| **Escribir** | `FileWriter` + `BufferedWriter` | `DataOutputStream` + `FileOutputStream` | `ObjectOutputStream` + `FileOutputStream` |
| **Leer** | `FileReader` + `BufferedReader` | `DataInputStream` + `FileInputStream` | `ObjectInputStream` + `FileInputStream` |
| **Método escribir** | `write()` | `writeInt()`, `writeUTF()`, etc. | `writeObject()` |
| **Método leer** | `readLine()` | `readInt()`, `readUTF()`, etc. | `readObject()` |
| **Legible** | ✅ Sí | ❌ No | ❌ No |
| **Guarda objetos** | ❌ No | ❌ No | ✅ Sí |
| **Requiere** | Nada | Nada | `implements Serializable` |
| **Uso típico** | Reportes, config | Datos compactos | Estado de objetos |

---

## 🎯 Palabras Clave del Lenguaje

| Palabra | Uso |
|:---|:---|
| `this` | Referencia al objeto actual |
| `super` | Referencia a la superclase |
| `new` | Crear un objeto |
| `extends` | Heredar de una clase |
| `implements` | Implementar una interfaz |
| `abstract` | Clase o método abstracto |
| `static` | Pertenece a la clase, no al objeto |
| `final` | Constante / no se puede cambiar |
| `instanceof` | Verificar el tipo de un objeto |
| `throws` | Declarar excepciones que puede lanzar un método |
| `throw` | Lanzar una excepción |
| `try` / `catch` / `finally` | Manejo de excepciones |

---

## 📊 Tipos de Métodos

| Tipo | Propósito | Ejemplo |
|:---|:---|:---|
| **Constructor** | Crear e inicializar objetos | `public Estudiante(...)` |
| **Consultor (Getter)** | Obtener información | `public String getNombre()` |
| **Modificador (Setter)** | Cambiar el estado | `public void setNombre(String n)` |
| **Comportamiento** | Realizar acciones | `public double calcularPromedio()` |
| **toString** | Representación en texto | `@Override public String toString()` |

---

## ✅ Checklist General de Conceptos

| Concepto | ¿Lo domino? |
|:---|:---:|
| Clases y objetos | ☐ |
| Encapsulamiento (`private`) | ☐ |
| Constructores | ☐ |
| Getters y setters | ☐ |
| `toString()` | ☐ |
| Asociación | ☐ |
| Agregación | ☐ |
| Composición | ☐ |
| Herencia (`extends`) | ☐ |
| `super` y `this` | ☐ |
| Polimorfismo | ☐ |
| Ligadura dinámica | ☐ |
| Clases abstractas | ☐ |
| Métodos abstractos | ☐ |
| Interfaces | ☐ |
| `implements` | ☐ |
| Genéricos (`<T>`) | ☐ |
| Wrappers | ☐ |
| Excepciones | ☐ |
| `try-catch-finally` | ☐ |
| Excepciones propias | ☐ |
| Ficheros de texto | ☐ |
| Ficheros binarios | ☐ |
| Serialización | ☐ |

---
