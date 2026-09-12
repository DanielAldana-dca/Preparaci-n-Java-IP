# 📘 Día 8 - Ficheros

Tags: #POO #Java #Ficheros #Serializacion #Persistencia

## 🎯 Objetivos del Día

- Entender **qué es un fichero** y por qué es esencial para la persistencia.
- Diferenciar entre **ficheros de texto**, **ficheros binarios** y **serialización**.
- Conocer las **clases principales** para leer y escribir en cada tipo.
- Comprender los **pasos generales** para trabajar con ficheros.
- Aprender a **serializar objetos** y por qué es útil.
- Conocer las **buenas prácticas** y **errores comunes**.

---

## 📚 ¿Qué es un Fichero? (La Idea Central)

Un **fichero** es una abstracción del sistema operativo para almacenar información de manera **permanente**. A diferencia de la memoria RAM (volátil), los datos en un fichero sobreviven al cierre del programa y al apagado del equipo.

**Analogía:** 
- **RAM** = pizarra: escribes, pero al final del día se borra.
- **Fichero** = libreta: escribes y puedes volver a leerlo días después.

**Ventajas:**
- Persistencia de datos.
- No se pierden por fallos eléctricos.
- Se pueden transportar y compartir.

---

## 🗂️ Tipos de Ficheros

En Java, trabajamos con tres enfoques principales:

| Tipo | ¿Qué guarda? | Legible por humanos | Tamaño | Clases principales |
|:---|:---|:---:|:---:|:---|
| **Texto** | Caracteres (letras, números, símbolos) | ✅ Sí | Más grande | `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter` |
| **Binario** | Datos en su formato nativo (bytes) | ❌ No | Más pequeño | `FileInputStream`, `FileOutputStream`, `DataInputStream`, `DataOutputStream` |
| **Serialización** | Objetos completos | ❌ No | Compacto | `ObjectInputStream`, `ObjectOutputStream` |

**¿Cuándo usar cada uno?**
- **Texto**: reportes, archivos de configuración, datos que deban ser leídos por humanos.
- **Binario**: datos compactos, imágenes, sonidos, o cuando el rendimiento es crítico.
- **Serialización**: guardar el estado completo de objetos Java para recuperarlos después.

---

## 📝 Ficheros de Texto

### Escritura (Escribir en un fichero)

**Clases:** `FileWriter` (escribe caracteres) y `BufferedWriter` (mejora el rendimiento mediante buffer).

**Pasos:**
1. Crear un `FileWriter` con la ruta del archivo (si no existe, se crea; si existe, se sobrescribe).
2. Envolverlo en un `BufferedWriter`.
3. Usar `write(String)` para escribir texto y `newLine()` para saltos de línea.
4. **Cerrar** el `BufferedWriter` con `close()` (indispensable para que los datos se guarden).

**Ejemplo mínimo:**
```java
BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt"));
bw.write("Hola");
bw.newLine();
bw.close();
```

### Lectura (Leer de un fichero)

**Clases:** `FileReader` (lee caracteres) y `BufferedReader` (mejora el rendimiento).

**Pasos:**
1. Crear un `FileReader` con la ruta del archivo. Si no existe, lanza `FileNotFoundException`.
2. Envolverlo en un `BufferedReader`.
3. Usar `readLine()` en un bucle: devuelve `null` al final del archivo.
4. **Cerrar** el `BufferedReader`.

**Ejemplo mínimo:**
```java
BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
String linea;
while ((linea = br.readLine()) != null) {
    System.out.println(linea);
}
br.close();
```

### Consideraciones
- Los ficheros de texto son **legibles** y **fáciles de editar** con cualquier editor.
- Son **más grandes** que los binarios porque almacenan caracteres.
- Se debe manejar `IOException` (verificada) con `try-catch` o `throws`.

---

## 🔢 Ficheros Binarios

### Escritura

**Clases:** `FileOutputStream` (escribe bytes) y `DataOutputStream` (escribe tipos primitivos y String).

**Pasos:**
1. Crear `FileOutputStream` con la ruta.
2. Envolverlo en `DataOutputStream`.
3. Usar métodos como `writeInt()`, `writeDouble()`, `writeUTF()`, `writeBoolean()`, etc.
4. **Cerrar** el stream.

**Ejemplo mínimo:**
```java
DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.bin"));
dos.writeUTF("Hola");
dos.writeInt(42);
dos.close();
```

### Lectura

**Clases:** `FileInputStream` y `DataInputStream`.

**Pasos:**
1. Crear `FileInputStream` con la ruta.
2. Envolverlo en `DataInputStream`.
3. Leer **en el mismo orden** en que se escribió, usando `readUTF()`, `readInt()`, etc.
4. **Cerrar** el stream.

**Ejemplo mínimo:**
```java
DataInputStream dis = new DataInputStream(new FileInputStream("datos.bin"));
String s = dis.readUTF();
int n = dis.readInt();
dis.close();
```

### Consideraciones
- **No son legibles** por humanos.
- Son **más compactos** y **rápidos** que los de texto.
- Es **crítico** leer en el mismo orden en que se escribió; de lo contrario, los datos se corrompen.
- También lanzan `IOException`.

---

## 🔐 Serialización (Guardar Objetos Completos)

La **serialización** es el proceso de convertir un objeto completo en una secuencia de bytes para almacenarlo o transmitirlo. La **deserialización** es el proceso inverso.

