public class Main {
      public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        try {
            cuenta.extraer(500);
        } catch (SaldoInsuficienteException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
