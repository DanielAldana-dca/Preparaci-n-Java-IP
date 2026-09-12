# 📘 Día 2 - Relaciones entre Clases

Tags: #POO #Java #Asociacion #Agregacion #Composicion

## 🎯 Objetivos
- Diferenciar asociación, agregación y composición
- Implementar relaciones en Java con arrays

---

## 📊 Tabla Comparativa

| Relación | Fuerza | Ejemplo | Código clave |
|:---|:---:|:---|:---|
| **Asociación** | Interacción | Estudiante ↔ Curso | Referencias mutuas |
| **Agregación** | Débil | Escuela → Estudiante | Se pasa por parámetro |
| **Composición** | Fuerte | Auto → Motor | Se crea dentro |

---

## 🧩 Detalle de cada Relación

### 🔹 Asociación
Conexión entre objetos que se conocen mutuamente.

```java
public class Estudiante {
    private Curso[] cursos;  // Estudiante conoce Cursos
}
public class Curso {
    private Estudiante[] estudiantes;  // Curso conoce Estudiantes
}