public class CuentaBancariaMain {
    public static void main(String[] args) {
        cuentaBancaria cuenta = new cuentaBancaria("juan", 12300, 2000);
   double saldoFinal = cuenta.Depositar();
        System.out.println("El saldo final es : " + saldoFinal);
    }
}
