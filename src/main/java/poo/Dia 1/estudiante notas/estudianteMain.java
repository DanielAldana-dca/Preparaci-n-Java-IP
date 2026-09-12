public class estudianteMain {
   public static void main(String[] args) {
    // 1. Crear el array con 25 notas
    double[] notas = {
        4.5, 5.0, 3.8, 4.2, 4.9,
        3.5, 4.8, 5.0, 4.0, 3.9,
        4.7, 4.3, 5.0, 4.6, 4.1,
        3.8, 4.4, 4.9, 5.0, 4.2,
        3.7, 4.5, 4.8, 4.9, 5.0
    };

    // 2. Crear el estudiante
    estudiante estudiante1 = new estudiante("Juan", "M", 17, notas);

    // 3. Calcular y mostrar
    double promedio = estudiante1.getPromedio();
    System.out.println("Promedio: " + promedio);
    System.out.println("¿Oro? " + estudiante1.oro());
    System.out.println("¿Docencia? " + estudiante1.docencia());
}
  
}
