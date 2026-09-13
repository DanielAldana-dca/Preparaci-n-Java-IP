# 📚 Organización de Proyectos por Grupos y Dificultad

Tags: #Proyectos #Exámenes #Práctica #Organización

> **Objetivo:** Organizar los 39 proyectos de examen por **grupos de dificultad** y **conceptos necesarios**, alineados con los 9 días de estudio del curso. Cada grupo construye sobre el anterior.

---

## 🗺️ Mapa de Progresión

```
Grupo 1 (Días 1-3)  →  Grupo 2 (Días 1-5)  →  Grupo 3 (Días 1-6)  →  Grupo 4 (Días 1-8)  →  Grupo 5 (Días 1-9)
   Básico               Intermedio             Intermedio+            Avanzado              Experto
   (Consola)            (Consola)              (Consola)              (Consola)             (GUI + Lógica)
```

---

## 📊 Tabla Resumen de Grupos

| Grupo | Días necesarios | Dificultad | Nº Proyectos | ¿GUI? | ¿Ficheros? | ¿Genéricos? |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 🟢 1 | 1-3 | ⭐ | 5 | ❌ | ❌ | ❌ |
| 🟡 2 | 1-5 | ⭐⭐ | 16 | ❌ | ❌ | ❌ |
| 🟠 3 | 1-6 | ⭐⭐⭐ | 5 | ❌ | ❌ | ✅ |
| 🔴 4 | 1-8 | ⭐⭐⭐⭐ | 6 | ❌ | ✅ | ✅ |
| 🟣 5 | 1-9 | ⭐⭐⭐⭐⭐ | 10 | ✅ | ✅ | ✅ |

---

## 🟢 GRUPO 1: Básico (Días 1-3)

**Conceptos necesarios:**
- Clases, objetos, encapsulamiento (Día 1)
- Asociación, agregación, composición (Día 2)
- Herencia (`extends`, `super`, `protected`) (Día 3)

**Características:**
- Solo consola
- 3-5 clases
- Cálculos simples
- Sin ficheros
- Sin genéricos

| # | Nombre del Proyecto | Clases principales | Conceptos clave |
|:---:|:---|:---|:---|
| **40** | Control de Datos | Estudiante, AlumnoAyudante, LicenciaEspecial, Asignatura | Herencia, promedio, estipendio |
| **68** | Programa Musical | Cancion, Pop, Rock, Salsa | Herencia, cálculo de aceptación |
| **69** | Tienda de mascotas | Mascota, Perro, Gato | Herencia, precios, filtros |
| **73** | Where is it | DVD, Archivo, MP3, MPEG | Herencia, duración, búsquedas |
| **67** | Oficinas de Correo | Correspondencia, Carta, Telegrama, Bulto | Herencia, precios, prioridades |

---

## 🟡 GRUPO 2: Intermedio (Días 1-5)

**Conceptos necesarios:**
- Todo lo del Grupo 1
- Polimorfismo y clases abstractas (Día 4)
- Interfaces (Día 5)

**Características:**
- Solo consola
- 5-8 clases
- Métodos polimórficos
- Posible uso de interfaces
- Sin ficheros

