# 📘 Día 3 - Herencia

Tags: #POO #Java #Herencia #extends #super

## 🎯 Objetivos
- Entender la relación "es-un"
- Usar `extends`, `super`, `protected`
- Sobrescribir métodos con `@Override`
- Aplicar casting y `instanceof`

---

## 📖 Teoría

> **Herencia**: Mecanismo que permite definir una clase nueva (subclase) basada en otra existente (superclase).

**Relación**: "es-un"
- Un `Perro` **es un** `Animal`
- Un `Profesor` **es un** `Empleado`

---

## 🔑 Palabras Clave

| Palabra | Uso |
|:---|:---|
| `extends` | Heredar de una clase |
| `super` | Referencia al padre |
| `super()` | Llamar constructor del padre |
| `super.metodo()` | Llamar método del padre |
| `protected` | Visible para subclases |
| `@Override` | Sobrescribir método |

---

## 📐 Sintaxis

```java
// Superclase
public class Animal {
    protected String nombre;
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public void hacerSonido() {
        System.out.println("Sonido genérico");
    }
}

// Subclase
public class Perro extends Animal {
    private String raza;
    
    public Perro(String nombre, String raza) {
        super(nombre);  // OBLIGATORIO primero
        this.raza = raza;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}