public class EjemploThrows{
    public static int Dividir(int a , int b)throws ArithmeticException{
        if(b== 0){
            throw new ArithmeticException("no se puede dividir por 0");
        }
     return a/b;
    }

 public static void main(String[] args) {
        try {
            System.out.println(Dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

}