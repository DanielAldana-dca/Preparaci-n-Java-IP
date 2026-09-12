public class Gerente extends Empleado {
    public double bonus;
   public String apartamento;

   public Gerente(String nombre , double salario , double bonus , String apartamento){
    super(nombre, salario);
    this.bonus = bonus;
    this.apartamento = apartamento;
   }
   @Override
   public double calcularPago (){
     return super.calcularPago() + bonus;
   }

  
    public void mostrarDepartamento() {
        System.out.println(nombre + " dirige el departamento de " + apartamento);
    }

}
