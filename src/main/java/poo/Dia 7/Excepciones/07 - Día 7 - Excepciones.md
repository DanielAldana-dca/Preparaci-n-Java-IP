# 📘 Día 7 - Excepciones

Tags: #POO #Java #Excepciones #tryCatch #Errores

## 🎯 Objetivos del Día

- Entender **qué es una excepción** y por qué es necesaria.
- Conocer la **jerarquía de excepciones** en Java.
- Comprender la diferencia entre **excepciones verificadas** y **no verificadas**.
- Aprender a usar `try`, `catch`, `finally`.
- Saber **lanzar** excepciones con `throw` y declararlas con `throws`.
- Aprender a crear **excepciones propias** (personalizadas).
- Conocer las **buenas prácticas** y **errores comunes**.

---

## 📚 ¿Qué es una Excepción? (La Idea Central)

Una **excepción** es un evento que ocurre durante la ejecución de un programa y que **interrumpe el flujo normal** de las instrucciones. Es la forma que tiene Java de decir: *"Algo salió mal, ¿qué quieres hacer?"*.

**Analogía:** Imagina que estás cocinando y de repente se quema la comida. 
- **Sin excepciones**: tiras todo, apagas la cocina y te vas (el programa se cierra abruptamente).
- **Con excepciones**: hueles que se quema, apagas el fuego, abres la ventana y decides qué hacer (el programa continúa funcionando).

Las excepciones permiten que el programa **no se detenga** ante un error, sino que pueda **manejarlo** y seguir funcionando.

---

## 🔍 Tipos de Errores en Programación

| Tipo | Descripción | Ejemplo |
|:---|:---|:---|
| **De compilación** | Impiden que el programa compile. | Olvidar un `;`, mal nombre de variable. |
| **De ejecución (excepciones)** | Ocurren mientras el programa corre. | Dividir entre cero, acceder a `null`. |
| **Lógicos** | El programa corre pero hace algo incorrecto. | Calcular mal un promedio. |

Hoy nos centramos en los **errores de ejecución**, que son los que se manejan con excepciones.

---

## 🌳 Jerarquía de Excepciones en Java

En Java, todas las excepciones heredan de la clase `Throwable`. Esta se divide en dos grandes ramas:

```
Throwable
├── Error (errores graves de la JVM, no se deben capturar)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception (errores que el programa puede manejar)
    ├── RuntimeException (No verificadas - Unchecked)
    │   ├── ArithmeticException
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ClassCastException
    │   ├── NumberFormatException
    │   └── ...
    │
    └── IOException (Verificadas - Checked)
        ├── FileNotFoundException
        ├── ...
        └── SQLException
```

### Excepciones Verificadas (Checked)
- El compilador **obliga** a manejarlas (con `try-catch` o declarando `throws`).
- Heredan de `Exception` (excepto `RuntimeException`).
- Ejemplos: `IOException`, `FileNotFoundException`, `SQLException`.

### Excepciones No Verificadas (Unchecked)
- El compilador **no obliga** a manejarlas.
- Heredan de `RuntimeException`.
- Ejemplos: `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException`.

**¿Por qué la diferencia?** Las verificadas son errores que el programador debería prever (como que un archivo no exista). Las no verificadas suelen ser errores de lógica (como dividir por cero) que se pueden evitar con validaciones.

---

## 🛠️ Estructura `try-catch-finally`

La estructura básica para manejar excepciones es:

```java
try {
    // Código que puede lanzar una excepción
} catch (TipoExcepcion1 e) {
    // Manejo de TipoExcepcion1
} catch (TipoExcepcion2 e) {
    // Manejo de TipoExcepcion2
} finally {
    // Se ejecuta SIEMPRE, haya o no excepción
}
```

### ¿Qué hace cada bloque?

| Bloque | Propósito |
|:---|:---|
| **`try`** | Contiene el código que puede fallar. |
| **`catch`** | Captura y maneja la excepción si ocurre. |
| **`finally`** | Se ejecuta siempre, ideal para liberar recursos (cerrar archivos, conexiones). |

### Reglas importantes
- Puede haber **múltiples `catch`** para diferentes tipos de excepción.
- El bloque `finally` es **opcional**.
- Si ocurre una excepción, el flujo salta directamente al `catch` correspondiente.
- Si no ocurre ninguna excepción, los `catch` se ignoran y se ejecuta el `finally` (si existe).

---

## 🔑 `throw` y `throws`

- **`throw`**: Se usa **dentro del cuerpo** de un método para **lanzar** una excepción manualmente.
- **`throws`**: Se usa en la **firma del método** para **declarar** que ese método puede lanzar ciertas excepciones (obliga a quien lo llame a manejarlas).