| # | Nombre del Proyecto | Clases principales | Conceptos clave |
|:---:|:---|:---|:---|
| **41** | Viajes Turísticos | Viaje, Excursion, Persona, Cubano, Extranjero, Carro, Taxi, Panel, Autobus | Herencia, polimorfismo, precios |
| **42** | Librería | Material, Libro, Revista | Herencia, ranking, ventas |
| **43** | Empresa de software | Trabajador, Programador, Lider, Proyecto, Equipo | Herencia, salarios, asociación |
| **44** | Dirección Provincial de Cultura | Agrupacion, Nacional, Profesional, Aficionada, Extranjera, Actividad | Herencia, polimorfismo, pagos |
| **45** | Empresa de Transporte | Camion, Antiguo, Moderno, Viaje, Trabajador, Administrativo, Chofer | Herencia, nómina |
| **46** | Empresa Turística | Excursion, Persona, Carro, Guagua | Herencia, recaudación |
| **50** | Fábrica de Conservas | Producto, Envase, Nacional, Importado, Trabajador | Herencia, precios |
| **60** | FarmaSoft 2006 | Medicamento, Nacional, Importado, Donacion, Estante | Herencia, polimorfismo, precios |
| **66** | Ministerio de Comunicaciones | Cliente, Particular, Estatal, EnDolares, Consumo | Herencia, facturación |
| **70** | Terminal aérea | Avion, Nacional, Turismo, Pasajero, ListaOficial, ListaEspera | Herencia, precios, listas |
| **71** | Sistema de Reservaciones | Viajero, Chofer, Viaje, Tarifa | Herencia, reservas |
| **72** | Casas en la Playa | Casa, Contrato, Empresa, Trabajador | Herencia, alquileres |
| **75** | Producción Multimedia | Trabajador, Desarrollador, JefeProyecto, Administrativo, Multimedia | Herencia, salarios, asociación |
| **77** | Portal Internet | Usuario, Avanzado, Estandar, Administrador, Mensaje | Herencia, buzones |
| **56** | Circuito Electrónico | Circuito, Simple, Compuesto, Resistor, Inductor, Capacitor | **Composición**, polimorfismo |
| **58** | Componentes | Componente, Simple, Integrado | **Composición**, precios |

---

## 🟠 GRUPO 3: Intermedio+ (Días 1-6)

**Conceptos necesarios:**
- Todo lo del Grupo 2
- **Genericidad** (`Lista<T>`, wrappers) (Día 6)

**Características:**
- Solo consola
- Uso de `Lista<T>` genérica
- Manejo de colecciones propias
- Sin ficheros (o muy básicos)

| # | Nombre del Proyecto | Clases principales | Conceptos clave |
|:---:|:---|:---|:---|
| **76** | Central Telefónica | Cliente, Llamada, Local, Interprovincial, Centralita | **Genéricos obligatorios**, cálculos complejos |
| **51** | Aeropuertos | Terminal, Vuelo, Nacional, Internacional, Avion, Pasaje | **Genéricos**, ventas, precios por clase |
| **53** | Automatización Biblioteca UCI | Usuario, Profesor, Estudiante, Material, Libro, Revista, Servicio | **Genéricos**, herencia, restricciones |
| **59** | Control de Residencia | Residencia, Apto, Becado, Cubano, Extranjero | **Genéricos**, evaluaciones complejas |
| **57** | Compilando Partida | Tablero, Pieza, Rey, Dama, Torre, Alfil, Caballo, Peon | **Genéricos**, validación de notación |

---

## 🔴 GRUPO 4: Avanzado (Días 1-8)

**Conceptos necesarios:**
- Todo lo del Grupo 3
- **Excepciones** (Día 7)
- **Ficheros** (texto, binario, serialización) (Día 8)

**Características:**
- Solo consola
- Uso intensivo de ficheros
- Manejo de excepciones
- 8-12 clases
- Lógica compleja

| # | Nombre del Proyecto | Clases principales | Conceptos clave |
|:---:|:---|:---|:---|
| **49** | Biblioteca | Usuario, Asociado, Eventual, Material, Libro, Revista, Prestamo | **Ficheros**, excepciones, préstamos |
| **54** | Biblioteca (UCI) | Usuario, Asociado, Material, Libro, Revista, Acta, Articulo | **Ficheros**, peso máximo, préstamos |
| **55** | Camiones del Oriente | Camion, Ligero, Pesado, Viaje, Chofer | **Ficheros**, nómina, reportes |
| **64** | Learning Chess | Tablero, Pieza, Movimiento | **Ficheros**, validación, jaque mate |
| **47** | Destruyendo barcos | Tablero, Barco, Lancha, Submarino, Acorazado, Portaviones, Jugador, Humano, Ordenador | **Ficheros** (records), polimorfismo, lógica de juego |
| **18** | Jurassic Park | Tablero, Celda, Planta, Animal, Braquiosaurio, Triceratops, Velociraptor, Pterodactilo, TRex, Huevo, Cadáver | **Ficheros**, simulación compleja, IA |

