public class Cuenta {
    private double saldo = 100;
    public void extraer (double cantidad) throws SaldoInsuficienteException{
        if(cantidad> saldo){
            throw new SaldoInsuficienteException("no tienes suficiente saldo");
        }
         saldo -= cantidad;
    }
}
