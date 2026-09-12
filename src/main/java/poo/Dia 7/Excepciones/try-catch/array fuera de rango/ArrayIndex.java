public class ArrayIndex {
   public static void main(String[] args) {
       int [] numeros = {10 , 20 , 30};
     try {
        System.out.println(numeros[5]);
     } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("ese indice no existe en el array");
     }
     System.out.println("El programa sigue");

   }
    
}