---

## 🟣 GRUPO 5: Experto (Días 1-9)

**Conceptos necesarios:**
- Todo lo del Grupo 4
- **GUI (Swing)** (Día 9)

**Características:**
- **Requieren interfaz gráfica**
- 10+ clases
- Múltiples ventanas o paneles
- Eventos, `ActionListener`
- Lógica compleja + GUI

| # | Nombre del Proyecto | Clases principales | Conceptos clave |
|:---:|:---|:---|:---|
| **48** | Juego de la Serpiente | Serpiente, Laberinto, Comida, Nivel, Juego | **GUI**, hilos (`Timer`), eventos de teclado |
| **61** | Gato y Ratón | Tablero, Pieza, Gato, Raton, Jugador | **GUI**, ajedrez, historial inverso |
| **62** | Graficador de Funciones | Funcion, Variable, Constante, Suma, Resta, Mult, Div, Seno, Coseno | **GUI**, composición, gráficos |
| **63** | Juego de Cálculo Matemático | Ejercicio, Suma, Resta, Mult, Division, Jugador, Ranking | **GUI**, banco de problemas |
| **74** | Juego Ahorcado | Palabra, Categoria, Jugador, Basico, Experto | **GUI**, ficheros de palabras |
| **52** | Álbum de Fotos | Foto, Cuadro, Background, Simple, Compuesto, Pieza, Figura, Texto | **GUI**, composición, editor gráfico |
| **77** | Portal Internet | Usuario, Avanzado, Estandar, Administrador, Mensaje, Pregunta, Respuesta | **GUI**, sesiones, buzones |
| **51** | Aeropuertos | Terminal, Vuelo, Avion, Pasaje, Cliente | **GUI**, persistencia XML |
| **53** | Automatización Biblioteca UCI | Usuario, Material, Servicio | **GUI**, servicios |
| **76** | Central Telefónica | Cliente, Llamada, Centralita | **GUI**, reportes |

---

## 📅 Plan de Práctica Recomendado (6 Semanas)

| Semana | Grupo | Proyectos sugeridos | Objetivo |
|:---:|:---|:---|:---|
| **1** | 🟢 Grupo 1 | #40, #68, #69 | Dominar herencia simple |
| **2** | 🟡 Grupo 2 | #41, #42, #43 | Dominar polimorfismo |
| **3** | 🟡 Grupo 2 | #45, #50, #60 | Dominar interfaces y abstractas |
| **4** | 🟠 Grupo 3 | #76, #59 | Dominar genéricos |
| **5** | 🔴 Grupo 4 | #49, #55 | Dominar ficheros y excepciones |
| **6** | 🟣 Grupo 5 | #48, #61, #74 | Dominar GUI |

---

## 🎯 Recomendación de Inicio

**Empieza con estos 3 proyectos en orden:**

1. **#40 Control de Datos** → Herencia simple + cálculos
2. **#68 Programa Musical** → Herencia + filtros
3. **#69 Tienda de mascotas** → Herencia + ordenamiento

Una vez domines estos, pasa al **Grupo 2** con:
1. **#42 Librería** → Polimorfismo básico
2. **#41 Viajes Turísticos** → Polimorfismo + asociación

---

## 💡 Consejos

1. **No saltes grupos**: cada uno construye sobre el anterior.
2. **Haz un proyecto por semana**: no te apresures.
3. **Empieza por consola**: antes de GUI, domina la lógica.
4. **Reutiliza código**: la clase `Lista<T>` te servirá en todos.
5. **Prueba con datos reales**: inventa estudiantes, libros, etc.

---
