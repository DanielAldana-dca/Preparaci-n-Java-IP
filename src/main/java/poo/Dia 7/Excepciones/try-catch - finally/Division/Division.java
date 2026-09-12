public class Division {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("❌ Error capturado");
        } finally {
            System.out.println("🔒 Esto se ejecuta SIEMPRE");
        }
    }
}