**Diferencia clave:**
- `throw` lanza una excepción en un punto específico.
- `throws` advierte que el método puede lanzar excepciones, delegando el manejo a quien lo invoque.

---

## 🎯 Excepciones Propias (Personalizadas)

Puedes crear tus propias excepciones extendiendo `Exception` (verificada) o `RuntimeException` (no verificada).

**¿Cuándo crear una excepción propia?**
- Cuando quieres representar un error específico de tu dominio (ej: `SaldoInsuficienteException`).
- Cuando quieres proporcionar información más detallada sobre el error.
- Cuando quieres que el manejo sea más claro y específico.

**Pasos:**
1. Crear una clase que herede de `Exception` o `RuntimeException`.
2. Definir un constructor que reciba un mensaje y lo pase a `super`.
3. Usarla con `throw` en los métodos que corresponda.

---

## 📊 Captura en Orden Jerárquico

Cuando tienes varias excepciones, debes capturar **primero las más específicas** (hijas) y **después las más generales** (padres). De lo contrario, el compilador da error.

**Orden correcto:**
```java
try {
    // código
} catch (NumberFormatException e) {   // Hija, primero
    System.out.println("Error de formato numérico");
} catch (Exception e) {                // Padre, después
    System.out.println("Error general");
}
```

**Orden incorrecto (error de compilación):**
```java
catch (Exception e) { ... }            // ❌ Padre primero
catch (NumberFormatException e) { ... } // ❌ Hija después
```

**¿Por qué?** Porque si capturas primero la clase padre, nunca llegarás a capturar la hija (ya que la hija es un caso particular del padre).

---

## 💡 Buenas Prácticas

1. **Captura excepciones específicas** antes que las generales.
2. **No uses `catch (Exception e) {}` vacío** (silenciar errores). Al menos imprime un mensaje o registra el error.
3. **No uses excepciones para control de flujo** (solo para errores reales).
4. **Usa `finally` para liberar recursos** (cerrar archivos, conexiones).
5. **Crea excepciones propias con mensajes descriptivos**.
6. **Documenta con `@throws`** en Javadoc qué excepciones puede lanzar un método.
7. **No declares `throws Exception`** de forma genérica; sé específico.
8. **Considera usar try-with-resources** para el manejo automático de recursos (Java 7+).

---

## ⚠️ Errores Comunes

### Error 1: Capturar la excepción padre antes que la hija
```java
try { ... }
catch (Exception e) { }        // ❌
catch (NumberFormatException e) { } // ❌ No compila
```

### Error 2: Ignorar la excepción (bloque catch vacío)
```java
try { ... }
catch (IOException e) { } // ❌ Se traga el error
```

### Error 3: Usar excepciones para control de flujo
```java
try {
    while (true) {
        // usar excepción para salir del bucle
    }
} catch (Exception e) { } // ❌ Mala práctica
```

### Error 4: No liberar recursos en `finally`
```java
BufferedReader br = new BufferedReader(new FileReader("f.txt"));
try {
    // leer
} catch (IOException e) { }
// ❌ Olvidar br.close()
```

### Error 5: Lanzar excepciones genéricas
```java
throw new Exception("Error"); // ❌ Muy genérico
throw new SaldoInsuficienteException("Saldo insuficiente"); // ✅ Específico
```

---

## 📌 Resumen del Día 7

| Concepto | Explicación |
|:---|:---|
| **Excepción** | Evento que interrumpe el flujo normal del programa. |
| **`try`** | Bloque que contiene el código que puede fallar. |
| **`catch`** | Captura y maneja la excepción. |
| **`finally`** | Se ejecuta siempre, ideal para liberar recursos. |
| **`throw`** | Lanza una excepción manualmente. |
| **`throws`** | Declara que un método puede lanzar excepciones. |
| **Verificadas** | El compilador obliga a manejarlas. |
| **No verificadas** | El compilador no obliga a manejarlas. |
| **Excepciones propias** | Extender `Exception` o `RuntimeException`. |
| **Orden de catch** | Hijas antes que padres. |

---

## ✅ Checklist de Aprendizaje del Día 7

- [ ] Entiendo qué es una excepción y por qué es necesaria.
- [ ] Conozco la jerarquía de excepciones en Java.
- [ ] Diferencio entre excepciones verificadas y no verificadas.
- [ ] Sé usar `try`, `catch`, `finally`.
- [ ] Sé lanzar excepciones con `throw`.
- [ ] Sé declarar excepciones con `throws`.
- [ ] Sé crear excepciones propias.
- [ ] Comprendo el orden correcto de los `catch`.
- [ ] Conozco las buenas prácticas al manejar excepciones.
- [ ] Identifico los errores comunes.

---

