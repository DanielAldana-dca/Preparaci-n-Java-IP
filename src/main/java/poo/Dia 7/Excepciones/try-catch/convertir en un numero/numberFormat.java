public class numberFormat {
    public static void main(String[] args) {
        String texto = "abc";

        try {
            int numero = Integer.parseInt(texto);  // 💥 "abc" no es número
            System.out.println("Número: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("❌ '" + texto + "' no es un número válido");
        }

        System.out.println("El programa sigue");
    }
}