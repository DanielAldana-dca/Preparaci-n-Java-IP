# 📘 Día 1 - Clases y Objetos

Tags: #POO #Java #Clases #Objetos

## 🎯 Objetivos
- Entender qué es una clase y un objeto
- Aprender encapsulamiento con `private`
- Crear constructores
- Métodos: consultores, modificadores, comportamiento

---

## 📖 Teoría

### ¿Qué es un Objeto?
> Entidad que combina **estado**, **comportamiento** e **identidad**.

- **Estado**: valores de sus atributos
- **Comportamiento**: acciones que puede realizar
- **Identidad**: lo distingue de otros objetos

### ¿Qué es una Clase?
> Plantilla o molde que define atributos y métodos comunes.

**Fórmula**: `Clase = Atributos + Métodos`

### Estructura de una clase
```java
public class NombreClase {
    // 1. Atributos (privados)
    private tipo nombre;
    
    // 2. Constructor
    public NombreClase(params) { ... }
    
    // 3. Métodos
    public tipoRetorno metodo(params) { ... }
}

##🔑 Conceptos Clave**
Concepto	Descripción	Ejemplo
Clase	Molde para crear objetos	class Automovil
Objeto	Instancia de una clase	new Automovil(...)
Atributo	Característica del objeto	private String marca
Método	Comportamiento	public void acelerar()
Constructor	Inicializa el objeto	public Automovil(...)
Encapsulamiento	Ocultar datos internos	private
##💡 Buenas Prácticas
**Atributos siempre** private

**Métodos públicos para interactuar**

**Usar this para distinguir atributos de parámetros**

**Validar datos en setters**

**Métodos con nombres descriptivos** (calcularPromedio en vez de calc)