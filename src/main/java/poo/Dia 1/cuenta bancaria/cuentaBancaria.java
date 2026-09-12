public class cuentaBancaria {
  private String nombre ;
  private double saldoInicial;
  private double deposito;

  private double saldoFinal;
     public cuentaBancaria(String nombre , double saldoInicial , double deposito){
        this.nombre = nombre;
        this.saldoInicial = saldoInicial;
        this.deposito = deposito;
     }
     public double Depositar(){
     saldoFinal = deposito + saldoInicial; 
    double  parte = (saldoFinal*8 )/100 ;
      return saldoFinal- parte;
     }
}