### Requisitos
- La clase del objeto debe implementar la interfaz `java.io.Serializable`.
- Es recomendable definir un `serialVersionUID` para controlar versiones.

```java
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    // ...
}
```

### Escritura (Serializar)
**Clases:** `FileOutputStream` y `ObjectOutputStream`.

**Pasos:**
1. Crear `FileOutputStream`.
2. Envolverlo en `ObjectOutputStream`.
3. Usar `writeObject(objeto)`.
4. **Cerrar**.

**Ejemplo mínimo:**
```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.ser"));
oos.writeObject(estudiante);
oos.close();
```

### Lectura (Deserializar)
**Clases:** `FileInputStream` y `ObjectInputStream`.

**Pasos:**
1. Crear `FileInputStream`.
2. Envolverlo en `ObjectInputStream`.
3. Usar `readObject()` y hacer casting al tipo correspondiente.
4. **Cerrar**.

**Ejemplo mínimo:**
```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.ser"));
Estudiante e = (Estudiante) ois.readObject();
ois.close();
```

### Consideraciones
- Solo se serializan los **atributos** del objeto, no los métodos.
- Si un atributo no debe serializarse, se marca como `transient`.
- Los objetos referenciados también deben ser serializables.
- Se lanzan `IOException` y `ClassNotFoundException` (esta última al deserializar).

---

## 📊 Comparativa de los Tres Tipos

| Aspecto | Texto | Binario | Serialización |
|:---|:---|:---|:---|
| **Legible** | ✅ Sí | ❌ No | ❌ No |
| **Guarda objetos** | ❌ No | ❌ No | ✅ Sí |
| **Tipos primitivos** | Como texto (parseo) | Directo | Directo |
| **Tamaño** | Grande | Pequeño | Compacto |
| **Velocidad** | Más lento | Rápido | Rápido |
| **Complejidad** | Baja | Media | Media |
| **Uso típico** | Reportes, configuración | Datos compactos | Estado de objetos |

---

## 🧭 Pasos Generales para Trabajar con Ficheros

Independientemente del tipo, los pasos son:
1. **Abrir** el fichero (crear el stream de bajo nivel).
2. **Envolver** en un stream de alto nivel (buffer, datos, objetos).
3. **Leer** o **escribir**.
4. **Cerrar** el stream (liberar recursos y asegurar que los datos se guarden).

Siempre manejar las excepciones (`IOException` y sus subclases) con `try-catch` o `try-with-resources`.

---

## 💡 Buenas Prácticas

1. **Siempre cerrar los streams** (usar `try-with-resources` para simplificar).
2. **Manejar las excepciones** de E/S adecuadamente; no ignorarlas.
3. **Usar buffer** (`BufferedReader`, `BufferedWriter`) para mejorar el rendimiento.
4. **En binario, leer en el mismo orden** en que se escribió.
5. **Serializar solo cuando sea necesario**; a veces es mejor guardar datos en texto.
6. **Definir `serialVersionUID`** en clases serializables.
7. **Evitar rutas absolutas** en el código; usar rutas relativas o configurables.
8. **Usar `try-with-resources`** (Java 7+) para el cierre automático.

---

## ⚠️ Errores Comunes

### Error 1: Olvidar cerrar el stream
```java
BufferedWriter bw = new BufferedWriter(new FileWriter("f.txt"));
bw.write("Hola");
// ❌ Falta bw.close(); los datos pueden no guardarse
```

### Error 2: No manejar `IOException`
```java
FileReader fr = new FileReader("f.txt"); // ❌ Error de compilación si no se maneja
```

### Error 3: Leer en orden incorrecto (binario/serialización)
```java
// Se escribió: writeUTF, writeInt
String s = dis.readInt(); // ❌ Provoca error o datos corruptos
```

### Error 4: Intentar serializar un objeto no serializable
```java
public class MiClase { } // ❌ No implementa Serializable
ObjectOutputStream oos = ...;
oos.writeObject(new MiClase()); // Lanza NotSerializableException
```

### Error 5: Usar `transient` incorrectamente
```java
private transient int contador; // No se serializa, pero se pierde su valor
```

### Error 6: No usar buffer (rendimiento pobre)
```java
FileWriter fw = new FileWriter("f.txt"); // ❌ Sin buffer
```

---

## 📌 Resumen del Día 8

| Concepto | Explicación |
|:---|:---|
| **Fichero** | Archivo en disco para persistencia de datos. |
| **Texto** | Legible, usa `FileWriter`/`FileReader` con buffer. |
| **Binario** | Compacto, usa `DataOutputStream`/`DataInputStream`. |
| **Serialización** | Guarda objetos completos; requiere `Serializable`. |
| **Stream** | Flujo de datos; siempre cerrar. |
| **`IOException`** | Excepción verificada en operaciones de E/S. |
| **`try-with-resources`** | Cierre automático de recursos (Java 7+). |

---

## ✅ Checklist de Aprendizaje del Día 8

- [ ] Entiendo qué es un fichero y por qué es importante.
- [ ] Diferencio ficheros de texto, binarios y serialización.
- [ ] Sé escribir y leer en ficheros de texto.
- [ ] Sé escribir y leer en ficheros binarios.
- [ ] Comprendo la serialización y sus requisitos.
- [ ] Sé usar `try-with-resources` para cerrar automáticamente.
- [ ] Conozco las buenas prácticas al trabajar con ficheros.
- [ ] Identifico los errores comunes.
- [ ] Sé cuándo usar cada tipo de fichero.

---

