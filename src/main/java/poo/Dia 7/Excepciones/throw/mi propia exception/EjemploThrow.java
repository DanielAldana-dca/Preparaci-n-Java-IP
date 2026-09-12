public class EjemploThrow {
    public static void main(String[] args) {
        int edad = -5;

        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        System.out.println("Edad: " + edad);
    }
}