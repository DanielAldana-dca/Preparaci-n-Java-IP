public class Utilidades {
    // Método genérico que imprime un arreglo de cualquier tipo
    public static <T> void imprimirArreglo(T[] arreglo) {
        for (T elem : arreglo) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
/*
// Uso:
Integer[] nums = {1, 2, 3};
String[] palabras = {"Hola", "Mundo"};
Utilidades.imprimirArreglo(nums);
Utilidades.imprimirArreglo(palabras);  */