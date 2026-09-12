public class MainGenericos {
     public static void main(String[] args) {
        // Lista de estudiantes
        Lista<Estudiante> estudiantes = new Lista<>(5);
        estudiantes.adicionar(new Estudiante("Ana", 20));
        estudiantes.adicionar(new Estudiante("Luis", 21));

        // Lista de números
        Lista<Integer> numeros = new Lista<>(10);
        numeros.adicionar(10);
        numeros.adicionar(20);

        // Mostrar
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.obtener(i));
        }

        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.obtener(i));
        }
}
