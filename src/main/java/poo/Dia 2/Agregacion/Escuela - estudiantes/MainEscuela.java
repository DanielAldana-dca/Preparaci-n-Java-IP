// 📁 Archivo: MainEscuela.java
public class MainEscuela {
    public static void main(String[] args) {
        // 1. Crear estudiantes (existen independientemente de la escuela)
        Estudiante e1 = new Estudiante("Ana", 20);
        Estudiante e2 = new Estudiante("Luis", 21);
        Estudiante e3 = new Estudiante("Marta", 19);

        // 2. Crear la escuela
        Escuela escuela = new Escuela("UCI - Facultad 1");

        // 3. Agregar estudiantes a la escuela (agregación)
        escuela.agregarEstudiantes(e1);
        escuela.agregarEstudiantes(e2);
        escuela.agregarEstudiantes(e3);

        // 4. Mostrar información
        System.out.println("Total estudiantes: " + escuela.contarEstudiantes());
        escuela.listaEstudiantes();
    }
}